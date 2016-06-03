package com.fjcasasaltas.training.jee.cdi.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjcasasaltas.training.jee.cdi.driver.DatabaseDriver;
import com.fjcasasaltas.training.jee.cdi.qualifier.Oracle;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = -4362197787344804852L;

	@Inject
	private DatabaseDriver defaultDriver;
	
	@Inject
	@Oracle
	private DatabaseDriver oracleDriver;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String driverName = req.getParameter("driverName");
		if ("oracle".equals(driverName)) {
			this.oracleDriver.connect();
			resp.getWriter().print(this.oracleDriver.getVersion());
		} else {
			this.defaultDriver.connect();
			resp.getWriter().print(this.defaultDriver.getVersion());
		}
		
	}

}
