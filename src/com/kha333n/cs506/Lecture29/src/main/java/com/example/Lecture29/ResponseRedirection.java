package com.example.Lecture29;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "ResponseRedirection", value = "/response-redirect"
)
public class ResponseRedirection extends HttpServlet {
    // Handles the HTTP GET request type
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    // Handles the HTTP POST request type
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("userid");
        String pwd = request.getParameter("pwd");
// comparing id & password with fix values
        if (id.equals("ali") && pwd.equals("vu")) {
// redirectign user to welcome.html
            response.sendRedirect("welcome.html");
        } else {
// redirecting user to register.html
            response.sendRedirect("register.html");
            /*
             * if you want to display an error message to the user, you can use
             * the following method response.sendError(
             * response.SC_PROXY_AUTHENTICATION_REQUIRED, "Send Error Demo" );
             */
        } // end else
    }
}
