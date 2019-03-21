package web;

import domain.ConferenceApplication;
import repositories.ConferenceApplicationRepository;
import repositories.DummyConferenceApplicationRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add")
public class AddApplicantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ConferenceApplicationRepository repository;

    public void init(ServletConfig config) throws ServletException{
        repository = new DummyConferenceApplicationRepository();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ConferenceApplication application = retrieveApplicationFromRequest(request);
        repository.add(application);
        session.setAttribute("conf", application);
        response.sendRedirect("success.jsp");
    }
    private ConferenceApplication retrieveApplicationFromRequest(HttpServletRequest request){
        ConferenceApplication result = new ConferenceApplication();
        result.setName(request.getParameter("name"));
        result.setSurname(request.getParameter("surname"));
        result.setAdvertisement(request.getParameter("info"));
        result.setEmail(request.getParameter("email"));
        result.setEmployment(request.getParameter("employment"));
        return result;
    }
}
