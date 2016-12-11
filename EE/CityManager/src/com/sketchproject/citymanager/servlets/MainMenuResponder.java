package com.sketchproject.citymanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainMenuResponder
 */
@WebServlet("/menuResponder.do")
public class MainMenuResponder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainMenuResponder() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // get the form parameter that was posted -- the parameter name is the name of the option select
        String userChoice = request.getParameter("menuChoice");
        String[] userOptions = request.getParameterValues("adminOptions");
        StringBuilder params = new StringBuilder("");
        String queryStringParams = "";
        if (userOptions != null) {
            boolean isFirst = true;
            for (int i = 0; i < userOptions.length; i++) {
                if (!isFirst) {
                    params.append("&");
                } else {
                    params.append("?");
                }

                if (userOptions[i].equalsIgnoreCase("useDB")) {
                    params.append("useDB=1");
                } else if (userOptions[i].equalsIgnoreCase("sendEmail")) {
                    params.append("sendEmail=1");
                }
                isFirst = false;
            }
            queryStringParams = params.toString();
        }


        //instead of posting data, transfer to the correct option
        //out.println("<html><body><h1>Main Menu Handler</h1><p>User Choice: " + userChoice + "</p></body></html>");

        // Redirect to specific page
        if (userChoice.equals("1")) {
            response.sendRedirect("ListCities.html" + queryStringParams);
        } else if (userChoice.equals("2")) {
            response.sendRedirect("AddCity.html" + queryStringParams);
        } else if (userChoice.equals("3")) {
            response.sendRedirect("DeleteCity.html" + queryStringParams);
        } else {
            response.sendRedirect("index.html");
        }
    }

}
