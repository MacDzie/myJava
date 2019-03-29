package web.filters;

import web.servlets.RegistrationServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebFilter(servletNames = "register", filterName = "RegisterFilter")
public class RegisterFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("name");
        String pass = request.getParameter("pass");
        String cPass = request.getParameter("cPass");
        if (pass.equals(cPass)){
            RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
            rs.include(request,response);
            chain.doFilter(request,response);
        } else {
            out.println("<font color=red>Password is not the same with confirm password.</font>");

            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.include(request, response);

        }

    }
    public void destroy() {

    }

}
