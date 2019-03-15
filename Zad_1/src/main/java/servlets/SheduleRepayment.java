package servlets;

        import com.itextpdf.text.DocumentException;
        import org.xhtmlrenderer.pdf.ITextRenderer;
        import org.xhtmlrenderer.resource.FSEntityResolver;
        import org.xml.sax.ErrorHandler;
        import org.xml.sax.SAXException;

        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.*;
        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.parsers.ParserConfigurationException;
        import java.io.ByteArrayInputStream;
        import java.io.IOException;
        import java.io.OutputStream;
        import java.io.PrintWriter;
        import java.util.Formatter;
        import java.util.Locale;

        import static java.lang.Math.pow;

@WebServlet(name = "repayment", urlPatterns = "/repayment")
public class SheduleRepayment extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String kindRepayment = request.getParameter("kindRepayment");
        String action = request.getParameter("action");
        String creditSum = request.getParameter("creditSum");
        String lendingRate = request.getParameter("lendingRate");
        String repaymentCount = request.getParameter("repaymentCount");
        String flatCharge = request.getParameter("flatCharge");
        lendingRate = lendingRate.replace(',', '.');

        if (creditSum == null || creditSum.equals("") || lendingRate == null || lendingRate.equals("") || repaymentCount == null || repaymentCount.equals("") || flatCharge == null || flatCharge.equals("")) {
            response.sendRedirect("/");
        }

        double cCreditSum = Double.parseDouble(creditSum);
        double cLendingRate = Double.parseDouble(lendingRate);
        int cRepaymentCount = Integer.parseInt(repaymentCount);
        double cFlatCharge = Double.parseDouble(flatCharge);

        if (cCreditSum <= 0 || cLendingRate <= 0 || cRepaymentCount <= 0 || cFlatCharge < 0) {
            response.sendRedirect("/");
        }

        if (action.contentEquals("createPdf")) {
            generatePdf(shedule(kindRepayment, cRepaymentCount, cLendingRate, cFlatCharge, cCreditSum), response);
        } else {
            response.setContentType("text/html");
            response.getWriter().println(shedule(kindRepayment, cRepaymentCount, cLendingRate, cFlatCharge, cCreditSum));
        }
    }
        private String shedule(String kindRepayment, int repaymentCount, double lendingRate, double flatCharge, double creditSum) {

            StringBuilder stringBuilder = new StringBuilder();
            Formatter formatter = new Formatter(stringBuilder, Locale.US);
            double convPercent = lendingRate / 100;

            if (kindRepayment.contentEquals("constantRepayment")) {

                double q = 1 + (convPercent / 12);
                double consRate = (creditSum + flatCharge) * (pow(q, repaymentCount)) * (q - 1) / ((pow(q, repaymentCount)) - 1);
                double capitalConstant;
                double interestConstant;

                stringBuilder.append("<center><h1>Harmonogram splaty rat stalych</h1></center><table border='1' align='center'><tr><th>Nr Raty</th><th>Kwota kapitalu</th><th>Kwota odsetek</th><th>Oplaty stale</th><th>Calkowita kwota raty</th></tr>");

                for (int i = 1; i <= repaymentCount; i++) {

                    interestConstant = creditSum * convPercent / 12;
                    capitalConstant = consRate - interestConstant;
                    creditSum = creditSum - capitalConstant;

                    formatter.format("<tr><th>" + i + "</th><th>" + "%.2f" + "</th><th>" + "%.2f" + "</th><th>" + "%.2f" + "</th><th>" + "%.2f" + "</th></tr>", capitalConstant, interestConstant, flatCharge, consRate);

                }
                stringBuilder.append("</table>");

            } else if ((kindRepayment.contentEquals("fallRepayment"))) {

                double instalmentFall;
                double interestFall;
                double capital = (creditSum / repaymentCount);

                stringBuilder.append("<center><h1>Harmonogram splaty rat malejacych</h1></center><table border='1' align='center'><tr><th>Nr Raty</th><th>Kwota kapitalu</th><th>Kwota odsetek</th><th>Oplaty stale</th><th>Calkowita kwota raty</th></tr>");

                for (int i = 1; i <= repaymentCount; i++) {

                    instalmentFall = (creditSum / repaymentCount) * ((1 + ((repaymentCount - i + 1) * (convPercent / 12)))) + flatCharge;
                    interestFall = instalmentFall - capital - flatCharge;

                    formatter.format("<tr><th>" + i + "</th><th>" + "%.2f" + "</th><th>" + "%.2f" + "</th><th>" + "%.2f" + "</th><th>" + "%.2f" + "</th></tr>", capital, interestFall, flatCharge, instalmentFall);
                }
                stringBuilder.append("</table>");
            } else {
                stringBuilder.append("NOK!");
            }

            return stringBuilder.toString();
        }
        private void generatePdf(String html, HttpServletResponse response) throws IOException {

            String prefix = "<!DOCTYPE html><html><head><title>Harmonogram splaty rat kredytu</title></head><body>";
            String postfix = "</body></html>";
            html = prefix + html + postfix;

            response.setHeader("Cache-Control", "no-cache");
            response.setContentType("application/pdf");
            response.setHeader("Content-Diposition","attachment; filename=\"" + "SheduleRepayment.pdf\"");
            response.setHeader("Cache-Control","no-cache");

            OutputStream outS = response.getOutputStream();
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(false);
            DocumentBuilder builder;
            try {
                builder = documentBuilderFactory.newDocumentBuilder();
                builder.setEntityResolver(FSEntityResolver.instance());
                org.w3c.dom.Document document;
                document = builder.parse(new ByteArrayInputStream(html.getBytes()));

                ITextRenderer itextrenderer = new ITextRenderer();
                itextrenderer.setDocument(document, null);
                itextrenderer.layout();
                itextrenderer.createPDF(outS, true);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            outS.flush();
            outS.close();
        }
}