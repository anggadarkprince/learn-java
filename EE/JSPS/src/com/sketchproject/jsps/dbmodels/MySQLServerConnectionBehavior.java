package com.sketchproject.jsps.dbmodels;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLServerConnectionBehavior extends DBUserInfo implements ServerConnectionBehavior {
    public MySQLServerConnectionBehavior() {
        super();
    }

    public MySQLServerConnectionBehavior(String uid, String pwd, String cat) {
        super(uid, pwd, cat);
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            return DriverManager.getConnection(getConnectionURL());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getConnectionURL() {
        return String.format("jdbc:mysql://localhost/%s?user=%s&password=%s&useSSL=false&serverTimezone=UTC"
                , getCatalog()
                , getUserID()
                , getPassword());
    }

    @Override
    public String getConnectionDetails() {
        return "MySQL Database Connection to " + getCatalog();
    }

    @Override
    public String getTablesSchemaQuery() {
        return "select table_name from information_schema.tables "
                + "where table_schema = " + getCatalog();
    }
}
