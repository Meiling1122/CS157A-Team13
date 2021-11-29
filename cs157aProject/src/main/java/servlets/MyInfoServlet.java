package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs157aProject.DBUtils;
import cs157aProject.MySQLConn;
import model.Account;
import model.StudentAccount;

@WebServlet(urlPatterns = {"/myInfo"})
public class MyInfoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		Account user = (Account)session.getAttribute("user");
		int accountID = user.getAccountID();


		try {
			Connection conn = MySQLConn.getMySQLConnection();
			StudentAccount studentUser = DBUtils.findStudentAccount(conn, accountID);
			String campus_name = DBUtils.campusLookup(conn, studentUser.getCampusID());
			int profileID = DBUtils.findProfileID(conn, accountID);
			int[] enrollments = DBUtils.findEnrollments(conn, profileID);
			String[] courseNames = new String[enrollments.length];
			for (int i = 0; i < enrollments.length; i++) {
				courseNames[i] = DBUtils.findCourseName(conn, enrollments[i]);
			}
			
			session.setAttribute("course_names", courseNames);
			session.setAttribute("campus", campus_name);
			session.setAttribute("studentAccount", studentUser);
			
			//res.sendRedirect("myInfoView.jsp");
			//out.println("accountID = " + user.getAccountID());
		}
		catch (Exception e) {
			e.printStackTrace();
			res.getWriter().println(e.getMessage());
		}
	}

}