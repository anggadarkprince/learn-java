package com.sketchproject.mysql;

import java.sql.*;

public class Main {
    private static final String USERNAME = "angga";
    private static final String PASSWORD = "angga1234";
    private static final String CONNECTION = "jdbc:mysql://localhost/explorecalifornia";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SELECT * FROM states");

            resultSet.last();
            System.out.println("Number of rows " + resultSet.getRow());
            System.out.println("mysql connected!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if(resultSet != null) {
                resultSet.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }
}
