package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;


@WebFilter(servletNames = {"AddApplicantServlet"})
public abstract class ApplicationDataInSessionFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if(session.getAttribute("conf")!=null) {
            response.getWriter().print("Twoje zgloszenie zostalo juz przeslane.");
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
    public void init(FilterConfig arg0) throws ServletException {

    }

}
