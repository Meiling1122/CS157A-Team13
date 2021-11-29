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

@WebServlet(urlPatterns = {"/updateClasses"})
public class UpdateClassesServlet extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		Account user = (Account)session.getAttribute("user");
		String[] courses = req.getParameterValues("courses");
		if (courses == null) {
			courses = new String[0];
		}
		int[] courseIDs = new int[courses.length];
		
		try {
			Connection conn = MySQLConn.getMySQLConnection();
			for (int i = 0; i < courses.length; i++) {
				courseIDs[i] = DBUtils.findCourseID(conn, courses[i]);
				//res.getWriter().println(courseIDs[i]);
			}
			int studentID = DBUtils.findProfileID(conn, user.getAccountID());
			int campusID = DBUtils.findStudentAccount(conn, user.getAccountID()).getCampusID();
			DBUtils.updateEnrolls(conn, courseIDs, studentID, campusID);
			session.removeAttribute("course_names");
		}
		catch (Exception e) {
			res.getWriter().println(e.getMessage());
		}
		
		res.sendRedirect("myInfoView.jsp");

	}
}