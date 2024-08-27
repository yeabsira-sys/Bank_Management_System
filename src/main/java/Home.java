

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet(description = "Entry point of the system", urlPatterns = { "/Home" })
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }




	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session != null && !session.isNew()){
			session.invalidate();
		}
		
		response.setContentType("text/html, charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			out.print("<!DOCTYPE html>");
			out.print("<html>");
	        out.print("<head>");
	        out.print("<meta charset=\"UTF-8\">");
	        out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
	        out.print("<title>KURATH BANK</title>");
	        out.print("<link rel='stylesheet' type= 'text/css' href='./css/home.css'>");
	        out.print("</head>");
	        out.print("<body>");

	        // Displaying the login form to the user
	        out.print("<div class='maincontainer'>");
	        out.print("<div class='formcontainer'>");
	        out.print("<form action='pageredirector' method='post' class='loginform' name='loginf'>");
	        out.print("<label for='name' class='labelname'>Name</label>");
	        out.print("<input type='text' name='name' placeholder='User Name' class='inputvalue1' maxlength='40'><br>");
	        out.print("<label for='password' class='labelpass'>Password</label>");
	        out.print("<input type='password' name='password' placeholder='Password' class='inputvalue2' maxlength='20'><br>");
	        out.print("<input type='submit' name='login' class='submitbtn' value='Login'>");
	        out.print("<a href='../users/updatepassword.php'><input type='button' name='forgetpassword' class='forgetpasswordbtn' value='Forget Password'></a>");
	        out.print("</form></div><div class='lowerimgdiv'></div></div>");

	        out.print("</body>");
	        out.print("</html>");
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
		

        
	}

	



}
