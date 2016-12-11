package com.sketchproject.citymanager.servlets;

import com.sketchproject.citymanager.helpers.DBWorldQueries;
import com.sketchproject.citymanager.model.DBManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListAllCountries
 */
@WebServlet("/listAllCountries.do")
public class ListAllCountries extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListAllCountries() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get the DBManager from context
        DBManager dbm = (DBManager) getServletContext().getAttribute("WorldDBManager");

        //generate the output in a StringBuilder
        StringBuilder sb = new StringBuilder("<html><body>");

        try {
            //Code Name Population
            //get the cities into a table:
            sb.append("<table border=1><tr><td>CODE</td><td>NAME</td><td>POPULATION</td></tr>");

            String query = DBWorldQueries.getCountriesByName();
            ResultSet rs = dbm.ExecuteResultSet(query);
            while (rs.next()) {
                String id = rs.getString("code");
                String name = rs.getString("country");
                int pop = rs.getInt("population");

                sb.append("<tr><td>" + id + "</td>"
                        + "<td>" + name + "</td>"
                        + "<td>" + pop + "</td></tr>");
            }
            sb.append("</table>");
        } catch (Exception e) {
            sb.append("<h1>ERROR: " + e.getMessage() + "</h1>");
        }
        sb.append("</body></html>");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(sb);
    }
}
