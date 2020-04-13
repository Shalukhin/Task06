package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import builder.AbstractBuilder;
import builder.impl.DOMBuilder;
import builder.impl.SAXBuilder;
import builder.impl.StAXBuilder;
import exception.ParserException;

public class BuilderFactory {

	private static final Logger LOGGER = LogManager.getLogger(BuilderFactory.class);

	private enum BuilderType {
		DOM, SAX, STAX;
	}

	private BuilderFactory() {
	}

	private static class BuilderFactoryInstanceHolder {
		public static final BuilderFactory INSTANCE = new BuilderFactory();
	}

	public static BuilderFactory getInstance() {
		return BuilderFactoryInstanceHolder.INSTANCE;
	}

	public AbstractBuilder getBuilder(String type) throws ParserException {
		try {
			BuilderType factoryType = BuilderType.valueOf(type.toUpperCase());
			switch (factoryType) {
			case DOM:
				return DOMBuilder.getInstance();
			case SAX:
				return SAXBuilder.getInstance();
			case STAX:
				return StAXBuilder.getInstance();
			default:
				LOGGER.warn("Illegal type " + type);
				throw new ParserException("Illegal type " + type);
			}
		} catch (IllegalArgumentException e) {
			LOGGER.warn("Illegal parser type " + type);
			throw new ParserException("Illegal parser type " + type, e);
		}
	}
}
