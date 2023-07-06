/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis.dao;

import com.sis.bean.UsersBean;
import com.sis.utility.ConnectionPool;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author gagan
 */
public class UsersDAO {
    
    static Connection conn;
   public int Register(UsersBean ub){
       conn = ConnectionPool.connectDB();
        int r = 0;
        String sql = "insert into users(name,email,address,username,password,mobile) values('"+ub.getName()+"','"+ub.getEmail()+"','"+ub.getAddress()+"','"+ub.getUsername()+"','"+ub.getPassword()+"','"+ub.getMobile()+"')";
        try{
            Statement stmt = conn.createStatement();
            r = stmt.executeUpdate(sql);
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return r;
   } 
    public int Login(String username, String password){
        int id = 0;
        conn = ConnectionPool.connectDB();
        String sql = "select sno from users where username = '"+username+"' and password = '"+password+"'";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
                id = rs.getInt("sno");
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
   public String forgotPassword(String email){
       String pwd = "";
        conn = ConnectionPool.connectDB();
        String sql = "select password from users where email = '"+email+"'";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
               pwd = rs.getString("password");
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return pwd;
   }
   public int changePassword(String email,String newPassword,String oldPassword){
       conn = ConnectionPool.connectDB();
        String select1 = "select sno from users where email='"+email+"' and password='"+oldPassword+"'";
        int id = 0;
        try {
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(select1);
             if(rs.next()){
                 String sql = "update users set password='"+newPassword+"' where email = '"+email+"'";
                 Statement stmt2 = conn.createStatement();
                 id = stmt2.executeUpdate(sql);
                 conn.close();
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
   }
   
}
