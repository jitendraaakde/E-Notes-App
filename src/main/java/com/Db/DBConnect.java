package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes2", "root", "Jitu8959@");
                System.out.println("Connection established successfully");
            }
        } catch (Exception e) {
            System.out.println("Connection could not be established");
            e.printStackTrace();
        }
        return conn;
    }
}
