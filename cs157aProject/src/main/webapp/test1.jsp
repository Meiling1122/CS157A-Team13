<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test1</title>
</head>
<body>
<form action="login">
<label for="username">Username</label><br>
<input type="text" id="username" name="username"><br>
<label for="password">Password</label><br>
<input type="text" id="password" name="password"><br>
<input type="Submit" value="Submit"><br>
</form>
<% 
	String hostName = "localhost";
	String dbName = "cs157ateam13project";
	String user = "root"; // assumes database name is the same as username
	String password = "CS157A_is_Fun!";
	try {
		java.sql.Connection con; 
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	    Connection conn = DriverManager.getConnection(connectionURL, user, password);
            out.println("Initial entries in table \"hw1\": <br/>");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentaccount");
            while (rs.next()) {
                out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + "<br/><br/>");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException e) { 
            out.println("SQLException caught: " + e.getMessage()); 
        }
    %>
</body>
</html>