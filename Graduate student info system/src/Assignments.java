import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Assignments extends JFrame {
    private JTextField assignmentField;
    private JTextField studIdField;
    private JTextField projectidField;
    private JLabel assignmentLabel,studIdlabel,project_idlabel;
    private JButton addButton, viewButton,backButton;


    public Assignments() {
        setTitle("Assignments");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        assignmentLabel = new JLabel("Assignment:");
        assignmentLabel.setBounds(20, 20, 80, 25);
        add(assignmentLabel);

        assignmentField = new JTextField();
        assignmentField.setBounds(120, 20, 200, 25);
        add(assignmentField);


        studIdlabel = new JLabel("Student ID:");
        studIdlabel.setBounds(20, 40, 80, 25);
        add(studIdlabel);

        studIdField = new JTextField();
        studIdField.setBounds(120, 40, 200, 25);
        add(studIdField);

        project_idlabel = new JLabel("Project ID:");
        project_idlabel.setBounds(20, 60, 80, 25);
        add(project_idlabel);

        projectidField = new JTextField();
        projectidField.setBounds(120, 60, 200, 25);
        add(projectidField);




        addButton = new JButton("Add Assignment");
        addButton.setBounds(20, 180, 150, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAssignment();
            }
        });
        add(addButton);

        viewButton = new JButton("View Assignments");
        viewButton.setBounds(180, 180, 150, 25);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAssignments();
            }
        });
        add(viewButton);

        backButton = new JButton("Back to Admin Dashboard");
        backButton.setBounds(20, 220, 310, 25);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminDash().setVisible(true);
            }
        });
        add(backButton);
    }

    private void addAssignment() {
        String assignment = assignmentField.getText();
        String studid = projectidField.getText();
        String projectId = studIdField.getText();




        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");

            String sql = "INSERT INTO assignments (ass_description, stud_id, project_id) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, assignment);
                preparedStatement.setString(2, studid);
                preparedStatement.setString(3, projectId);


                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Assignment added successfully!");
            }

            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding assignment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewAssignments() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_student", "root", "");

            String sql = "SELECT * FROM assignments";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {


                while (resultSet.next()) {
                    int assId = resultSet.getInt("ass_id");
                    String assignment = resultSet.getString("ass_description");
                    int studid = resultSet.getInt("stud_id");
                    int projectId = resultSet.getInt("project_id");


                    System.out.println("assignment ID: " + assId + ", assignment description: " + assignment +
                            ", student id: " + studid + ", project id: " + projectId);
                }
            }

            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error viewing assignments: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Assignments Assignments = new Assignments();
        Assignments.setVisible(true);
    }
}


