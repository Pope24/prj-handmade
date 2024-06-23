package com.configuration.database;

import java.sql.*;
public class DBConnection {
    private static String user = "as";
    private static String password = "123456";
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=handmade;user="+user+";password="+password+";encrypt=false";
    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
