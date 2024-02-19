import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class department extends JFrame implements ActionListener {

    // UI components declaration
    private JLabel departmentNameLabel;
    private JTextField departmentNameField;
    private JButton addButton, deleteButton, backButton;
    private JTable departmentsTable;
    private DefaultTableModel departmentsTableModel;

    public department() {
        setTitle("Departments");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 350);
        setLocationRelativeTo(null);


        JPanel formPanel = new JPanel();
        departmentNameLabel = new JLabel("Department Name:");
        departmentNameLabel.setBounds(40, 70, 200, 25);
        formPanel.add(departmentNameLabel);
        departmentNameField = new JTextField();
        departmentNameField.setBounds(130, 70, 200, 25);
        formPanel.add(departmentNameField);
        addButton = new JButton("Add");
        addButton.setBounds(40,90,200,25);
        addButton.addActionListener(this);
        formPanel.add(addButton);
        add(formPanel, BorderLayout.NORTH);


        String[] columnNames = {"dep id","Department Name"};
        departmentsTableModel = new DefaultTableModel(columnNames, 0);
        departmentsTable = new JTable(departmentsTableModel);
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM department");


            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = {rs.getInt("dep_id"),rs.getInt("department_name")};
                model.addRow(row);
            }


            rs.close();
            stmt.close();
            conn.close();


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver not found: " + ex.getMessage());
        }
        JScrollPane scrollPane = new JScrollPane(departmentsTable);
        add(scrollPane, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        deleteButton = new JButton("Delete Department");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);
        backButton = new JButton("Back to Admin Dashboard");
        backButton.addActionListener(this);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addDepartment();
        } else if (e.getSource() == deleteButton) {
            deleteDepartment();
        } else if (e.getSource() == backButton) {
            new AdminDash().setVisible(true);
        }
    }


    private void addDepartment() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");



            // Prepared statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO department (department_name) VALUES (?)");
            stmt.setString(1, departmentNameField.getText());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Department added successfully!");
                departmentNameField.setText("");
                refreshDepartmentsTable();
            } else {
                JOptionPane.showMessageDialog(this, "Insertion failed. Please try again.");
            }


            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver not found: " + ex.getMessage());
        }
    }

    private void deleteDepartment() {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");


            int selectedRow = departmentsTable.getSelectedRow();
            if (selectedRow >= 0) {

                int departmentId = (int) departmentsTable.getValueAt(selectedRow, 0);

                // Prepared statement
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM departments WHERE id = ?");
                stmt.setInt(1, departmentId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Department deleted successfully!");
                    refreshDepartmentsTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Deletion failed. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a department to delete.");
            }


            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    private void refreshDepartmentsTable() {
        try {

            String[] columnNames = {"dep id","Department Name"};
            departmentsTableModel.setRowCount(0);





            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM department");


            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = {rs.getInt("dep_id"),rs.getInt("department_name")};
                model.addRow(row);
            }


            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        department department = new department();
        department.setVisible(true);
    }
}


