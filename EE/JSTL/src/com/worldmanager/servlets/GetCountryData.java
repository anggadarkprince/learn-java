package com.worldmanager.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.worldmanager.dbhelpers.DBWorldQueries;
import com.worldmanager.dbmodels.DBManager;
import com.worldmanager.models.Country;

/**
 * Servlet implementation class GetCountryData
 */
@WebServlet("/getcountrydata.do")
public class GetCountryData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryData() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //make sure user is logged in
        String target = "";
        HttpSession s = request.getSession();
        if (s.getAttribute("authorized_user") != null) {
            //get the countries and direct on
            if (getServletContext().getAttribute("WorldDBManager") != null) {
                DBManager dbm = (DBManager) getServletContext().getAttribute("WorldDBManager");
                if (!dbm.isConnected()) {
                    if (!dbm.openConnection()) {
                        //log it
                        throw new IOException("Could not connect to database and open connection");
                    }
                }

                //build a list of country objects using the query
                ArrayList<Country> allCountries = new ArrayList<Country>();
                String query = DBWorldQueries.getCountriesByName();
                try {
                    ResultSet rs = dbm.ExecuteResultSet(query);
                    while (rs.next()) {
                        Country c = new Country();
                        c.setCode(rs.getString("Code"));
                        c.setName(rs.getString("Country"));
                        c.setPopulation(rs.getInt("Population"));
                        allCountries.add(c);
                        s.setAttribute("countryData", allCountries);
                    }
                } catch (Exception ex) {
                    //log it
                    throw new IOException("Query could not be executed for get all countries by name");
                }
                target = "listCountries.jsp";
            }
        } else {
            target = "login.jsp?dest=listCountries";
        }
        response.sendRedirect(target);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
