
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JButton login, cancel;
    JPasswordField password;
    HotelManagementSystem obj;

    Login(HotelManagementSystem obj) {
        this.obj = obj;

        getContentPane().setBackground(Color.WHITE); // Sets the background color of Login Frame

        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(500, 200, 600, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            String user = username.getText();
            String pass = new String(password.getPassword());

            try {
                Conn c = new Conn();

                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'"; // Single
                                                                                                                    // quotes
                                                                                                                    // are
                                                                                                                    // imp.

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) { // check if data is available in database
                    dispose();
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {

            if (obj == null)
                dispose();
            else {
                obj.setVisible(true);
                dispose();
            }

        }
    }

    public static void main(String[] args) {
        new Login(null);
    }
}
