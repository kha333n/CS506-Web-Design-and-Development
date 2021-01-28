package com.example.Lecture30;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "includeServlet", value = "/include-servlet")
public class includeServlet extends HttpServlet {
    // this method is being called by both doGet() and doPost()
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
// Obtaining the object of PrintWriter, this will return the
// same PrintWriter object we have in MyServlet
        PrintWriter out = response.getWriter();
// Including a HTML tag using PrintWriter
        out.println("<h1> <marquee>I am included </marquee></h1>");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
