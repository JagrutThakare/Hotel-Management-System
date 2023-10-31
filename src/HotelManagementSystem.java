

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener {
    
    HotelManagementSystem() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        
        JLabel image = new JLabel(i1);
        image.setBounds(0,0, 1366, 565);
        add(image);
        
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        JButton next = new JButton("Login");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);
        next.addActionListener(this);

        // setLocation(100, 100); // Location where the frame will be centered
        setBounds(100, 100, 1366, 565);
        // setExtendedState(JFrame.MAXIMIZED_BOTH); // Makes Jframe full screen
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        new Login(this);
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();

    }
    
}
