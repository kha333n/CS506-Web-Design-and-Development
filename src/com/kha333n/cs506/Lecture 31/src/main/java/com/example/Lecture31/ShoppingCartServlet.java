package com.example.Lecture31;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "WebServlet", value = "/web-servlet"
)
public class ShoppingCartServlet extends HttpServlet {

    // used to generate a unique value which is
    // used as a cookie value
    public static int S_ID = 1;
    // used to store HashMaps of indiviual users
    public static HashMap<String, HashMap> globalMap = new HashMap<String, HashMap>();

    // Handles the HTTP GET method.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    // Handles the HTTP <code>POST</code> method.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    // called from both doGet() & doPost()
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // declaring user's HashMap
        HashMap<String, String> sessionInfo = null;
        String sID = "";

        // method findCookie is used to determine whether browser
        // has send any cookie named "JSESSIONID"
        Cookie c = findCookie(request);

        // if no cookies named "JSESSIONID" is recieved, means that
        // user is visiting the site for the first time.
        if (c == null) {
            // make a unique string
            sID = makeUniqueString();

            // creating a HashMap where books selected by the
            // user will be stored
            sessionInfo = new HashMap<String, String>();

            // add the user's HashMap (sessionInfo) into the
            // globalMap against unique string i.e. sID
            globalMap.put(sID, sessionInfo);

            // create a cookie named "JSESSIONID" alongwith
            // value of sID i.e. unique string
            Cookie sessionCookie = new Cookie("JSESSIONID", sID);

            // add the cookie to the response
            response.addCookie(sessionCookie);
        } else {
            // if cookie is found named "JSESSIONID",
            // retrieve a HashMap from the globalMap against
            // cookie value i.e. unique string which is your
            //sessionID
            sessionInfo = (HashMap<String, String>) globalMap.get(c.getValue());
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Shooping Cart Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Online Book Store</h1>");
        String url = "web-servlet";

        // user will submit the from to the same servlet
        out.println("<form action=" + url + ">"
                + "<h3><input type=checkbox name=firstCB value=firstCB />"
                + " java core servlts</h3>"
                + "<br>"
                + "<h3><input type=checkbox name=secondCB value=secondCB />"
                + " java how to program</h3>"
                + "<br>"
                + "<h3><input type=checkbox name=thirdCB value=thirdCB />"
                + " java complete reference</h3>"
                + "<br>"
                + "<input type=submit value=\"Add to Cart\" />"
                + "</from>");
        out.println("<br/>");
        out.println("<h1>You have selected followig books</h1>");
        out.println("<br/>");

        //reteriving params of check boxes
        String fBook = request.getParameter("firstCB");
        String sBook = request.getParameter("secondCB");
        String tBook = request.getParameter("thirdCB");

        // if first book is selected then add it to
        // user's HashMap i.e. sessionInfo
        if (fBook != null && fBook.equals("firstCB")) {
            sessionInfo.put("firstCB", "java core servlets");
        }

        // if second book is selected then add it to
        // user's HashMap i.e. sessionInfo
        if (sBook != null && sBook.equals("secondCB")) {
            sessionInfo.put("secondCB", "java how to program");
        }

        // if third book is selected then add it to
        // user's HashMap i.e. sessionInfo
        if (tBook != null && tBook.equals("thirdCB")) {
            sessionInfo.put("thirdCB", "java complete reference");
        }

        // used to display the books currently stored in
        // the user's HashMap i.e. sessionInfo
        printSessionInfo(out, sessionInfo);
        out.println("</body>");
        out.println("</html>");
        out.close();
    } // end processRequest()

    // method used to generate a unique string
    public String makeUniqueString() {
        return "ABC" + S_ID++;
    }

    // returns a reference global HashMap.
    public static HashMap findTableStoringSessions() {
        return globalMap;
    }

    // method used to find a cookie named "JSESSIONID"
    public Cookie findCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];

                if (c.getName().equals("JSESSIONID")) {

                    // doSomethingWith cookie
                    return c;
                }
            }
        }
        return null;
    }

    // used to print the books currently stored in
    // user's HashMap. i.e. sessionInfo
    public void printSessionInfo(PrintWriter out, HashMap sessionInfo) {
        String title = "";
        title = (String) sessionInfo.get("firstCB");

        if (title != null) {
            out.println("<h3> " + title + "</h3>");
        }
        title = (String) sessionInfo.get("secondCB");

        if (title != null) {
            out.println("<h3> " + title + "</h3>");
        }
        title = (String) sessionInfo.get("thirdCB");

        if (title != null) {
            out.println("<h3> " + title + "</h3>");
        }
    }
} // end ShoppingCartServlet