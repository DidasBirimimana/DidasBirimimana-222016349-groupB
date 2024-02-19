import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class studentsinfo extends JFrame implements ActionListener {

    // UI components declaration
    private JLabel titleLabel, firstNameLabel, lastNameLabel, emailLabel, contactNumberLabel, addressLabel, departmnet_id;
    private JTextField firstNameField, lastNameField, emailField, contactNumberField, addressField, depidField;

    private JButton submitButton, assignmentsButton;

    public studentsinfo() {
        setTitle("graduate students Information system - Enter Your Details");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 550);
        setLocationRelativeTo(null);


        titleLabel = new JLabel(" Students Information system");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(40, 20, 320, 30);
        add(titleLabel);

        firstNameLabel = new JLabel("firstname:");
        firstNameLabel.setBounds(40, 70, 80, 25);
        add(firstNameLabel);

        lastNameLabel = new JLabel("lastname:");
        lastNameLabel.setBounds(40, 110, 80, 25);
        add(lastNameLabel);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(40, 150, 80, 25);
        add(emailLabel);

        contactNumberLabel = new JLabel("Phone contact:");
        contactNumberLabel.setBounds(40, 190, 100, 25);
        add(contactNumberLabel);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(40, 230, 80, 25);
        add(addressLabel);

        departmnet_id = new JLabel("department id:");
        departmnet_id.setBounds(40, 270, 80, 25);
        add(departmnet_id);




        firstNameField = new JTextField();
        firstNameField.setBounds(130, 70, 200, 25);
        add(firstNameField);

        lastNameField = new JTextField();
        lastNameField.setBounds(130, 110, 200, 25);
        add(lastNameField);

        emailField = new JTextField();
        emailField.setBounds(130, 150, 200, 25);
        add(emailField);

        contactNumberField = new JTextField();
        contactNumberField.setBounds(130, 190, 200, 25);
        add(contactNumberField);

        addressField = new JTextField();
        addressField.setBounds(130, 230, 200, 25);
        add(addressField);

        depidField = new JTextField();
        depidField.setBounds(130, 270, 200, 25);
        add(depidField);




        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 450, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        assignmentsButton = new JButton("Assignments");
        assignmentsButton.setBounds(270, 450, 120, 30);
        // Add action listener for assignments button (not implemented here)
        add(assignmentsButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            submitDetails();
        }
    }

    private void submitDetails() {

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String contact = contactNumberField.getText();
        String address = addressField.getText();
        String dep_id = depidField.getText();



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO studentsinfo (firstname, lastname, email, contact, address, dep_id) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, contact);
            stmt.setString(5, address);

            stmt.setString(6, dep_id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Details submitted successfully!");

            } else {
                JOptionPane.showMessageDialog(this, "Submission failed. Please try again.");
            }


            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver not found: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        studentsinfo studentsinfo = new studentsinfo();
        studentsinfo.setVisible(true);
    }


    
}

