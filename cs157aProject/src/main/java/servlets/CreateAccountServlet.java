package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs157aProject.DBUtils;
import cs157aProject.MySQLConn;


@WebServlet(urlPatterns = {"/createAccount"})
public class CreateAccountServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		res.getWriter().println("Entered username: " + username + "Entered password: " + password);
		
		try {
			Connection conn = MySQLConn.getMySQLConnection();
			DBUtils.createAccount(conn, username, password);
			res.getWriter().println("account created");
		}
		catch (Exception e) {
			e.printStackTrace();
			res.getWriter().println(e.getMessage());
		}
	}

}