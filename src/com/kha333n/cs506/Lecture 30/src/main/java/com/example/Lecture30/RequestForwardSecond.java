package com.example.Lecture30;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestForwardSecond", value = "/request-forward-second")
public class RequestForwardSecond extends HttpServlet {
    // this method is being called by both doGet() and doPost()
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
// obtaining values of name and salary text fields of index.html
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        /*
         * getting attribute value that has been set by the calling servlet i.e.
         * FirstServlet
         */
        String tax = (String) request.getAttribute("tax");
// generating HTML tags using PrintWriter
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SecondServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Welcome " + name + "</h1>");
        out.println("<h3> Salary " + salary + "</h3>");
        out.println("<h3> Tax " + tax + "</h3>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    // This method is calling processRequest()
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // This method is calling processRequest()
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
