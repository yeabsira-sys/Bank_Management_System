import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletResponse;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpServletResponse response = (HttpServletResponse) event.getSession().getServletContext().getAttribute("org.apache.catalina.servlets.DefaultServlet");
        try {
            event.getSession().invalidate();
            response.sendRedirect("Home");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement other methods of HttpSessionListener if needed
}