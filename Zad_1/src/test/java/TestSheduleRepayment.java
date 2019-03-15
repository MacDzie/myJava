import org.junit.Test;
import org.mockito.Mockito;
import servlets.SheduleRepayment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestSheduleRepayment extends Mockito {

    @Test
    public void servlet_should_not_greet_the_user_if_the_data_are_null() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);
        SheduleRepayment repayment = new SheduleRepayment();

        when(request.getParameter("creditSum")).thenReturn(null);
        when(request.getParameter("lendingRate")).thenReturn(null);
        when(request.getParameter("repaymentCount")).thenReturn(null);
        when(request.getParameter("flatCharge")).thenReturn(null);

        repayment.doPost(request, response);

        verify(response).sendRedirect("/");
    }
    @Test
    public void servlet_should_not_greet_the_user_if_the_data_are_empty() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);
        SheduleRepayment repayment = new SheduleRepayment();

        when(request.getParameter("creditSum")).thenReturn("");
        when(request.getParameter("lendingRate")).thenReturn("");
        when(request.getParameter("repaymentCount")).thenReturn("");
        when(request.getParameter("flatCharge")).thenReturn("");

        repayment.doPost(request, response);

        verify(response).sendRedirect("/");
    }
    @Test
    public void servlet_should_greet_the_user_when_the_data_are_provided() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

        when(request.getParameter("creditSum")).thenReturn("100000");
        when(request.getParameter("lendingRate")).thenReturn("5");
        when(request.getParameter("repaymentCount")).thenReturn("120");
        when(request.getParameter("flatCharge")).thenReturn("10");

        new SheduleRepayment().doPost(request, response);

        verify(writer).println("100000512010");
    }
}