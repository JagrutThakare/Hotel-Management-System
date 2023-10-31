import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JButton add, back;
    JLabel lblname, lblgender, lbltime, lblid, lbldeposit, lblnumber, text, lblcountry, lblroom, checkintime;
    JTextField tfname, tfnumber, tfcountry, tfdeposit;
    JRadioButton m, f;
    JComboBox<String> comboid;
    Choice croom;

    AddCustomer() {
        setLayout(null);

        text = new JLabel("NEW CUSTOMER");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblid);

        String options[] = { "Aadhar Card", "Passport", "Driving License", "Voter ID Card", "Ration Card" };
        comboid = new JComboBox<>(options);
        comboid.setBounds(200, 80, 150, 20);
        comboid.setBackground(Color.white);
        add(comboid);

        lblnumber = new JLabel("Number");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblgender);

        m = new JRadioButton("MALE");
        m.setBounds(200, 200, 70, 25);
        m.setFont(new Font("Raleway", Font.PLAIN, 14));
        m.setBackground(Color.white);
        add(m);

        f = new JRadioButton("FEMALE");
        f.setBounds(270, 200, 120, 25);
        f.setFont(new Font("Raleway", Font.PLAIN, 14));
        f.setBackground(Color.white);
        add(f);

        ButtonGroup bg = new ButtonGroup(); // allows only one button to be selected at a time.
        bg.add(m);
        bg.add(f);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);

        lblroom = new JLabel("Room Number");
        lblroom.setBounds(35, 280, 160, 20);
        lblroom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblroom);

        croom = new Choice();

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        croom.setBounds(200, 280, 150, 25);
        add(croom);

        Date date = new Date();

        lbltime = new JLabel("Checkin Time");
        lbltime.setBounds(35, 320, 150, 20);
        lbltime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbltime);

        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 320, 220, 25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(checkintime);

        lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35, 360, 100, 30);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        tfdeposit.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(tfdeposit);

        add = new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(50, 410, 120, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200, 410, 120, 30);
        add(back);
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/abc.png"));
        Image i2 = i1.getImage().getScaledInstance(i1.getIconWidth(), i1.getIconHeight(), Image.SCALE_FAST);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(400, 30, i1.getIconWidth(), i1.getIconHeight());
        add(label);

        getContentPane().setBackground(Color.white); // set the background color of the frame.
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {

            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;

            if (m.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();

            try {

                String query = "insert into customer values('" + id + "', '" + number + "', '" + name + "', '" + gender
                        + "', '" + country + "', '" + room + "', '" + time + "', '" + deposit + "')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '" + room + "'";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                try {
                    Conn conn = new Conn();
                    String query3 = "SELECT * FROM room where availability = 'Available'";
                    ResultSet rs = conn.s.executeQuery(query3);
                    croom.removeAll();
                    while (rs.next()) {
                        croom.add(rs.getString("roomnumber"));
                    }

                } catch (Exception ae) {
                    ae.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "New Customer Added Sucessfully");

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == back) {
            dispose();

        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
