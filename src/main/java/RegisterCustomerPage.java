

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/RegisterCustomerPage")
public class RegisterCustomerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterCustomerPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
	
		
		String gender = request.getParameter("gender").trim();
        String firstName = request.getParameter("firstname").trim();
        String lastName = request.getParameter("lname").trim();
        String phone = request.getParameter("phone").trim();
        String dataofbirth = request.getParameter("birthdate").trim();
        String nationality = request.getParameter("nationality").trim();
        String region = request.getParameter("region").trim();
        String woreda = request.getParameter("woreda").trim();
        String zone = request.getParameter("zone").trim();
        String kebele = request.getParameter("kebele").trim();
        String email = request.getParameter("email").trim();
        String occupation = request.getParameter("occupation").trim();

        // Validation functions
        boolean isValid = validateFname(firstName) && validateLname(lastName) &&
                          validatePhone(phone) && validateDateOfBirth(dataofbirth) &&
                          validateNationality(nationality) && validateRegion(region) &&
                          validateWoreda(woreda) && validateZone(zone) &&
                          validateKebele(kebele) && validateEmail(email) &&
                          validateOccupation(occupation);

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
        
        if (isValid) {
        	
        	TellerFunctions fun= new TellerFunctions();
    		TellerFunctions.TellerTasks1 fn =  fun.new ImplementationOfTellerTasks();
    		
    		String registerdCustomer = " ";
    		HttpSession session = request.getSession(false);
            	if("false".equals(session.getAttribute("submitted"))) {
            		session.setAttribute("submitted", "true");
            		registerdCustomer = fn.registerCustomer(firstName, 
               				 lastName,  nationality,  region, 
               				 zone,  woreda,  kebele,  gender, 
               				 email,  occupation,  phone, dataofbirth);
    		}else if("true".equals(session.getAttribute("submitted"))) {
    			response.sendRedirect("./Teller");
    		}
            
    		
    		 
    		
    		response.setContentType("text/html, charset=utf-8");
    		out.print(registerdCustomer);
    		
    		
        } else {
        	
        	
            // If not valid, return an error message
            out.println("Invalid form data. Please check your input.");
        }
        out.print("<a href = 'Teller'><input type='submit' value='HOME' name='action' class = 'logoutbtn'></a>");
        out.print("</body>");
		out.print("</html>");
    }
	
	

    // Validation functions
    private boolean validateFname(String firstname) {
        return firstname.matches("^[a-zA-Z ]*$");
    }

    private boolean validateLname(String lastname) {
        return lastname.matches("^[a-zA-Z ]*$");
    }

    private boolean validatePhone(String phone) {
        return phone.matches("^[.0-9]*$");
    }

    private boolean validateDateOfBirth(String birthdate) {
        // You can add more sophisticated date validation logic here if needed
        return birthdate != null && !birthdate.isEmpty();
    }

    private boolean validateNationality(String nationality) {
        return nationality.matches("^[a-zA-Z ]*$");
    }

    private boolean validateRegion(String region) {
        return region.matches("^[a-zA-Z ]*$");
    }

    private boolean validateWoreda(String woreda) {
        return woreda != null && !woreda.isEmpty();
    }

    private boolean validateZone(String zone) {
        return zone != null && !zone.isEmpty();
    }

    private boolean validateKebele(String kebele) {
        return kebele != null && !kebele.isEmpty();
    }

    private boolean validateEmail(String email) {
        if (!email.isEmpty()) {
            return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        }
        return true; // If email is empty, consider it valid
    }

    private boolean validateOccupation(String occupation) {
        return occupation.matches("^[a-zA-Z ]*$");
    }

		

	}

