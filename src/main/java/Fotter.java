import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.catalina.Session;

import java.io.*;
@WebServlet("/Fotter")
public class Fotter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<div class=\"footercontainer\">");
        out.println("<div class=\"userinfo\">");
        out.println("<div class=\"logout\">");
        out.println("<form action=\"\" method=\"post\">");
        out.println("<input type=\"submit\" name=\"logout\" value=\"Logout\" class=\"logoutbtn\">");
        out.println("</form>");
        HttpSession session = request.getSession(false);

        
        
        out.println("</div>");
        out.println("<div class=\"username\">");
        
       if(session != null) {
    	    String username = (String) session.getAttribute("username");
        if (username != null) {
            out.println(username);
       }
       
        }
        
        out.println("</div>");
        out.println("<dix class=\"user\">");
        out.println("<form action=\"\" method=\"post\">");
        out.println("<input type=\"submit\" class=\"userbtn\" name=\"updpass\" value=\"update password\">");
        out.println("</form>");
        out.println("</dix>");
        out.println("</div>");
        out.println("<div class=\"datetime\">");
        out.println("<div class=\"jsdate\">");
        out.println("<span id=\"day\">day</span>,");
        out.println("<span id=\"date\">00</span>");
        out.println("<span id=\"month\">month</span>,");
        out.println("<span id=\"year\">0000</span>");
        out.println("</div>");
        out.println("<div class=\"jstime\">");
        out.println("<span id=\"hour\">00</span>:");
        out.println("<span id=\"minute\">00</span>:");
        out.println("<span id=\"seconds\">00</span>:");
        out.println("<span id=\"ampm\">00</span>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
    
    }
}
