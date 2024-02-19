import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminDash extends JFrame implements ActionListener {

    private JTable studentsTable;
    private JButton departmentsButton, assignmentsButton, projectsButton;

    public AdminDash() {
        setTitle("Admin Dashboard");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);


        String[] columnNames = {"ID", "First Name", "Last Name", "Email", "Contact", "Address", "dep_id"};


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentsinfo");


            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = {rs.getInt("stud_id"), rs.getString("firstname"), rs.getString("lastname"),rs.getString("email"), rs.getString("contact"),
                        rs.getString("address"), rs.getString("dep_id")};
                model.addRow(row);
            }


            studentsTable = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(studentsTable);
            add(scrollPane, BorderLayout.CENTER);


            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver not found: " + ex.getMessage());
        }

        // Create buttons
        JPanel buttonPanel = new JPanel();
        departmentsButton = new JButton("Departments");
        departmentsButton.addActionListener(this);
        buttonPanel.add(departmentsButton);

        assignmentsButton = new JButton("Assignments");
        assignmentsButton.addActionListener(this);
        buttonPanel.add(assignmentsButton);

        projectsButton = new JButton("Projects");
        projectsButton.addActionListener(this);
        buttonPanel.add(projectsButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == departmentsButton) {

            department department = new department();
            department.setVisible(true);

        } else if (e.getSource() == assignmentsButton) {

            Assignments Assignments = new Assignments();
            Assignments.setVisible(true);

        } else if (e.getSource() == projectsButton) {

            project project = new project();
            project.setVisible(true);

        }
    }

    public static void main(String[] args) {
        AdminDash adminDash = new AdminDash();
        adminDash.setVisible(true);
    }

}

