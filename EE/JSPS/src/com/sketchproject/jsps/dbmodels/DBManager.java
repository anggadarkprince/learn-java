package com.sketchproject.jsps.dbmodels;

import java.io.Serializable;
import java.sql.*;

public class DBManager implements Serializable {
    private static final long serialVersionUID = 1L;
    Connection connection = null;
    ServerConnectionBehavior scb = null;

    public DBManager() {

    }

    public DBManager(ServerConnectionBehavior conBehavior) {
        scb = conBehavior;
    }

    public boolean setConnectionBehavior(ServerConnectionBehavior value) {
        if (value == null) {
            throw new IllegalArgumentException("Please use a valid connection behavior");
        }
        scb = value;
        return true;
    }

    public boolean openConnection() {
        try {
            if (scb == null) {
                throw new IllegalArgumentException("Define "
                        + "a connection behavior");
            }
            if (connection != null) closeConnection(false);
            connection = scb.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (connection == null) return false;
        return true;
    }

    public boolean closeConnection(boolean keepAlive) {
        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
            if (!keepAlive) {
                connection = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean isConnected() {
        return connection != null;
    }

    public boolean ExecuteNonQuery(String query) {
        try {
            Statement st = connection.createStatement();
            int i = st.executeUpdate(query);
            if (i == -1) {
                //log it
                return false;
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultSet ExecuteResultSet(String query) throws SQLException {
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        return rs;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getConnectionURL() {
        return scb.getConnectionURL();
    }

    public String getTablesSchemaQuery() {
        return scb.getTablesSchemaQuery();
    }
}
