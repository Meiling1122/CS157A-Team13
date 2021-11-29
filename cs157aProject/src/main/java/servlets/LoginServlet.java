package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs157aProject.DBUtils;
import cs157aProject.MySQLConn;
import model.Account;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		PrintWriter out = res.getWriter();
		out.println("Entered username: " + username + " Entered password: " + password);
		
		Account user = null;
		
		try {
			
			Connection conn = MySQLConn.getMySQLConnection();
			user = DBUtils.findUser(conn, username, password);
			//out.println("accountID = " + user.getAccountID());
		}
		catch (Exception e) {
			e.printStackTrace();
			out.println(e.getMessage());
		}
		
		if (user == null) {
			res.sendRedirect("login.jsp");
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			res.sendRedirect("homepage.jsp");
		}
	}
}