import domain.ConferenceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import repositories.ConferenceApplicationRepository;
import web.AddApplicantServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class TestAddApplicantServlet extends Mockito {

    @Spy
    ConferenceApplicationRepository repository = mock(ConferenceApplicationRepository.class);

    @InjectMocks
    AddApplicantServlet servlet;

    @Test
    public void servletShouldWriteInfoAboutApplicantIntoSession() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        servlet.doGet(request, response);
        verify(session).setAttribute(eq("conf"), Mockito.any(ConferenceApplication.class));
    }
    @Test
    public void servletShouldAddFormDataIntoRepository() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        servlet.doGet(request, response);
        verify(repository).add(Mockito.any(ConferenceApplication.class));
    }
    @Test
    public void servletShouldProperlyRedirectUser() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        servlet.doGet(request,response);
        verify(response).sendRedirect("success.jsp");
    }
}
