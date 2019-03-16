package web;

import domain.ConferenceApplication;
import repositories.ConferenceApplicationRepository;
import repositories.DummyConferenceApplicationRepository;

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

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("conf") != null){
            response.getWriter().println("Powtórne wypełnienie formularza zostało zablokowane.");
            return;
        }
        ConferenceApplication application = retrieveApplicationFromRequest(request);
        ConferenceApplicationRepository repository = new DummyConferenceApplicationRepository();


        session.setAttribute("conf", application);

        repository.add(application);
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
