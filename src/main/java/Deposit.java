

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Deposit() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
	
		
		 out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<title> KURATH BANK</title>");
			out.print("<link rel= 'stylesheet' href='./css/managerpage.css'>");
			out.print("<link rel= 'stylesheet' href='./css/header.css'>");
			out.print("<link rel= 'stylesheet' href='./css/teller.css'>");
			out.print("<link rel= 'stylesheet' href='./css/footer.css'>");
			
			out.print("</head>");
			out.print("<body>");
			RequestDispatcher header = request.getRequestDispatcher("./Header");
	       // header.include(request, response);
	        
			
			int accountNumber = Integer.parseInt(request.getParameter("accnumber").trim());
		
			 String accholdername = request.getParameter("accholdername");
			double depositAmount = Double.valueOf( request.getParameter("amount"));
			out.print(depositAmount);
	        if (isValid(depositAmount)) {
	        	
	        	TellerFunctions fun= new TellerFunctions();
	    		TellerFunctions.TellerTasks1 fn =  fun.new ImplementationOfTellerTasks();
	    		
	    		String depositContent = " ";
	    		HttpSession session = request.getSession(false);
	            	if("false".equals(session.getAttribute("submitted"))) {
	            		out.print(" work to this");
	            		session.setAttribute("submitted", "true");
	            		depositContent = fn.makeDeposit(accholdername, accountNumber, depositAmount);
	    		}else if("true".equals(session.getAttribute("submitted"))) {
	    			response.sendRedirect("./Teller");
	    		}
	            
	    		
	    		 
	    		
	    		response.setContentType("text/html, charset=utf-8");
	    		out.print(depositContent);
	    		
	    		
	        } else {
	        	
	        	
	            out.println("Invalid AMOUNT. Please check your input.");
	        }
			
			
	        

        out.print("<a href = 'Teller'><input type='submit' value='HOME' name='action' class = 'logoutbtn'></a>");
        out.print("</body>");
		out.print("</html>");
	}
	
private boolean isValid(double amount) {
		
		return true;
	}

}
	

