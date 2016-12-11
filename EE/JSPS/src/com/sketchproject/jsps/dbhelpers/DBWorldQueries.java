package com.sketchproject.jsps.dbhelpers;

public class DBWorldQueries {

    public static String getCitiesByDistrictByPopulation() {
        return "SELECT * FROM city";
    }

    public static String getCountriesByName() {
        return "SELECT * FROM country";
    }
}
