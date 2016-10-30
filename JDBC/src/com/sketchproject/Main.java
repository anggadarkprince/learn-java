package com.sketchproject;

import com.sketchproject.beans.Admin;
import com.sketchproject.tables.AdminManager;
import com.sketchproject.tables.States;
import com.sketchproject.tables.Tours;
import com.sketchproject.utils.ConnectionManager;
import com.sketchproject.utils.DBType;
import com.sketchproject.utils.DBUtil;
import com.sketchproject.utils.InputHelper;

import java.sql.*;
import java.util.ArrayList;

/**
 * JDBC
 * Created by Angga on 29/07/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting application");

        ConnectionManager.getInstance().setDBType(DBType.MYSQL);

        System.out.println("Table list");
        getTableList();

        System.out.println("Select All data");
        selectData();

        System.out.println("\nSelect by Less Price");
        selectDataArgument();

        System.out.println("\nSelect by Less Price via Procedure");
        selectDataProcedure();

        System.out.println("\nSelect by Less Price via Procedure with Out Param");
        selectDataProcedureWithOutParam();

        System.out.println("View single data");
        viewData();

        System.out.println("Insert data");
        insertData();

        System.out.println("Update data");
        updateData(true);

        System.out.println("Delete data");
        deleteData(true);

        System.out.println("Transaction");
        manualTransaction();

        ConnectionManager.getInstance().close();
    }

    private static void getTableList() throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        ResultSet rsTables = null;
        ResultSet rsColumns = null;
        ArrayList<String> tables = new ArrayList<>();

        try {
            DatabaseMetaData metadata = connection.getMetaData();
            String[] tableTypes = {"TABLE"};
            rsTables = metadata.getTables("explorecalifornia", "%", "%", tableTypes);
            while (rsTables.next()) {
                tables.add(rsTables.getString("TABLE_NAME"));
            }

            for (String tableName : tables) {
                System.out.println("Table: " + tableName);
                System.out.println("----------------");

                rsColumns = metadata.getColumns(null, "%", tableName, "%");

                while (rsColumns.next()) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(rsColumns.getString("COLUMN_NAME"));
                    buffer.append(": ");
                    buffer.append(rsColumns.getString("TYPE_NAME"));
                    System.out.println(buffer.toString());
                }

                System.out.println("");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            rsTables.close();
        }
    }

    private static void manualTransaction() throws Exception {
        // http://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html
        AdminManager.displayAllRows();

        Admin bean1 = new Admin(1, "explorerone", "secreet");
        Admin bean2 = new Admin(5, "nothing", "shouldbefail");

        Connection connection = ConnectionManager.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean transaction1 = AdminManager.update(bean1);
        boolean transaction2 = AdminManager.update(bean2);

        if (transaction1 && transaction2) {
            connection.commit();
            System.out.println("Success!");
            System.out.println("Transaction committed");
        } else {
            connection.rollback();
            System.err.println("whoops!");
            System.err.println("Transaction rolled back");
        }
    }

    private static void selectData() {
        try (
                Connection connection = DBUtil.getConnection(DBType.MYSQL);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery("SELECT * FROM states")
        ) {
            resultSet.beforeFirst();
            States.displayData(resultSet);

            resultSet.last();
            System.out.println("Number of rows: " + resultSet.getRow());

            resultSet.first();
            System.out.println("The first state is " + resultSet.getString("stateName"));

            resultSet.last();
            System.out.println("The last state is " + resultSet.getString("stateName"));

            resultSet.absolute(10);
            System.out.println("The 10th state is " + resultSet.getString("stateName"));


            System.out.println("connected!");
        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }

    private static void selectDataArgument() throws SQLException {
        final String SQL = "SELECT * FROM tours WHERE price <= ?";
        double maxPrice = 0;
        try {
            maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
        } catch (NumberFormatException e) {
            System.err.println("Error: invalid number");
        }

        ResultSet resultSet = null;
        try (
                Connection connection = DBUtil.getConnection(DBType.HSQLDB);
                PreparedStatement statement = connection.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            statement.setDouble(1, maxPrice);
            resultSet = statement.executeQuery();
            Tours.displayData(resultSet);

        } catch (SQLException e) {
            DBUtil.processException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    private static void selectDataProcedure() throws SQLException {
        final String SQL = "{CALL GetToursByPrice(?)}";
        double maxPrice = 0;
        try {
            maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
        } catch (NumberFormatException e) {
            System.err.println("Error: invalid number");
        }

        ResultSet resultSet = null;
        try (
                Connection connection = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement statement = connection.prepareCall(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            statement.setDouble(1, maxPrice);
            resultSet = statement.executeQuery();
            Tours.displayData(resultSet);

        } catch (SQLException e) {
            DBUtil.processException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    private static void selectDataProcedureWithOutParam() throws SQLException {
        final String SQL = "{CALL GetToursWithCountByPrice(?, ?)}";
        double maxPrice = 0;
        try {
            maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
        } catch (NumberFormatException e) {
            System.err.println("Error: invalid number");
        }

        ResultSet resultSet = null;
        try (
                Connection connection = DBUtil.getConnection(DBType.MYSQL);
                CallableStatement statement = connection.prepareCall(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            statement.setDouble(1, maxPrice);
            statement.registerOutParameter("total", Types.INTEGER);
            resultSet = statement.executeQuery();

            int nRows = statement.getInt("total");
            Tours.displayData(resultSet, nRows);
        } catch (SQLException e) {
            DBUtil.processException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    private static void viewData() throws SQLException {
        AdminManager.displayAllRows();

        int adminId = InputHelper.getIntegerInput("Select a row: ");

        Admin bean = AdminManager.getRow(adminId);

        if (bean == null) {
            System.err.println("No rows were found");
        } else {
            System.out.println("Admin id: " + bean.getAdminId());
            System.out.println("User name: " + bean.getUserName());
            System.out.println("Password: " + bean.getPassword());
        }
    }

    private static void insertData() throws Exception {
        Admin beanCreate = new Admin();
        beanCreate.setUserName(InputHelper.getInput("Username: "));
        beanCreate.setPassword(InputHelper.getInput("Password: "));
        if (AdminManager.insert(beanCreate)) {
            System.out.println("New row with primary key " + beanCreate.getAdminId() + " was inserted!");
        }
    }

    private static void updateData(boolean resultSetUpdate) throws Exception {
        AdminManager.displayAllRows();

        int adminId = InputHelper.getIntegerInput("Select a row to update: ");

        Admin bean = AdminManager.getRow(adminId);
        if (bean == null) {
            System.err.println("Row not found");
            return;
        }

        String password = InputHelper.getInput("Enter new password: ");
        bean.setPassword(password);

        boolean update = resultSetUpdate ? AdminManager.updateRS(bean) : AdminManager.update(bean);

        if (update) {
            System.out.println("Success!");
        } else {
            System.err.println("whoops!");
        }
    }

    private static void deleteData(boolean resultSetDelete) throws Exception {
        AdminManager.displayAllRows();

        int adminId = InputHelper.getIntegerInput("Select a row to delete: ");

        boolean delete = resultSetDelete ? AdminManager.deleteRs(adminId) : AdminManager.delete(adminId);

        if (delete) {
            System.out.println("Success!");
        } else {
            System.err.println("Nothing to delete!");
        }
    }
}
