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

@WebServlet(urlPatterns = {"/courseList"})
public class CourseListServlet extends HttpServlet{
//testing git
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		try {
			Connection conn = MySQLConn.getMySQLConnection();
			String[] course_names = DBUtils.getCourseList(conn);
			session.setAttribute("courseList", course_names);
		}
		catch (Exception e) {
			res.getWriter().println(e.getMessage());
		}
	}
}