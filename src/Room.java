import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.sql.*;

public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel image = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"))
                .getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT)));
        image.setBounds(500, 0, 600, 600);
        add(image);

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);

        JLabel l1 = new JLabel("Room Number");
        JLabel l2 = new JLabel("Availability");
        JLabel l3 = new JLabel("Room Number");
        JLabel l4 = new JLabel("Price");
        JLabel l5 = new JLabel("Status");

        l1.setBounds(10, 10, 100, 20);
        l2.setBounds(120, 10, 100, 20);
        l3.setBounds(230, 10, 100, 20);
        l4.setBounds(330, 10, 100, 20);
        l5.setBounds(410, 10, 100, 20);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);

        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        new Reception();
    }

}
