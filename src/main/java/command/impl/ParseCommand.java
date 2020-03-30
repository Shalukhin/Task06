package command.impl;

import javax.servlet.http.HttpServletRequest;

import command.Command;
import command.PageManager;

public class ParseCommand implements Command {

	@Override
	public PageManager execute(HttpServletRequest request) {
	
		return PageManager.RESULT;
	}

}
