/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis.bean;

/**
 *
 * @author gagan
 */
public class StudBean {

    private String Enrollment;
    private String Name;
    private String Address;
    private String Branch;
    private String College;
    private int Semester;
    private String Gender;
    private int sub1;
    private int sub2;
    private int sub3;
    private int sub4;
    private String grade;
    private String status;

    public StudBean() {

    }

    public StudBean(String Enrollment, String Name, String Address, String Branch, String College, int Semester, String Gender, int sub1, int sub2, int sub3, int sub4, String grade, String status) {
        this.Enrollment = Enrollment;
        this.Name = Name;
        this.Address = Address;
        this.Branch = Branch;
        this.College = College;
        this.Semester = Semester;
        this.Gender = Gender;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.grade = grade;
        this.status = status;
    }

    public String getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(String Enrollment) {
        this.Enrollment = Enrollment;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String College) {
        this.College = College;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getSub1() {
        return sub1;
    }

    public void setSub1(int sub1) {
        this.sub1 = sub1;
    }

    public int getSub2() {
        return sub2;
    }

    public void setSub2(int sub2) {
        this.sub2 = sub2;
    }

    public int getSub3() {
        return sub3;
    }

    public void setSub3(int sub3) {
        this.sub3 = sub3;
    }

    public int getSub4() {
        return sub4;
    }

    public void setSub4(int sub4) {
        this.sub4 = sub4;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
