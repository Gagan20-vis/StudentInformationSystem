/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sis.ui;

import com.sis.dao.UsersDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gagan
 */
public class ForgotPassword extends javax.swing.JPanel {

    /**
     * Creates new form ForgotPassword
     */
    public ForgotPassword() {
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

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 188, 139));
        setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 153, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(450, 300, 180, 40);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(400, 190, 290, 50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Forgot Password");
        add(jLabel1);
        jLabel1.setBounds(410, 50, 300, 60);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Enter Email ");
        add(jLabel2);
        jLabel2.setBounds(240, 190, 160, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email=jTextField1.getText();
        UsersDAO ud=new UsersDAO();
        String ps=ud.forgotPassword(email);
        if(ps!=null){
            JOptionPane.showMessageDialog(this, "Your Password : "+ps);
        }
        else{
        JOptionPane.showMessageDialog(this, "You Enter Invalid Email : ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String[] args) {
        JFrame jf = new JFrame("ForgotPassword");
        jf.setContentPane(new ForgotPassword());
        jf.setBounds(100, 200, 700, 800);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}