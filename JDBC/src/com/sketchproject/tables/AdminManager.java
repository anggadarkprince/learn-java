package com.sketchproject.tables;

import com.sketchproject.beans.Admin;
import com.sketchproject.utils.ConnectionManager;
import com.sketchproject.utils.DBType;
import com.sketchproject.utils.DBUtil;

import java.sql.*;

public class AdminManager {

    private static Connection connection = ConnectionManager.getInstance().getConnection();

    public static void displayAllRows() throws SQLException {
        String sql = "SELECT adminId, userName, password FROM admin";
        try (
                //Connection connection = DBUtil.getConnection(DBType.MYSQL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            System.out.println("Admin Table:");
            while (resultSet.next()) {
                StringBuffer bf = new StringBuffer();
                bf.append(resultSet.getInt("adminId") + ": ");
                bf.append(resultSet.getString("userName") + ", ");
                bf.append(resultSet.getString("password"));
                System.out.println(bf.toString());
            }
        }
    }

    public static Admin getRow(int adminId) throws SQLException {
        String sql = "SELECT * FROM admin WHERE adminId = ?";
        ResultSet resultSet = null;

        try (
                //Connection connection = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, adminId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Admin bean = new Admin();
                bean.setAdminId(adminId);
                bean.setUserName(resultSet.getString("userName"));
                bean.setPassword(resultSet.getString("password"));
                return bean;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public static boolean insert(Admin bean) throws Exception {
        String sql = "INSERT INTO admin (userName, password) VALUES (?, ?)";
        ResultSet keys = null;
        try (
                //Connection connection = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, bean.getUserName());
            preparedStatement.setString(2, bean.getPassword());
            int affected = preparedStatement.executeUpdate();

            if (affected == 1) {
                keys = preparedStatement.getGeneratedKeys();
                keys.next();
                int newKey = keys.getInt(1);
                bean.setAdminId(newKey);
            } else {
                System.err.println("No rows affected");
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            if (keys != null) keys.close();
        }
        return true;
    }

    public static boolean update(Admin bean) throws Exception {

        String sql = "UPDATE admin SET userName = ?, password = ? WHERE adminId = ?";
        try (
                //Connection connection = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, bean.getUserName());
            preparedStatement.setString(2, bean.getPassword());
            preparedStatement.setInt(3, bean.getAdminId());

            int affected = preparedStatement.executeUpdate();
            return affected == 1;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean updateRS(Admin bean) throws Exception {
        String sql = "SELECT * FROM admin WHERE adminId = ?";

        ResultSet resultSet = null;
        try (
                //Connection connection = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)
        ) {
            preparedStatement.setInt(1, bean.getAdminId());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSet.updateString("userName", bean.getUserName());
                resultSet.updateString("password", bean.getPassword());
                resultSet.updateRow();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            if (resultSet != null) resultSet.close();
        }
    }

    public static boolean delete(int adminId) throws Exception {
        String sql = "DELETE FROM admin WHERE adminId = ?";
        try (
                //Connection connection = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, adminId);
            int affected = preparedStatement.executeUpdate();

            return affected == 1;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean deleteRs(int adminId) throws Exception {
        String sql = "SELECT * FROM admin WHERE adminId = ?";
        ResultSet resultSet;
        try (
                //Connection connection = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)
        ) {
            preparedStatement.setInt(1, adminId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSet.deleteRow();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
