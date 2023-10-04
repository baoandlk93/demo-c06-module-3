package com.codegym.democ06.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/demo_c06";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    public static Connection getConnectDB() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
