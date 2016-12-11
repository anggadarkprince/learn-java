package com.worldmanager.dbhelpers;

public class DBWorldQueries {
    public static String getCitiesByDistrictByPopulation() {
        return "select * from city";
    }

    public static String getCountriesByName() {
        return "select * from country";
    }
}
