/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame {
	Connection conn = null;
	ResultSet rs = null;
	JTable table;
	Choice c1;

	public static void main(String[] args) {
		new SearchRoom();
	}

	public void close() {
		dispose();
	}

	public SearchRoom() {
	
		setBounds(440, 200, 700, 500);
		setLayout(null);

		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		add(lblSearchForRoom);

		JLabel lblRoomAvailable = new JLabel("Room Type:");
		lblRoomAvailable.setBounds(50, 73, 96, 14);
		add(lblRoomAvailable);

		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(23, 162, 96, 14);
		add(lblRoomType);

		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		add(lblRoomAvailable_1);

		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		add(lblPrice_1);

		JLabel l1 = new JLabel("Type");
		l1.setBounds(580, 162, 96, 14);
		add(l1);

		JCheckBox checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBounds(400, 69, 205, 23);
		checkRoom.setBackground(Color.WHITE);
		add(checkRoom);

		c1 = new Choice();
		c1.add("1BHK");
		c1.add("2BHK");
		c1.setBounds(153, 70, 120, 20);
		add(c1);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "select * from Room where bed_type = '" + c1.getSelectedItem() + "'";
				String SQL2 = "select * from Room where availability = 'Available' AND bed_type = '"
						+ c1.getSelectedItem() + "'";
				try {
					Conn c = new Conn();
					rs = c.s.executeQuery(SQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));

					if (checkRoom.isSelected()) {
						rs = c.s.executeQuery(SQL2);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}

				} catch (SQLException ss) {
					ss.printStackTrace();
				}

			}
		});
		btnSearch.setBounds(200, 400, 120, 30);
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		add(btnSearch);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(380, 400, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		add(btnExit);

		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		add(table);

		JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(306, 162, 96, 14);
		add(lblCleanStatus);

		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
}