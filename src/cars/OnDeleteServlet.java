package cars;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseOperations;

public class OnDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8936381818639002083L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = req.getSession(false);
		String user = (String) session.getAttribute("user");
		if (user != null) {
			res.setContentType("text/html");
			Enumeration<String> enums = req.getParameterNames();
			while (enums.hasMoreElements()) {
				new DatabaseOperations().deleteCar((String)enums.nextElement());
			}
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
