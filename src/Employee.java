/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employee extends JFrame {

    public static void main(String[] args) {
        new Employee();
    }

    public void close() {
        this.dispose();
    }

    public Employee() {
        setBounds(320, 200, 1000, 600);
        setLayout(null);

        JTable table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String displayCustomersql = "select * from Employee";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(350, 500, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        add(btnLoadData);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(510, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(41, 11, 46, 14);
        add(lblNewLabel);

        JLabel lblJob = new JLabel("Age");
        lblJob.setBounds(159, 11, 46, 14);
        add(lblJob);

        JLabel lblName = new JLabel("Gender");
        lblName.setBounds(273, 11, 46, 14);
        add(lblName);

        JLabel lblDepartment = new JLabel("Job");
        lblDepartment.setBounds(416, 11, 86, 14);
        add(lblDepartment);

        JLabel l1 = new JLabel("Salary");
        l1.setBounds(536, 11, 86, 14);
        add(l1);

        JLabel l2 = new JLabel("Phone");
        l2.setBounds(656, 11, 86, 14);
        add(l2);

        JLabel l3 = new JLabel("Aadhar");
        l3.setBounds(786, 11, 86, 14);
        add(l3);

        JLabel l4 = new JLabel("Gmail");
        l4.setBounds(896, 11, 86, 14);
        add(l4);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
}