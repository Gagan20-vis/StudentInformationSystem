/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sis.ui;

import com.sis.bean.StudBean;
import com.sis.dao.StudDAO;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author gagan
 */
public class FindBySemester extends javax.swing.JPanel {

    /**
     * Creates new form FindBySemester
     */
    public FindBySemester() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dm = new DefaultListModel();
        jList1 = new javax.swing.JList<>(dm);
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 188, 139));
        setLayout(null);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        add(jComboBox1);
        jComboBox1.setBounds(420, 200, 120, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Find Student By Enrollment Number");
        add(jLabel1);
        jLabel1.setBounds(280, 50, 650, 48);

        jButton1.setBackground(new java.awt.Color(255, 153, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(610, 200, 150, 39);

        jList1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1);
        jScrollPane1.setBounds(230, 280, 640, 190);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Semester");
        add(jLabel2);
        jLabel2.setBounds(290, 200, 120, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dm.clear();
        int semester = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        StudDAO sd = new StudDAO();
        ArrayList<StudBean> list = sd.findBySemester(semester);
        for(StudBean sb: list){
            dm.addElement(" "+sb.getName()+" "+sb.getAddress()+" "+sb.getBranch()+" "+sb.getSemester()+" "+" "+sb.getCollege()+" "+sb.getGender()+" "+sb.getGrade()+" "+sb.getStatus());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String[] args) {
        JFrame jf = new JFrame("FindBySemester");
        jf.setContentPane(new FindBySemester());
        jf.setBounds(100, 200, 700, 800);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    DefaultListModel dm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
