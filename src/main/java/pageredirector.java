import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pageredirector")
public class pageredirector extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DBConnector dbConnector = DBConnector.getInstance();
    Connection connection = dbConnector.getConnection();
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html; charset=utf-8");
	PrintWriter out = response.getWriter();
		
		String username = request.getParameter("name");
        String password = request.getParameter("password");
		try {
			String query = "SELECT * FROM user WHERE user_name = ? AND password = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, username);
	        statement.setString(2, password);
	        ResultSet resultSet = statement.executeQuery();
	        
	        if(resultSet.next()) {
	        	out.print("<h1>"+resultSet.getString("password")+"</h1>");
	        	String role =  resultSet.getString("user_type");
	        	String capitalizedrole = role.isEmpty() ? role : Character.toUpperCase(role.charAt(0)) + role.substring(1);
	        	int id = Integer.parseInt(resultSet.getString("user_id"));
	        	 out.print("<h1>" + id +"</h1>");
	        	String getNamequery = "SELECT * FROM employee WHERE employee_id = ?";
	        	
	        	 PreparedStatement getName = connection.prepareStatement(getNamequery);
	        	 getName.setInt(1, id);
	 	        ResultSet nameResult = getName.executeQuery();
	 	       if(nameResult.next()) {
	 	    	    String fname = nameResult.getString("first_name");
	 	       String lname = nameResult.getString("last_name");
	 	      String name = fname+ " " + lname;
	        	HttpSession session = request.getSession(true);
	            session.setAttribute("username", name);
	            session.setAttribute("role", capitalizedrole);
	            session.setMaxInactiveInterval(300);
	            	response.sendRedirect( capitalizedrole);
	 	       }else {
	 	    	  out.print("<h1> there unconditional error on fetching data </h1>");
	 	       }
	 	       
	        }else {
	        	response.sendRedirect("Home");
	        }
	        

	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.getMessage();
	    }
	}
}
