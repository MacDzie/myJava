package web.filters;

import repositories.DummyConferenceApplicationRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Filter;

@WebFilter({"/","/add"})
public abstract class RegistrationClosedFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (new DummyConferenceApplicationRepository().count()>5){
            response.getWriter().print("Rejestracja na konferencje zakonczyla sie.");
            return;
        }
        chain.doFilter(request, response);
    }
}
