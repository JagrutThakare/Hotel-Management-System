

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCheck extends JFrame {
    Connection conn = null;
    JTextField tfroom, tfname, tfcheck, tfdeposit, tfpending;
    Choice c1, c2;

    public static void main(String[] args) {
        new UpdateCheck();
    }

    public UpdateCheck() {

        setBounds(350, 200, 950, 500);
        setLayout(null);

        JLabel text = new JLabel("Check-In Details");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(124, 11, 222, 25);
        add(text);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(450, 70, 476, 270);
        add(l1);

        JLabel ID = new JLabel("ID:");
        ID.setBounds(25, 88, 46, 14);
        add(ID);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(248, 85, 140, 20);
        add(c1);

        JLabel roomno = new JLabel("Room Number :");
        roomno.setBounds(25, 129, 107, 14);
        add(roomno);

        tfroom = new JTextField();
        tfroom.setBounds(248, 126, 140, 20);
        add(tfroom);

        JLabel name = new JLabel("Name : ");
        name.setBounds(25, 174, 97, 14);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(248, 171, 140, 20);
        tfname.setColumns(10);
        add(tfname);

        JLabel checkin = new JLabel("Checked-in :");
        checkin.setBounds(25, 216, 107, 14);
        add(checkin);

        tfcheck = new JTextField();
        tfcheck.setBounds(248, 216, 140, 20);
        tfcheck.setColumns(10);
        add(tfcheck);

        JLabel deposit = new JLabel("Amount Paid (Rs) : ");
        deposit.setBounds(25, 261, 107, 14);
        add(deposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(248, 258, 140, 20);
        tfdeposit.setColumns(10);
        add(tfdeposit);

        JLabel pending = new JLabel("Pending Amount (Rs) : ");
        pending.setBounds(25, 302, 150, 14);
        add(pending);

        tfpending = new JTextField();
        tfpending.setBounds(248, 299, 140, 20);
        add(tfpending);
        tfpending.setColumns(10);

        JButton btnAdd = new JButton("Check");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = c1.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs1 = c.s.executeQuery("select * from customer where number = '" + s1 + "'");
                    while(rs1.next()) {
                        tfroom.setText(rs1.getString("room"));
                        tfname.setText(rs1.getString("name"));
                        tfcheck.setText(rs1.getString("checkintime"));
                        tfdeposit.setText(rs1.getString("deposit"));
                    }

                } catch (Exception ee) {
                    ee.printStackTrace();
                }

                try {
                    String total = "";
                    Conn c = new Conn();
                    ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                    while (rs2.next()) {
                        total = rs2.getString("price");

                    }
                    String paid = tfdeposit.getText();
                    int pending = Integer.parseInt(total) - Integer.parseInt(paid);

                    tfpending.setText(Integer.toString(pending));

                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
        btnAdd.setBounds(56, 378, 89, 23);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        add(btnAdd);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Conn c = new Conn();

                    String s1 = c1.getSelectedItem();
                    String s2 = tfroom.getText(); // room
                    String s3 = tfname.getText(); // name
                    String s4 = tfcheck.getText(); // checkin;
                    String s5 = tfdeposit.getText(); // deposit

                    c.s.executeUpdate("update customer set room = '" + s2 + "', name = '" + s3 + "', checkintime = '"
                            + s4 + "', deposit = '" + s5 + "' where number = '" + s1 + "'");

                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                } catch (Exception ee) {
                    System.out.println(ee);
                }

            }
        });
        btnUpdate.setBounds(168, 378, 89, 23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        add(btnUpdate);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception();
                dispose();
            }
        });
        btnExit.setBounds(281, 378, 89, 23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

}