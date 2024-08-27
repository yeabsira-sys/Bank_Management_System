

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



interface TellerTasks {
	public void registerCustomer(HttpServletRequest request);
	public void makeWithdraw(HttpServletRequest request);
	public void makeDeposit(HttpServletRequest request);
	public void makeTransfer(HttpServletRequest request);
	public void checkBalance(HttpServletRequest request);
	public void seeCustomerTransaction(HttpServletRequest request);
}

//implementation of the interface class abstracted functions

class ImplementationOfTellerTasks implements TellerTasks{
	 
	 String firstName, lastName, nationality, region, zone, woreda, kebele, gender, email, occupation, phoneNumber;
	 private static Date date;

	 
	 

	@Override 
	public void registerCustomer(HttpServletRequest request){
		
		firstName = request.getParameter("firstName");
		lastName= request.getParameter("lname");
			nationality = request.getParameter("nationality");
				region = request.getParameter("region");
				zone = request.getParameter("zone");
				woreda = request.getParameter("woreda");
				kebele = request.getParameter("kebele");
				gender = request.getParameter("gender");
				email = request.getParameter("email");
				occupation = request.getParameter("");
				phoneNumber  = request.getParameter("phone");
	}
	
	@Override 
	public void makeWithdraw(HttpServletRequest request){
		
	}
	
	@Override 
	public void makeDeposit(HttpServletRequest request){
		
	}
	
	@Override 
	public void makeTransfer(HttpServletRequest request){
		
	}
	
	
	@Override 
	public void checkBalance(HttpServletRequest request){
		
	}
	
	@Override 
	public void seeCustomerTransaction(HttpServletRequest request){
		
	}
	
} 

@WebServlet("/TellerTasksImplementation")
public class TellerTasksImplementation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public TellerTasksImplementation() {
        super();
    }
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
		out.print("<div>");
		out.print("<h1>  the new content</h1>");
		out.print("</div>");
	}

}
