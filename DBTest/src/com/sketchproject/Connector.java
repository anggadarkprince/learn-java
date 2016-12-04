package com.sketchproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by angga on 06/11/16.
 */
public class Connector {
    private static String url = "jdbc:mysql://localhost/sandbox?useSSL=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "anggaari";

    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
