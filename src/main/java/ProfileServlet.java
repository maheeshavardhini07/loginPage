import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session != null) {
            String name = (String) session.getAttribute("name");
            String profile = "Hello, " + name + " Welcome to Profile!!";
            req.setAttribute("profile", profile);
            req.getRequestDispatcher("link.jsp").include(req, resp);
        } else {
            String profile = "Please login first";
            req.setAttribute("profile", profile);
            req.getRequestDispatcher("login.jsp").include(req, resp);  
        }
    }
}
