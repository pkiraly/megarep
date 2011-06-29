package org.kirunews.struts;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kirunews.util.ApplInfo;
import org.kirunews.util.Repository;

public class InitializerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InitializerServlet() {
		super();
		System.out.println("Hello out!");
		System.err.println("Hello err!");
		try {
			init();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}
	
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
		File confDir = new File(cfg.getServletContext().getRealPath("../../conf"));
		ApplInfo.init(confDir);
	}
}
