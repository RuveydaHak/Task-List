package com.example.finalproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Veritabani {
    protected static Connection veritabaniBaslat() throws SQLException, ClassNotFoundException {

        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";

        String dbName = "gorev_defteri";
        String dbUserName = "root";
        String dbPassword = "";

        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(dbURL + dbName, dbUserName, dbPassword);
        return conn;
    }
}
