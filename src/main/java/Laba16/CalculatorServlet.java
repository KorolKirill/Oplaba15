package Laba16;

import Laba16.CalculatorLab16;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hello
        String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");
        String cParam = request.getParameter("c");
        String dParam = request.getParameter("d");
        String typeOfEquation = request.getParameter("equation");

        try {
            CalculatorLab16 calculator = CalculatorLab16.getInstance();
            double result = calculator.calculateEquation(aParam, bParam, cParam, dParam, typeOfEquation);
            request.getSession().setMaxInactiveInterval(60 * 60 * 24 * 2); //Это в секундах
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<html><head><title>Cool calculator</title></head><body>");
            out.printf("<h2>The result is: %f</h2>", result);
            out.println("</body></html>");

        } catch (Throwable e) {
            response.sendRedirect("eror-page.html");
        }
    }

}
