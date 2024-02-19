import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class project extends JFrame implements ActionListener {

    // UI components declaration
    private JLabel projectNameLabel;
    private JTextField projectNameField;
    private JButton addButton, deleteButton, backButton;
    private JTable projectsTable;
    private DefaultTableModel projectsTableModel;

    public project() {
        setTitle("Projects");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // Create form for adding projects
        JPanel formPanel = new JPanel();
        projectNameLabel = new JLabel("Project Name: ");
        projectNameLabel.setBounds(40, 120, 200, 25);
        formPanel.add(projectNameLabel);
        projectNameField = new JTextField();
        projectNameField.setBounds(130, 70, 200, 25);
        formPanel.add(projectNameField);
        addButton = new JButton("Add");
        addButton.setBounds(40,90,200,25);
        addButton.addActionListener(this);
        formPanel.add(addButton);
        add(formPanel, BorderLayout.NORTH);


        String[] columnNames = {"project_id","Project Name"};
        projectsTableModel = new DefaultTableModel(columnNames, 0);
        projectsTable = new JTable(projectsTableModel);
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM projects");


            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = {rs.getInt("project_id"),rs.getInt("project_name")};
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
        JScrollPane scrollPane = new JScrollPane(projectsTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create buttons for navigation and actions
        JPanel buttonPanel = new JPanel();
        deleteButton = new JButton("Delete Project");
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
            addProject();
        } else if (e.getSource() == deleteButton) {
            deleteProject();
        } else if (e.getSource() == backButton) {

            AdminDash AdminDash = new AdminDash();
            AdminDash.setVisible(true);
        }
    }


    private void addProject() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");


            PreparedStatement stmt = conn.prepareStatement("INSERT INTO projects (project_name) VALUES (?)");
            stmt.setString(1, projectNameField.getText());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Project added successfully!");
                projectNameField.setText("");
                refreshProjectsTable();
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

    private void deleteProject() {
        try {


            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");

            int selectedRow = projectsTable.getSelectedRow();
            if (selectedRow >= 0) {

                int projectId = (int) projectsTable.getValueAt(selectedRow, 0);

                // Prepared statement
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM projects WHERE id = ?");
                stmt.setInt(1, projectId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Project deleted successfully!");
                    refreshProjectsTable(); // Refresh the table
                } else {
                    JOptionPane.showMessageDialog(this, "Deletion failed. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a project to delete.");
            }



            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    private void refreshProjectsTable() {
        try {

            projectsTableModel.setRowCount(0);
            String[] columnNames = {"project_id","Project Name"};




            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM projects");


            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = {rs.getInt("project_id"),rs.getInt("project_name")};
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
        project project = new project();
        project.setVisible(true);
    }
}


