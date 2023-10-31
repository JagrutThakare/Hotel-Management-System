
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public static void main(String[] args) {
        new Dashboard();
    }

    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");

        // Full Screen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(rect);

        setForeground(Color.CYAN);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, rect.width, rect.height);
        add(image);

        JLabel head = new JLabel("THE TAJ GROUP WELCOMES YOU");
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Tahoma", Font.PLAIN, 46));
        head.setBounds(450, 50, 1000, 85);
        image.add(head);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLACK);
        menuBar.setForeground(Color.white);
        setJMenuBar(menuBar);

        JMenu hms = new JMenu("HOTEL MANAGEMENT");
        hms.setForeground(Color.WHITE);
        menuBar.add(hms);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.WHITE);
        menuBar.add(admin);

        JMenuItem reception = new JMenuItem("RECEPTION");
        hms.add(reception);

        reception.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Reception();
            }
        });

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addEmployee);

        addEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AddEmployee();
            }
        });

        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        admin.add(addRooms);

        addRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AddRooms();
            }
        });

        JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
        admin.add(addDrivers);

        addDrivers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AddDriver();
            }
        });

        setVisible(true);
    }
}