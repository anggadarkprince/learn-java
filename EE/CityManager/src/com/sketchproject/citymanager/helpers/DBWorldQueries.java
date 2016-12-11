package com.sketchproject.citymanager.helpers;

public class DBWorldQueries {
    public static String getCitiesByDistrictByPopulation() {
        return "SELECT * FROM city";
    }

    public static String getCountriesByName() {
        return "SELECT * FROM country";
    }
}
