package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "hello",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double name =Double.parseDouble(request.getParameter("name"));
       if(name==null || name.equals(""))
        {
            response.sendRedirect("/");
        }
        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello "
            + name
            + "</h1>");
    }
}
