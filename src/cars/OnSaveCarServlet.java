package cars;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseOperations;

public class OnSaveCarServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4032025598983683337L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = req.getSession(false);
		String user = (String) session.getAttribute("user");
		if (user != null) {
			String kennzeichen = req.getParameter("kennzeichen");
			int km = Integer.valueOf(req.getParameter("km"));
			new DatabaseOperations().insertCar(kennzeichen, km);

			String nextJSP = "/Ok.jsp";
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(req, res);
		} else {
			String loginJSP = "/index.html";
			dispatcher = getServletContext().getRequestDispatcher(loginJSP);
			dispatcher.forward(req, res);
		}

	}
}
