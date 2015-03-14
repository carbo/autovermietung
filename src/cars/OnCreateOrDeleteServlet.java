package cars;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PKW;
import database.DatabaseOperations;

public class OnCreateOrDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -571431286523826716L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String anlegen = req.getParameter("anlegen");

		HttpSession session = req.getSession(false);
		String user = (String) session.getAttribute("user");
		if (user != null) {
			if (anlegen != null) {
				String nextJSP = "/newKfz.jsp";
				dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(req, res);
			} else {
				String nextJSP = "/listForDelete.jsp";
				dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				ArrayList<PKW> autos = new DatabaseOperations().getAutos();

				req.setAttribute("autos", autos);
				dispatcher.forward(req, res);
			}
		} else {
			String loginJSP = "/index.html";
			dispatcher = getServletContext().getRequestDispatcher(loginJSP);
			dispatcher.forward(req, res);
		}

	}

}
