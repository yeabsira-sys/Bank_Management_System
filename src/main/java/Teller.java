

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Teller")



public class Teller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    class TellerForms {
    	DBConnector dbConnector = DBConnector.getInstance();
        Connection connection = dbConnector.getConnection();

    	public void registerCustomerForm(HttpServletResponse response) throws ServletException, IOException  {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		

    		out.print("<div id='customer-registration'>");
    		out.print("<form action='RegisterCustomerPage' #customer-registration' class='customerregistrationform' name='cusregister' method='post'>");
    		out.print("<div class='infocontainer'>");
    		out.print("<div class='nameholder'>");
    		out.print("<div class=' values'>");
    		out.print("<label for='firstname'>First Name</label><br>");
    		out.print("<input class='valu' type='text' required name='firstname' class='name'><br>");
    		out.print("<span class='fname_error'></span>");
    		out.print("</div>");
    		out.print("<div class='values'>");
    		out.print("<label for='lname'>Last Name</label><br>");
    		out.print("<input class='valu' type='text' required name='lname' class='l_name'><br>");
    		out.print(" <span class='lname_error'></span></div></div>");
    		out.print("<div class='phonedate'>");
    		out.print("<div class=' values'>");
    		out.print("<label for='phone'>Phone Number</label><br>");
    		out.print("<input class='valu' type='number'  name='phone' class='phone_no'><br>");
    		out.print("<span class='pho_error'></span></div>");
    		out.print("<div class=' values'>");
    		out.print("<label for='birthdate'>Date of Birth</label><br>");
    		out.print(" <input class='valu' type='date'  name='birthdate' class='birthdate'><br>");
    		out.print("<span class='birtherror'></span> </div></div>");
    		out.print("<div class='nationregion'>");
    		out.print("<div class=' values'>");
    		out.print("<label for='nation'>Nationality</label><br>");
    		out.print("<input class='valu' type='text'  name='nationality' class='nationality'><br>");
    		out.print("<span class='nation_error'></span></div>");
    		out.print(" <div class=' values'>");
    		out.print("<label for='region'>Region</label><br>");
    		out.print("<input class='valu' type='text'  name='region' class='region'><br>");
    		out.print("<span class='region_error'></span>");
    		out.print(" </div></div><div class='zoneworeda'>");
    		out.print("<div class=' values'>");
    		out.print("<label for='zone'>Zone</label><br>");
    		out.print("<input class='valu' type='text'  name='zone' class='zone'><br>");
    		out.print("<span class='zone_error error'></span> </div>");
    		out.print("<div class=' values'>");
    		out.print("<label for='woreda'>Woreda</label><br>");
    		out.print("<input class='valu' type='text'  name='woreda' class='woreda'><br>");
    		out.print("<span class='wereda_error'></span></div> </div>");
    		out.print("<div class='kebelegend'>");
    		out.print("<div class=' values'>");
    		out.print("<label for='kebele'>Kebele</label><br>");
    		out.print("<input class='valu' type='text'  name='kebele' class='kebele'><br>");
    		out.print("<span class='kebele_error'></span></div>");
    		out.print("<div class=' values'>");
    		out.print(" <label for='sex'>Gender</label><br>");
    		out.print("<select name='gender' id='genderid'>");
    		out.print("<option class='valu' value='female'>Female</option>");
    		out.print("<option class='valu' value='male'>Male</option> </select></div></div>");
    		out.print("<div class='emailoccupation'>");
    		out.print("<div class=' values'>");
    		out.print("<label for='email'>Email</label><br>");
    		out.print("<input class='valu' type='email'  name='email' class='email'><br>");
    		out.print("<span class='email_error'></span> </div>");
    		out.print("<div class=' values'>");
    		out.print("<label for='occupation'>Occupation</label><br>");
    		out.print("<input class='valu' type='text'  name='occupation' class='ocupation'><br>");
    		out.print("<span class='occupation_error'></span></div> </div><div>");
    		out.print("<input type='submit' name='creatcustomer' value='Regiter' class='btnRegister'>");
    		out.print("<input type='reset' name='clear' value='Clear' class='btnclear'>");
    		out.print("</div></div></form> </div>");   
           
    	}
    	
    	public void makeWithdrawForm(HttpServletResponse response) throws  ServletException, IOException  {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		   out.print("<div class='withdrawform'>");
            out.print("<form action='' name='withdrawform' class='withdraw' method='post'>");
            out.print("<div><label for='acno'>Acount number</label><br>");
            out.print("<input type='number' name='acno' placeholder='account.no' required><br>");
            out.print("<small class='acno-error'></small><br>");
            out.print(" <input type='submit' name='withdaccn' class='btnRegister' value='Enter'>");
            out.print("</div></form></div>");
    	}
    	
    	public void makeDepositForm(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.print("<div class='depositform'>");
    		out.print("<form action='' name='depositeform' class='deposit' method='post'>");
    		out.print("<div><label for='acno'>Acount number</label><br>");
    		out.print("<input type='number' name='acno' placeholder='account.no' required><br>");
    		out.print("<small class='acno-error'></small><br>");
    		out.print("<input type='submit' name='action' class='btnRegister' value='Enter'>");
    		out.print("</div></form> </div>");
 
    	}
    	
    	public void makeTransferForm(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html,charset=utf-8");
    		PrintWriter out = response.getWriter();
    		
    		out.print("<div class='transferform'>");
    		out.print("<form action='' name='transferform' method='post'>");
    		out.print("<label for='senderacno'>Sender Account.no</label><br>");
    		out.print("<input type='number' class='senderacno' name='senderacno' required placeholder='sender account'><br>");
    		out.print("<label for='receivereracno'>Resiever Account.no</label><br>");
    		out.print("<input type='number' name='receiveracno' class='receivereracno' placeholder='receiver account' required><br>");
    		out.print("<input type='submit' name='transfermoney' class='btnRegister' value='transfer'>");
    		out.print("</form></div>");
  
    	}

    	
    	public void seeCustomerTransactionForm(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html, charset=utf-8");
    		PrintWriter out = response.getWriter();
    		
    		out.print("<div class='transaccountdiv'>");
    		out.print("<form action='' name='transaccount' class='transaccount' method='post'><div>");
    		out.print("<label for='accno'>Account Number</label><br>");
    		out.print("<input type='number' name='accno' required placeholder='account number'><br>");
    		out.print("</div><input type='submit' name='transacno' class='btnRegister'>");
    		out.print("</form> </div>");

    	}
    	
    	public void checkBalanceForm(HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html, charset=utf-8");
    		PrintWriter out = response.getWriter();
    		out.print("<div class='showbal'>");
    		out.print("<form action='' class='veiwbalance' name='veiwbalance' method='post'>");
    		out.print("<label for='veiwbalacno'>Enter Account Number</label><br>");
    		out.print("<input type='number' required name='veiwbalacno' class='veiwbalacno'><br>");
    		out.print("<input type='submit' name='veiWbalance' class='btnRegister'>");
    		out.print(" </form></div>");
  
    	}
    	
    	public void renderDepositForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html, charset=utf-8");
    		PrintWriter out = response.getWriter();
    		
			int accountNumber =Integer.parseInt( request.getParameter("acno").trim()); 
			
			
	        if (isValid(accountNumber)) {
	        
	            try {
	            	 String getAccountNumberqur = "SELECT first_name, last_name, account_number, closed FROM customer WHERE account_number = ?";
	        PreparedStatement getAccountNumber = connection.prepareStatement(getAccountNumberqur);
	        getAccountNumber.setInt(1, accountNumber);
	        ResultSet resultSet = getAccountNumber.executeQuery();
	        if(!resultSet.next()) {
	        	out.print("<div class='depositform'><h1>THEIR IS NO ACCOUNT</h1>");
               out.print("<p>enter correct account number</p></div>") ;
	        }else if (resultSet.getString("closed") == "true") {
	        	out.print("<div class='depositform'><h1>ACCOUNT IS NOT ACCESSIBLE</h1> </div>");
   	        }else {
   	        out.print("<div class='depositform'>");
   	     out.print("<form action='Deposit' method='post' name='accholderinfo' class='deposit'><div>");
   	  out.print("<label for='name'>Name</label>");   
               
   	out.print("  <input type='text' name='accholdername' readonly value=" + resultSet.getString("first_name")+ " "+ resultSet.getString("last_name")+ "><br></div>");
           out.print("<div><label for='name'>Account Number</label>");
           out.print("<input type='text' name='accnumber' readonly value="+resultSet.getInt("account_number")+ "><br></div>");
           out.print("<div><label for='amount'>Enter Amount</label>");
           out.print("<input type='number' name='amount' placeholder='amount' required><br></div>");
           out.print("<div><input type='submit' name='makedeposit' value='deposit' class='btnRegister'></div>");
           out.print(" </form>");
   	        }
	            }catch(SQLException e) {
	            	e.printStackTrace();
	            }

        } else {
        	out.print("<div class='depositform'>");
        	out.print(" <h1><INVALID ACCOUNT NUMBER></h1></div>");
        	
            }
		   
    	}
    
    }
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession();
         

    	 if(session == null || session.isNew() ) {
    		 response.sendRedirect("Home");
    	 }
    			  session.setAttribute("submitted", "false");
    	 
               
    	 
    		 response.setContentType("text/html, charset=utf-8");
			PrintWriter out = response.getWriter();
			TellerForms forms = new TellerForms();
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
	           header.include(request, response);
	           
			out.print("<div class='mainmanagercontainer'>");
			out.print("<div class='rightsideman'>");
			out.print("<div class='tellertasks'>");
			out.print("<form action='Teller' class='listener' name='t_task' method='post'>");
	        out.print("<input type='submit' value='Register Customer' name='action' value='registercustomer'>");
	        out.print("<input type='submit' value='Make Deposit' name='action' value='makedeposit'>");
	        out.print("<input type='submit' value='Make Withdraw' name='action' value='makewithdraw'>");
	        out.print("<input type='submit' value='Make Transfer' name='action' value='maketransfer'>");
	        out.print("<input type='submit' value='Check Balance' name='action' value='checkbalance'>");
	        out.print("<input type='submit' value='Customer Transaction' name='action' value='customertransaction'>");
	        out.print("</form></div> </div>");
			out.print("<div class='leftsideman'>");
			
			String action = request.getParameter("action");
			if (action != null) {
            switch (action) {
                case "Register Customer":
                	forms.registerCustomerForm(response);
                    break;
                case "Make Deposit":
                	forms.makeDepositForm(response);
                    break;
                case "Make Withdraw":
                	forms.makeWithdrawForm(response);
                    break;
                case "Make Transfer":
                	forms.makeTransferForm(response);
                    break;
                case "Check Balance":
                	forms.checkBalanceForm(response);
                    break;
                case "Customer Transaction":
                	forms.seeCustomerTransactionForm(response);
                    break;
                case "Enter":
                	forms.renderDepositForm(request, response);
                    break;
                default:
                    break;
            }
         
    	 }
		
			

		    	  RequestDispatcher footer = request.getRequestDispatcher("./Fotter");
           footer.include(request, response);
     
        
           if (request.getParameter("logout") != null) {
               
               response.sendRedirect("Home");
           }
		 out.print("<script src='./js/customerRegistrationValidation.js'></script>");
		 out.print("<script src='./js/footer.js'></script>");
		out.print("</body>");
		out.print("</html>");
		
		 
	}
	
private boolean isValid(int accountNumber) {
		
	String acno = Integer.toString(accountNumber);
	if (acno.length() != 7) {
		return false;
	}else {
		return true;
	}
	  
	}
}
