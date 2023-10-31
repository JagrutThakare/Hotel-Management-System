
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame {

    JTable table;
    JButton back;

    Department() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        table = new JTable();
        table.setBounds(10, 30, 500, 100);
        add(table);

        JLabel l1 = new JLabel("Department");
        JLabel l2 = new JLabel("Budget");

        l1.setBounds(120, 10, 100, 20);
        l2.setBounds(370, 10, 100, 20);

        add(l1);
        add(l2);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(new Action() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Reception();
            }

            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {

                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

        });

        back.setBounds(200, 200, 120, 30);
        add(back);

        setBounds(500, 200, 550, 300);
        setVisible(true);
    }
}
