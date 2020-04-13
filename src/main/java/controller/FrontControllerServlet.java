package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import command.CommandProvider;
import command.constant.PageManager;

public class FrontControllerServlet extends HttpServlet{

	private static final long serialVersionUID = -5618225533764372191L;
	
	private final static Logger LOGGER = LogManager.getLogger(FrontControllerServlet.class.getName());
	
	private CommandProvider commandProvider = new CommandProvider();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) {		
				
		try {
			PageManager page = commandProvider.getCommand(req.getParameter("command")).execute(req, resp);
			req.getRequestDispatcher(page.getPage()).forward(req, resp);
		} catch (Exception e) {
			LOGGER.error("Error request", e);
		}
	}	

}
