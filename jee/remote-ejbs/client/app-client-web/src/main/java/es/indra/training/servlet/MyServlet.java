package es.indra.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.training.ejb.MyServiceRemote;
import es.indra.training.locator.ServiceLocator;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 8218997321924997317L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doAction(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String p1 = req.getParameter("a");
		String p2 = req.getParameter("b");

		int a = Integer.parseInt(p1);
		int b = Integer.parseInt(p2);

		final MyServiceRemote service = (MyServiceRemote) ServiceLocator.lookup("MyService");

		resp.getWriter().print("SUMA = " + service.suma(a, b));

	}

}
