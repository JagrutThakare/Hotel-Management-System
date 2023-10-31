
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame {

	public static void main(String[] args) {
		new CheckOut();
	}

	public CheckOut() {

		setBounds(390, 200, 800, 294);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i3 = i1.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(300, 0, 500, 225);
		add(l1);

		JLabel text = new JLabel("Check Out ");
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text.setBounds(70, 11, 140, 35);
		add(text);

		JLabel id = new JLabel("Customer ID :");
		id.setBounds(20, 85, 80, 14);
		add(id);

		Choice c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next()) {
				c1.add(rs.getString("number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(130, 82, 150, 20);
		add(c1);

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JButton l2 = new JButton(i6);
		l2.setBounds(290, 82, 20, 20);
		add(l2);

		JLabel room = new JLabel("Room Number:");
		room.setBounds(20, 132, 86, 20);
		add(room);

		JTextField t1 = new JTextField();
		t1.setBounds(130, 132, 150, 20);
		add(t1);

		l2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				try {

					Conn c = new Conn();
					String number = c1.getSelectedItem();
					ResultSet rs = c.s.executeQuery("select * from customer where number = '" + number + "'");

					if (rs.next()) {
						t1.setText(rs.getString("room"));
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});

		JButton checkOut = new JButton("Check Out");
		checkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = c1.getSelectedItem();
				String s1 = t1.getText();
				String deleteSQL = "Delete from customer where number = '" + id + "'";
				String q2 = "update room set availability = 'Available' where roomnumber = '" + s1 + "'";

				Conn c = new Conn();

				try {

					c.s.executeUpdate(deleteSQL);
					c.s.executeUpdate(q2);
					JOptionPane.showMessageDialog(null, "Check Out Successful");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		checkOut.setBounds(50, 200, 100, 25);
		checkOut.setBackground(Color.BLACK);
		checkOut.setForeground(Color.WHITE);
		add(checkOut);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception();
				dispose();
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		add(btnExit);

		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}

}