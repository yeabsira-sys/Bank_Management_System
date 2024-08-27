import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Header")
public class Header extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>KURATH BANK</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<header class=\"headercontainer\">");
        out.println("<div class=\"headerimage\">");
        out.println("<img src=\"./images/logo-no-background.png\" alt=\"\">");
        out.println("</div>");
        out.println("</header>");
        out.println("</body>");
        out.println("</html>");
    }
}
