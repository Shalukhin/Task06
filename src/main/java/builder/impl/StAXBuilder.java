package builder.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import builder.AbstractBuilder;
import builder.util.FlowersTag;
import entity.Flower;
import entity.GrowingTip;
import entity.VisualParameter;
import exception.ParserException;

public class StAXBuilder extends AbstractBuilder {

	private XMLInputFactory factory;

	private static final Logger LOGGER = LogManager.getLogger(StAXBuilder.class);

	private StAXBuilder() {
		factory = XMLInputFactory.newInstance();
	}

	public static StAXBuilder getInstance() {
		return new StAXBuilder();
	}

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void buildSetFlowers(File file) throws ParserException {
		validator.validate(file);
		try (FileInputStream fileInputStream = new FileInputStream(file)) {
			XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);
			String name;
			while (reader.hasNext()) {
				if (reader.next() == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (FlowersTag.FLOWER.getTagName().equals(name)) {
						buildFlower(reader);
						flowers.add(currentFlower);
					}
				}
			}
		} catch (IOException | XMLStreamException e) {
			LOGGER.warn("Illegal file \n" + e);
			throw new ParserException("Illegal file ", e);
		}
	}

	private void buildFlower(XMLStreamReader reader) throws XMLStreamException, ParserException {
		currentFlower = new Flower();
		for (int i = 0; i < reader.getAttributeCount(); i++) {
			setFlowerAttribute(reader.getAttributeLocalName(i), reader.getAttributeValue(i));
		}
		String name;
		while (reader.hasNext()) {
			switch (reader.next()) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				if (FlowersTag.PARAMETERS.getTagName().equals(name)) {
					currentParameter = new VisualParameter();
				} else if (FlowersTag.TIPS.getTagName().equals(name)) {
					currentTip = new GrowingTip();
				} else {
					setParameter(name, reader);
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (FlowersTag.FLOWER.getTagName().equals(name)) {
					return;
				} else if (FlowersTag.PARAMETERS.getTagName().equals(name)) {
					currentFlower.addVisualParamenter(currentParameter);
				} else if (FlowersTag.TIPS.getTagName().equals(name)) {
					currentFlower.addGrowingTip(currentTip);
				}
				break;
			}

		}
	}

	private void setParameter(String name, XMLStreamReader reader) throws XMLStreamException, ParserException {
		Optional<FlowersTag> currentTag = FlowersTag.getFlowersTag(name);
		String value = getTextParameter(reader);
		if (!currentTag.isPresent() || value.isEmpty()) {
			return;
		}
		setParameter(value, currentTag.get());
	}

	private String getTextParameter(XMLStreamReader reader) throws XMLStreamException {
		String text = new String();
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText().trim();
		}
		return text;
	}
}
