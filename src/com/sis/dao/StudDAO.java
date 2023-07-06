/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis.dao;

import com.sis.bean.StudBean;
import com.sis.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gagan
 */
public class StudDAO {
    static Connection conn;
    private String findGrade(int sub1,int sub2,int sub3 ,int sub4){
        int sum = sub1+sub2+sub3+sub4;
        if(sum>=370) return "A+";
        else if(sum>=330 && sum<370) return "A";
        else if(sum>=320 && sum<350) return "B+";
        else if(sum>=300 && sum<320) return "B";
        else if(sum>=250 && sum<300) return "C+";
        else if(sum>=200 && sum<250) return "C";
        else if(sum>=170 && sum<200) return "D+";
        else if(sum>=120 && sum<170) return "D";
        else return "F";
    }
    
    public int addStudent(StudBean sb){
        conn = ConnectionPool.connectDB();
        int x=0;
        String sql = "insert into student(enrollment,name,address,branch,college,semester,gender,sub1,sub2,sub3,sub4,grade,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sb.getEnrollment());
            ps.setString(2,sb.getName());
            ps.setString(3, sb.getAddress());
            ps.setString((4), sb.getBranch());
            ps.setString(5, sb.getCollege());
            ps.setInt(6, sb.getSemester());
            ps.setString(7, sb.getGender());
            ps.setInt(8,sb.getSub1());
            ps.setInt(9,sb.getSub2());
            ps.setInt(10,sb.getSub3());
            ps.setInt(11,sb.getSub4());
            String grade = findGrade(sb.getSub1(), sb.getSub2(), sb.getSub3(), sb.getSub4());
            ps.setString(12,grade);
            ps.setString(13, (grade=="F") ? "Fail" : "Pass");
            x = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
    
    public int updateStudent(StudBean sb){
        int x =  0;
        conn = ConnectionPool.connectDB();
        String sql = "update student set name=?,address=?,branch=?,college=?,semester=?,gender=?,sub1=?,sub2=?,sub3=?,sub4=?,grade=?,status=? where enrollment=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sb.getName());
            ps.setString(2, sb.getAddress());
            ps.setString(3, sb.getBranch());
            ps.setString(4, sb.getCollege());
            ps.setFloat(5, sb.getSemester());
            ps.setString(6, sb.getGender());
            ps.setInt(7,sb.getSub1());
            ps.setInt(8,sb.getSub2());
            ps.setInt(9,sb.getSub3());
            ps.setInt(10,sb.getSub4());
            String grade = findGrade(sb.getSub1(), sb.getSub2(), sb.getSub3(), sb.getSub4());
            ps.setString(11,grade);
            ps.setString(12, (grade=="F") ? "Fail" : "Pass");
            ps.setString(13, sb.getEnrollment());
            x = ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return x;
    }
    
    public int deleteStudent(String enrollment){
        int x =  0;
        conn = ConnectionPool.connectDB();
        String sql = "delete from student where enrollment=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, enrollment);
            x = ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return x;
    }
    
    public ArrayList<StudBean> findAllStudent(){
        conn = ConnectionPool.connectDB();
        ArrayList<StudBean> ans = new ArrayList<>();
        String sql = "select * from student;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StudBean sb = new StudBean();
                sb.setEnrollment(rs.getString("enrollment"));
                sb.setName(rs.getString("name"));
                sb.setAddress(rs.getString("address"));
                sb.setBranch(rs.getString("branch"));
                sb.setCollege(rs.getString("college"));
                sb.setSemester(rs.getInt("semester"));
                sb.setGender(rs.getString("gender"));
                sb.setGrade(rs.getString("grade"));
                sb.setStatus(rs.getString("status"));
                ans.add(sb);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }
    
    public StudBean findByEnrollmentNo(String enroll){
        conn = ConnectionPool.connectDB();
        StudBean sb = new StudBean();
        String sql = "select * from student where enrollment='"+enroll+"'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                sb.setName(rs.getString("name"));
                sb.setAddress(rs.getString("address"));
                sb.setBranch(rs.getString("branch"));
                sb.setCollege(rs.getString("college"));
                sb.setSemester(rs.getInt("semester"));
                sb.setGender(rs.getString("gender"));
                sb.setSub1(rs.getInt("sub1"));
                sb.setSub2(rs.getInt("sub2"));
                sb.setSub3(rs.getInt("sub3"));
                sb.setSub4(rs.getInt("sub4"));
                sb.setGrade(rs.getString("grade"));
                sb.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sb;
    }
    
    public ArrayList<StudBean> findBySemester(int semester){
        conn = ConnectionPool.connectDB();
        ArrayList<StudBean> ans = new ArrayList<>();
        String sql = "select * from student where semester='"+semester+"'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StudBean sb = new StudBean();
                sb.setName(rs.getString("name"));
                sb.setAddress(rs.getString("address"));
                sb.setBranch(rs.getString("branch"));
                sb.setCollege(rs.getString("college"));
                sb.setSemester(rs.getInt("semester"));
                sb.setGender(rs.getString("gender"));
                sb.setSub1(rs.getInt("sub1"));
                sb.setSub2(rs.getInt("sub2"));
                sb.setSub3(rs.getInt("sub3"));
                sb.setSub4(rs.getInt("sub4"));
                sb.setGrade(rs.getString("grade"));
                sb.setStatus(rs.getString("status"));
                ans.add(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
    
//    public ArrayList<StudBean> findBySubject(String subject){
//        conn = ConnectionPool.connectDB();
//        ArrayList<StudBean> ans = new ArrayList<>();
//        String sql = "select * from student where student='"+subject+"'";
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                StudBean sb = new StudBean();
//                sb.setName(rs.getString("name"));
//                sb.setAddress(rs.getString("address"));
//                sb.setBranch(rs.getString("branch"));
//                sb.setCollege(rs.getString("college"));
//                sb.setSemester(rs.getInt("semester"));
//                sb.setGender(rs.getString("gender"));
//                sb.setSub1(rs.getInt("sub1"));
//                sb.setSub2(rs.getInt("sub2"));
//                sb.setSub3(rs.getInt("sub3"));
//                sb.setSub4(rs.getInt("sub4"));
//                sb.setGrade(rs.getString("grade"));
//                sb.setStatus(rs.getString("status"));
//                ans.add(sb);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return ans;
//    }
    
    public ArrayList<StudBean> findByStatus(String status){
        conn = ConnectionPool.connectDB();
        ArrayList<StudBean> ans = new ArrayList<>();
        String sql = "select * from student where status='"+status+"'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StudBean sb = new StudBean();
                sb.setName(rs.getString("name"));
                sb.setAddress(rs.getString("address"));
                sb.setBranch(rs.getString("branch"));
                sb.setCollege(rs.getString("college"));
                sb.setSemester(rs.getInt("semester"));
                sb.setGender(rs.getString("gender"));
                sb.setSub1(rs.getInt("sub1"));
                sb.setSub2(rs.getInt("sub2"));
                sb.setSub3(rs.getInt("sub3"));
                sb.setSub4(rs.getInt("sub4"));
                sb.setGrade(rs.getString("grade"));
                sb.setStatus(rs.getString("status"));
                ans.add(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
    
    public ArrayList<StudBean> findTop10(){
        conn = ConnectionPool.connectDB();
        ArrayList<StudBean> ans = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY grade DESC LIMIT 10";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StudBean sb = new StudBean();
                sb.setName(rs.getString("name"));
                sb.setAddress(rs.getString("address"));
                sb.setBranch(rs.getString("branch"));
                sb.setCollege(rs.getString("college"));
                sb.setSemester(rs.getInt("semester"));
                sb.setGender(rs.getString("gender"));
                sb.setSub1(rs.getInt("sub1"));
                sb.setSub2(rs.getInt("sub2"));
                sb.setSub3(rs.getInt("sub3"));
                sb.setSub4(rs.getInt("sub4"));
                sb.setGrade(rs.getString("grade"));
                sb.setStatus(rs.getString("status"));
                ans.add(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
    
    public ArrayList<StudBean> findByCollege(String College){
        conn = ConnectionPool.connectDB();
        ArrayList<StudBean> ans = new ArrayList<>();
        String sql = "SELECT * FROM student where college = '"+College+"'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StudBean sb = new StudBean();
                sb.setName(rs.getString("name"));
                sb.setAddress(rs.getString("address"));
                sb.setBranch(rs.getString("branch"));
                sb.setCollege(rs.getString("college"));
                sb.setSemester(rs.getInt("semester"));
                sb.setGender(rs.getString("gender"));
                sb.setSub1(rs.getInt("sub1"));
                sb.setSub2(rs.getInt("sub2"));
                sb.setSub3(rs.getInt("sub3"));
                sb.setSub4(rs.getInt("sub4"));
                sb.setGrade(rs.getString("grade"));
                sb.setStatus(rs.getString("status"));
                ans.add(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
    
    public ArrayList<StudBean> findByBranch(String branch){
        conn = ConnectionPool.connectDB();
        ArrayList<StudBean> ans = new ArrayList<>();
        String sql = "SELECT * FROM student where branch='"+branch+"'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StudBean sb = new StudBean();
                sb.setName(rs.getString("name"));
                sb.setAddress(rs.getString("address"));
                sb.setBranch(rs.getString("branch"));
                sb.setCollege(rs.getString("college"));
                sb.setSemester(rs.getInt("semester"));
                sb.setGender(rs.getString("gender"));
                sb.setSub1(rs.getInt("sub1"));
                sb.setSub2(rs.getInt("sub2"));
                sb.setSub3(rs.getInt("sub3"));
                sb.setSub4(rs.getInt("sub4"));
                sb.setGrade(rs.getString("grade"));
                sb.setStatus(rs.getString("status"));
                ans.add(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
    
    public ArrayList<StudBean> findByBranchAndCollege(String College,String branch){
        conn = ConnectionPool.connectDB();
        ArrayList<StudBean> ans = new ArrayList<>();
        String sql = "SELECT * FROM student where branch='"+branch+"' and college='"+College+"'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StudBean sb = new StudBean();
                sb.setName(rs.getString("name"));
                sb.setAddress(rs.getString("address"));
                sb.setBranch(rs.getString("branch"));
                sb.setCollege(rs.getString("college"));
                sb.setSemester(rs.getInt("semester"));
                sb.setGender(rs.getString("gender"));
                sb.setSub1(rs.getInt("sub1"));
                sb.setSub2(rs.getInt("sub2"));
                sb.setSub3(rs.getInt("sub3"));
                sb.setSub4(rs.getInt("sub4"));
                sb.setGrade(rs.getString("grade"));
                sb.setStatus(rs.getString("status"));
                ans.add(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
}
