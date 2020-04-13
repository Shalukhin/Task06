package command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.constant.PageManager;

public class ErrorCommand implements Command {

	@Override
	public PageManager execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return PageManager.ERROR;
	}

}
