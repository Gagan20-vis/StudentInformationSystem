/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis.utility;

/**
 *
 * @author gagan
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionPool {
    static Connection conn;
    public static Connection connectDB(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","Gagan@20");
                System.out.println("Database Connected");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return conn;
    }
    
}
