package login;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseOperations;
import model.PKW;
import model.User;

public class OnServletLogin extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6691683505412367859L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        RequestDispatcher dispatcher = null;
        DatabaseOperations databaseOperations = new DatabaseOperations();

        User userObjekt = null;
        String user = req.getParameter("userName");
        String pass = req.getParameter("userPassword");
        userObjekt = databaseOperations.getUser(userObjekt);

        if (user != null && user.equals(userObjekt.getName().trim()) && pass.equals(userObjekt.getPassword().trim())) {
        	ArrayList<PKW> autos =  databaseOperations.getAutos();
        	String nextJSP = "/list.jsp";
        	HttpSession session=req.getSession();  
        	session.setAttribute("user",user);  
        	dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        	
            req.setAttribute("autos",autos);
        	dispatcher.forward(req,res);
        }
        else {
        	dispatcher = getServletContext().getRequestDispatcher("/errorAuth.jsp");
        	dispatcher.forward(req, res);
        }
            
    }
}
