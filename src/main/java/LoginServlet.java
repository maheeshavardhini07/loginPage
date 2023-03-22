import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String invalid = null;
        String pswrd = null;
        String uname = null;
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC","root","")){
            String sql = "SELECT password, name from credential where PASSWORD=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, password);
            ResultSet rset = (ResultSet) statement.executeQuery();
            while(rset.next()){
                pswrd = rset.getString("password");
                uname = rset.getString("name");
            }
            statement.close();
            rset.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (password.equals(pswrd)&&name.equals(uname)) {
            invalid = "Welcome, "+ name;
            req.setAttribute("invalid", invalid);
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            req.getRequestDispatcher("link.jsp").include(req, resp);
        } else {
            invalid = "Sorry, username or password Invalid!";
            req.setAttribute("invalid", invalid);
            req.getRequestDispatcher("login.jsp").include(req, resp);
            
        }

    }
}
