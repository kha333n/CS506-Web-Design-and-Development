package com.example.Lecture29;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(
        name = "ReadingInt", value = "/reading-int" ,
        initParams =
                {
        @WebInitParam(name = "logfilename", value = "logoutput.txt")
    }
)

public class ReadingInt extends HelloServlet{
    // attribute used to store init-parameter value
    String fileName;
    // overriding init() method
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
// reading init-parameter "logfilename" stored in web.xml
        fileName = config.getInitParameter("logfilename");
    }
    /*
     * Both doGet() & doPost() methods are override over here. processRequest()
     * is called from both these methods. This makes possible for a servlet to
     * handle both POST and GET requests identically.
     */
// Handles the HTTP GET request type
    public void doGet(HttpServletRequest request,
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
    // called from doGet() & doPost()
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
// writing init-parameter value that is store in fileName
        out.println(fileName);
        out.close();
    }
}
