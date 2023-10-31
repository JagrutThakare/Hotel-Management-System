import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JLabel heading, roomno, available, lblclean, price, type;
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox<String> availablecombo, cleancombo, typecombo;
    String availableOptions[] = { "Available", "Occupied" }, cleanOptions[] = { "Clean", "Dirty" },
            typeOptions[] = { "1BHK", "2BHK" };

    AddRooms() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        heading = new JLabel("Add Room");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        roomno = new JLabel("Room Number");
        roomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        roomno.setBounds(60, 80, 120, 30);
        add(roomno);

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        available = new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        available.setBounds(60, 130, 120, 30);
        add(available);

        availablecombo = new JComboBox<>(availableOptions);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);

        lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);

        cleancombo = new JComboBox<>(cleanOptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);

        price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(60, 230, 120, 30);
        add(price);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        type = new JLabel("Room Type");
        type.setFont(new Font("Tahoma", Font.PLAIN, 16));
        type.setBounds(60, 270, 120, 30);
        add(type);

        typecombo = new JComboBox<>(typeOptions);
        typecombo.setBounds(200, 270, 150, 30);
        typecombo.setBackground(Color.white);
        add(typecombo);

        add = new JButton("Add Room");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(60, 350, 130, 30);
        add(add);
        add.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(220, 350, 130, 30);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(400, 30, 500, 300);
        add(img);

        setBounds(330, 200, 940, 470);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            String roomno = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "insert into room values('" + roomno + "', '" + availability + "', '" + status + "', '"
                        + price + "', '" + type + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            dispose();
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }

}
