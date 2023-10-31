import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JButton submit;
    JLabel name, age, gender, email, job, salary, phone, image, aadhar;
    JTextField tfname, tfemail, tfage, tfgender, tfphone, tfsalary, tfaadhar;
    JRadioButton m, f;
    JComboBox<String> cbjob;

    AddEmployee() {
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

        job = new JLabel("JOB");
        job.setBounds(60, 180, 120, 30);
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(job);

        String str[] = { "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chef's",
                "Waiter/Waitress", "Manager", "Accountant" };
        cbjob = new JComboBox<>(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.white);
        add(cbjob);

        salary = new JLabel("SALARY");
        salary.setBounds(60, 230, 120, 30);
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(salary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        phone = new JLabel("PHONE");
        phone.setBounds(60, 280, 120, 30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        email = new JLabel("EMAIL");
        email.setBounds(60, 330, 120, 30);
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60, 380, 120, 30);
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(aadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);

        submit = new JButton("Submit");
        submit.setBounds(200, 430, 150, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.white); // set the background color of the frame.
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = tfname.getText();
        String age = tfage.getText();
        String email = tfemail.getText();
        String phone = tfphone.getText();
        String salary = tfsalary.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;

        if (m.isSelected()) {
            gender = "Male";
        } else if (f.isSelected()) {
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();

        try {
            Conn c = new Conn();

            String query = "insert into employee values('" + name + "', '" + age + "', '" + gender + "', '" + job
                    + "', '" + salary + "', '" + phone + "', '" + email + "', '" + aadhar + "')";
            c.s.executeUpdate(query); // This method is used when we have to update the database previously we used
                                      // executeQuery() which is just for reading database
            JOptionPane.showMessageDialog(null, "Employee added successfully");
        } catch (Exception ec) {
            ec.printStackTrace();
        }
    }
}
