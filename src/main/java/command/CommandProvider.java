package command;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import command.impl.ErrorCommand;
import command.impl.ParseCommand;

import static command.CommandName.*;

public class CommandProvider {
	private static final Logger LOGGER = LogManager.getLogger(CommandProvider.class.getName());

	private Map<CommandName, Command> repository = new HashMap<>();

	public CommandProvider() {
		repository.put(PARSE, new ParseCommand());
		repository.put(ERROR, new ErrorCommand());

	}

	public Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (Exception e) {
			LOGGER.error("Error_bad_command");
			command = repository.get(ERROR);
		}
		return command;
	}
}
