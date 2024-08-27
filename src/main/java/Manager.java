

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.io.*;



/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    class Forms{

    	public void registerEmployeeForm(HttpServletResponse response) throws ServletException, IOException  {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.print("<form action='ManagerTasksImplementation' class='emoregistrationform' name='empregiter' method='post'>");
    		out.print("<div class='infocontainer'><div class='nameholder'> <div class=' values>");
    		out.print("<label for='fname'>First Name</label><br>");
    		out.print("<input class='valu' type='text' required name='fname' class='name'><br>");  
    		out.print("<span class='fname_error'></span>");
    		out.print("</div>");
    		out.print(" <div class='values'>");
    		out.print(" <label for='lname'>Last Name</label><br>");
    		out.print("<input class='valu' type='text' require name='lname' class='l_name'><br>");     
    		out.print("<span class='lname_error'></span>");
    		out.print("</div></div><div class='phonedate>");
    		out.print("<div class=' values'>");
    		out.print("<label for='phone'>Phone Number</label><br>");
    		out.print("<input class='valu' type='text' name='phone' class='phone_no'><br>");
    		out.print("<span class='pho_error'></span></div>");
    		out.print("<div class=' values'>");
    		out.print("<label for='birthdate'>Date of Birth</label><br>");
    		out.print("<input class='valu' type='date'  name='birthdate' class='birthdate'><br>");
    		out.print("<span class='birtherror'></span></div></div>");
    		out.print("<div class='phonedate'>");
    		out.print("<div class=' values'>");
    		out.print("<label for='nation'>Nationality</label><br>");
    		out.print("<input class='valu' type='text'  name='nationality' class='nationality'><br>");
    		out.print("<span class='nation_error></span></div>");
    		out.print("<div class='values'>");
    		out.print("<label for'regio'>Region</label><br>");
    		out.print("<input class'val' type'tex'  name'region' class='region'><br>");
    		out.print(" <span class='region_error'></span> </div></div>");
    		out.print("<div class='phonedate'>");
    		out.print("<div class' values'>");
    		out.print("<label for='zone'>Zone</label><br>");
    		out.print("<input class='valu' type='text'  name='zone'class='zone'><br>"); 
    		out.print("<span class='zone_error error'></span> </div>");
    		out.print("<div class=' values'>");
    		out.print("<label for='woreda'>Woreda</label><br>");
    		out.print("<input class='valu' type='text'  name='woreda' class='woreda'><br>");
    		out.print(" <span class='wereda_error'></span></div></div>");
    		out.print("<div class='phonedate'>");
    		out.print("<div class=' values'>");
    		out.print("<label for='kebele'>Kebele</label><br>");
    		out.print("<input class='valu' type='text'  name='kebele' class='kebele'><br>");
    		out.print("<span class='kebele_error'></span></div>");
    		out.print("<div class=' values'>");
    		out.print("<label for='sex'>Gender</label><br>");
    		out.print("<select name='gender' id='genderid'>");
    		out.print("<option class='valu' value='female'>Female</option>");
    		out.print("<option class='valu' value='male'>Male</option>");
    		out.print(" </select> </div></div>");
    		out.print("<div class='phonedate'>");
    		out.print("<div class=' values'>");
    		out.print(" <label for='email'>Email</label><br>");
    		out.print("<input class='valu' type='email'  name='email' class='email'><br>");         
    		out.print(" <span class='email_error'></span>");
    		out.print("</div> <div class=' values'>");
    		out.print("<label for='role'>Role</label><br>");
    		out.print("<input class='value' type='text'  name='role' class='role' require><br>");
    		out.print("<span class='role_error'></span>");
    		out.print("</div></div>");
    		out.print("<div class='phonedate'>");           
    		out.print("<div class=' values'>");
    		out.print("<label for='salary'>Salary</label><br>");
    		out.print("<input class='valu' type='number'  name='salary' class='salary'><br>");
    		out.print("<span class='salary_error'></span>");
    		out.print("</div></div><div>");
    		out.print("<input type='submit' name='submit' value='Regiter' class='btnRegister'>");
    		out.print("<input type='reset' name='clear' value='Clear' class='btnclear'>");
    		out.print("</div> </div> </form>");
    	}
    	
    	public void removeEmployeeForm(HttpServletResponse response) throws  ServletException, IOException  {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.print("<div class='removeemployee userregpage'>");
    		out.print("<form action='ManagerTasksImplementation' name='rememployee' method='post' class='rememployee-form'>");
    		out.print("<div class='empnameholder'>");
    		out.print("<label for='name'>Employee Name</label><br>");
    		out.print("<input type='text' require placeholder='name' name='empname'><br>");
    		out.print("<span class='name-error'></span>");
    		out.print("</div><div class='empid'>");
    		out.print("<label for='name'>Employee ID</label><br>");
    		out.print("<input type='number' require placeholder='ID' name='empid'><br>");
    		out.print("<span class='empid-error'></span></div>");
    		out.print(" <div class='button'>");
    		out.print("<input type='submit' value='delete' name='delete' class='btnRegister'>");
    		out.print("</div></form></div>");	       
    	}
    	
    	public void registerUserForm(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.print("<div class='userregpage' id='userregpage'>");
    		out.print("<form action='ManagerTasksImplementation' class='user-registration-form' method='post' name='crtuser'>");
    		out.print(" <div class='uservalue'>");
    		out.print(" <label for='id'>User's id here</label><br>");
    		out.print("<input class='valu' type='number' required name='id' class='id'><br>");
    		out.print("<span class='userid_error'></span>");
    		out.print(" </div><div class='uservalue'>");
    		out.print("<label for='role'>User's Role</label><br>");
    		out.print("<select name='role' id='userroleid'>");
    		out.print("<option value='teller'>Teller</option>");
    		out.print("<option value='cashier'>Cashier</option>");
    		out.print("<option value='ouditer'>Ouditer</option>");
    		out.print("<option value='loanofficer'>Loan Officer</option>");
    		out.print("<option value='manager'>Manager</option>");
    		out.print("</select></div>");
    		out.print("<div class='createbtn'>");
    		out.print("<input type='submit' name='createuser' value='create' class='btnRegister'>");
    		out.print("</div></form> </div> "); 
    	}
    	
    	public void blockAccountForm(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html,charset=utf-8");
    		PrintWriter out = response.getWriter();
    		
    		out.print("<div class='blockaccdiv'>");
    		out.print("<form action='ManagerTasksImplementation' name='blockacno' class='blockacno' method='post'>");
    		out.print("<div>");
    		out.print("<label for='acno'>Acount number</label><br>");
    		out.print(" <input type='number' name='acno' placeholder='account.no' required><br>");
    		out.print("<small class='acno-error'></small><br>");
    		out.print(" <input type='submit' name='blockthis' class='btnRegister' value='Enter'>");
    		out.print("</div></form></div>");
    	}
    	
    	public void updateAccount(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html, charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.print("<div class='updatediv'>");
    		out.print("<form action='ManagerTasksImplementation' name='udateaccname' class='updateaccname' method='post'>");
    		out.print("<div>");
    		out.print("<label for='account'>Enter Account Number</label><br>");
    		out.print("<input type='number' required name='account' placeholder='account.no'>");
    		out.print("</div><div>");
    		out.print("<input type='submit' name='update' class='btnRegister' value='update'>");
    		out.print(" </div></form></div>");

    	}
    	
    	public void closeAccountForm(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html, charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.print(" <div class='closeaccdiv'>");
    		out.print("<form action='ManagerTasksImplementation' class='closeaccount' method='post'>");
    		out.print("<div>");
    		out.print("<label for='acno'>Account Number</label><br>");
    		out.print("<input type='number' required name='acno' placeholder='account.no'>");
    		out.print("</div>");
    		out.print("<input type='submit' class='btnRegister' name='closethis' value='close'>");
    		out.print("</form> </div>");
 
    	}
    	
    	public void seeLogFileForm(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html, charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.print(" <div class='transaccountdiv'>");
    		out.print("<form action='Manager' name='transaccount' class='transaccount' method='post><div>");
    		out.print("<label for='accno'>Account Number</label><br>");
    		out.print("<input type='number' name='accno' required placeholder='account number'><br></div>");
    		out.print("<input type='submit' name='transacno' class='btnRegister' value='Transactions'>");
    		out.print("</form></div>");

    	}
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		HttpSession session = request.getSession(false);
        

   	 if(session.getAttribute("role") == null ) {
   		 response.sendRedirect("Home");
   	 }else if(!session.getAttribute("role").equals("Manager")) {
   		 response.sendRedirect("Home");
   	 }
		Forms forms = new Forms();

		
		
		response.setContentType("text/html, charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title> KURATH BANK</title>");
		out.print("<link rel= 'stylesheet' href='./css/managerpage.css'>");
		out.print("<link rel= 'stylesheet' href='./css/teller.css'>");
		out.print("<link rel= 'stylesheet' href='./css/footer.css'>");
		out.print("<link rel= 'stylesheet' href='./css/header.css'>");
		
		out.print("</head>");
		out.print("<body>");
		
		RequestDispatcher header = request.getRequestDispatcher("./Header");
        header.include(request, response);
        
		out.print("<div class='mainmanagercontainer'>");
		out.print("<div class='rightsideman'>");
		out.print("<div class='tellertasks'>");
		out.print("<form action='Manager' class='listener' name='t_task' method='post'>");
        out.print("<input type='submit' value='Register Employee' name='action' value='registercustomer'>");
        out.print("<input type='submit' value='Remove Employee' name='action' value='makedeposit'>");
        out.print("<input type='submit' value='Register User' name='action' value='makewithdraw'>");
        out.print("<input type='submit' value='Block Account' name='action' value='maketransfer'>");
        out.print("<input type='submit' value='Update Account' name='action' value='checkbalance'>");
        out.print("<input type='submit' value='Close Account' name='action' value='customertransaction'>");
        out.print("<input type='submit' value='See Log File' name='action' >");
        out.print("</form></div> </div>");
		out.print("<div class='leftsideman'>");
		
		String action = request.getParameter("action");
		
		if (action != null) {
        switch (action) {
            case "Register Employee":
            	forms.registerEmployeeForm(response);
                break;
            case "Remove Employee":
            	forms.removeEmployeeForm(response);
                break;
            case "Register User":
            	forms.registerUserForm(response);
                break;
            case "Block Account":
            	forms.blockAccountForm(response);
                break;
            case "Update Account":
            	forms.updateAccount(response);
                break;
            case "Close Account":
            	forms.closeAccountForm(response);
                break;
            case "See Log File":
            	forms.seeLogFileForm(response);
                break;
            default:
                // Handle other actions or invalid actions
                break;
        }
		
	}
  	  RequestDispatcher footer = request.getRequestDispatcher("./Fotter");
      footer.include(request, response);

   
      if (request.getParameter("logout") != null) {
          
          response.sendRedirect("Home");
      }
     
       
	out.print("</div> </div>");
	
	 out.print("<script src='./js/registrationEmpValidation.js'></script>");
	 out.print("<script src='./js/footer.js'></script>");
	 out.print("<script src='./js/creatusernalidation.js'></script>");

	out.print("</body>");
	out.print("</html>");
	out.close();

	}
		


}
