
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame {

    public static void main(String[] args) {
        new Reception();
    }

    public Reception() {

        setBounds(370, 200, 850, 570);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(850, 570, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0, 0, 850, 570);
        add(l1);

        JButton newCustomer = new JButton("New Customer Form");
        newCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddCustomer();
                dispose();
            }
        });
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        l1.add(newCustomer);

        JButton room = new JButton("Room");
        room.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Room();
                dispose();
            }
        });
        room.setBounds(10, 70, 200, 30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        l1.add(room);

        JButton department = new JButton("Department");
        department.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Department();
                dispose();
            }
        });
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        l1.add(department);

        JButton emp_Info = new JButton("All Employee Info");
        emp_Info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Employee();
                dispose();
            }
        });
        emp_Info.setBounds(10, 150, 200, 30);
        emp_Info.setBackground(Color.BLACK);
        emp_Info.setForeground(Color.WHITE);
        l1.add(emp_Info);

        JButton customerInfo = new JButton("Customer Info");
        customerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CustomerInfo();
                dispose();
            }
        });
        customerInfo.setBounds(10, 190, 200, 30);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);

        l1.add(customerInfo);

        JButton btnManagerInfo = new JButton("Manager Info");
        btnManagerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ManagerInfo mana = new ManagerInfo();
                    mana.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnManagerInfo.setBounds(10, 230, 200, 30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);
        l1.add(btnManagerInfo);

        JButton checkOut = new JButton("Check Out");
        checkOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CheckOut();
            }
        });
        checkOut.setBounds(10, 270, 200, 30);
        checkOut.setBackground(Color.BLACK);
        checkOut.setForeground(Color.WHITE);
        l1.add(checkOut);

        JButton checkStatus = new JButton("Update Check Status");
        checkStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateCheck update = new UpdateCheck();
                    update.setVisible(true);
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        checkStatus.setBounds(10, 310, 200, 30);
        checkStatus.setBackground(Color.BLACK);
        checkStatus.setForeground(Color.WHITE);
        l1.add(checkStatus);

        JButton roomStatus = new JButton("Update Room Status");
        roomStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateRoom room = new UpdateRoom();
                    room.setVisible(true);
                    setVisible(false);
                } catch (Exception s) {
                    s.printStackTrace();
                }
            }
        });
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        l1.add(roomStatus);

        JButton pickUpSerice = new JButton("Pick up Service");
        pickUpSerice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    PickUp pick = new PickUp();
                    pick.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pickUpSerice.setBounds(10, 390, 200, 30);
        pickUpSerice.setBackground(Color.BLACK);
        pickUpSerice.setForeground(Color.WHITE);
        l1.add(pickUpSerice);

        JButton searchRoom = new JButton("Search Room");
        searchRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SearchRoom search = new SearchRoom();
                    search.setVisible(true);
                    setVisible(false);
                } catch (Exception ss) {
                    ss.printStackTrace();
                }
            }
        });
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        l1.add(searchRoom);

        JButton logOut = new JButton("Log Out");
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);

            }
        });
        logOut.setBounds(10, 470, 200, 30);
        logOut.setBackground(Color.BLACK);
        logOut.setForeground(Color.WHITE);
        l1.add(logOut);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
}