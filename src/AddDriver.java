import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JButton addDriver, cancel;
    JLabel name, age, gender, loc, carCompany, model, avail, image;
    JTextField tfname, tfcarCom, tfloc, tfage, tfgender, tfmodel;
    JRadioButton m, f;
    JComboBox<String> tfavail;
    AddDriver() {
        setLayout(null);

        name = new JLabel("NAME");
        name.setBounds(60, 30, 120, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        age = new JLabel("AGE");
        age.setBounds(60, 80, 120, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(age);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        gender = new JLabel("GENDER");
        gender.setBounds(60, 130, 120, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(gender);

        m = new JRadioButton("MALE");
        m.setBounds(200, 130, 70, 30);
        m.setFont(new Font("Tahoma", Font.PLAIN, 14));
        m.setBackground(Color.white);
        add(m);

        f = new JRadioButton("FEMALE");
        f.setBounds(280, 130, 110, 30);
        f.setFont(new Font("Tahoma", Font.PLAIN, 14));
        f.setBackground(Color.white);
        add(f);

        ButtonGroup bg = new ButtonGroup(); // allows only one button to be selected at a time.
        bg.add(m);
        bg.add(f);

        carCompany = new JLabel("Car Company");
        carCompany.setBounds(60, 180, 120, 30);
        carCompany.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(carCompany);
        
        tfcarCom = new JTextField();
        tfcarCom.setBounds(200, 180, 150, 30);
        add(tfcarCom);

        model = new JLabel("Car Model");
        model.setBounds(60, 230, 120, 30);
        model.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(model);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);

        avail = new JLabel("Available");
        avail.setBounds(60, 280, 120, 30);
        avail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(avail);

        String driverOptions[] = {"Available", "Busy"};
        tfavail = new JComboBox<>(driverOptions);
        tfavail.setBounds(200, 280, 150, 30);
        tfavail.setBackground(Color.WHITE);
        add(tfavail);

        loc = new JLabel("Location");
        loc.setBounds(60, 330, 120, 30);
        loc.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(loc);

        tfloc = new JTextField();
        tfloc.setBounds(200, 330, 150, 30);
        add(tfloc);

        addDriver = new JButton("Add Driver");
        addDriver.setBounds(60, 380, 150, 30);
        addDriver.setBackground(Color.black);
        addDriver.setForeground(Color.white);
        addDriver.addActionListener(this);
        add(addDriver);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 380, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(380, 20, 600, 450);
        add(image);

        getContentPane().setBackground(Color.white); // set the background color of the frame.
        setBounds(350, 200, 1000, 540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cancel) {
            dispose();
        } else {
            String name = tfname.getText();
            String age = tfage.getText();
            String location = tfloc.getText();
            String brand = tfmodel.getText();
            String company = tfcarCom.getText();
            String gender = null;

            if(m.isSelected()) {
                gender = "Male";
            } else if(f.isSelected()) {
                gender = "Female";
            }

            String avail = (String) tfavail.getSelectedItem();

            try {
                Conn c = new Conn();

                String query = "insert into driver values('" + name + "', '" + age + "', '" + gender + "', '" + company + "', '" + brand + "', '" + avail + "', '" + location + "')";
                c.s.executeUpdate(query); // This method is used when we have to update the database previously we used executeQuery() which is just for reading database
                JOptionPane.showMessageDialog(null, "New Driver added successfully");
                
            } catch (Exception ec) {
                ec.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new AddDriver();
    }
}
