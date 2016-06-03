package com.fjcasasaltas.training.jee.jpa.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjcasasaltas.training.jee.jpa.business.MyServiceLocal;

public class MyServlet extends HttpServlet {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1237065959744932293L;

	@EJB
	private MyServiceLocal myService;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print(this.myService.executeQueries());
	}
}
