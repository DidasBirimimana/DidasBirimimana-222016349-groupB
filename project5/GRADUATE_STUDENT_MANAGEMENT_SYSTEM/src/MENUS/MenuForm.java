package MENUS;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import MyAllForms.ApplicantInfoForm;
import MyAllForms.CourseInfoForm;
import MyAllForms.Financial_IssuesInfoForm;
import MyAllForms.ProjectResearchForm;
import MyAllForms.SemesterInfoForm;
import MyAllForms.StudentForm;

public class MenuForm extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu ApplicantInfomenu;
    private JMenu CourseInfomenu;
    private JMenu Financial_issues_infomenu;
    private JMenu ProjectResearchInfomenu;
    private JMenu SemesterInfomenu;
    private JMenu Studentmenu;
    private JMenu Logoutmenu;
    
    public MenuForm() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem ApplicantInfoItem;
    private JMenuItem CourseInfoItem;
    private JMenuItem Financial_issues_infoItem;
    private JMenuItem ProjectResearchInfoItem;
    private JMenuItem SemesterInfoItem;
    private JMenuItem StudentItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public MenuForm(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        ApplicantInfomenu = new JMenu("ApplicantInfo");
        CourseInfomenu = new JMenu("CourseInfo");
        Financial_issues_infomenu= new JMenu("Financial_issues_info");
        ProjectResearchInfomenu = new JMenu("ProjectResearchInfo ");
        SemesterInfomenu = new JMenu("ProjectResearchInfo");
        Studentmenu = new JMenu("Student");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(ApplicantInfomenu);
        ApplicantInfoItem = new JMenuItem("ApplicantInfoForm");
        ApplicantInfoItem.addActionListener(this);
        
        menuBar.add(CourseInfomenu);
        CourseInfoItem = new JMenuItem("CourseInfoForm");
        CourseInfoItem.addActionListener(this);
        
        menuBar.add(Financial_issues_infomenu);
        Financial_issues_infoItem = new JMenuItem("Financial_issues_infoForm");
        Financial_issues_infoItem.addActionListener(this);
        
        menuBar.add(ProjectResearchInfomenu);
        ProjectResearchInfoItem = new JMenuItem("ProjectResearchInfoForm");
        ProjectResearchInfoItem.addActionListener(this);
        
        menuBar.add(SemesterInfomenu);
        SemesterInfoItem = new JMenuItem("SemesterInfoForm");
        SemesterInfoItem.addActionListener(this);
        
        menuBar.add(Studentmenu);
        StudentItem = new JMenuItem("StudentForm");
        StudentItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        ApplicantInfomenu.add(ApplicantInfoItem);
        CourseInfomenu.add(CourseInfoItem);
        Financial_issues_infomenu.add(Financial_issues_infoItem);
        ProjectResearchInfomenu.add(ProjectResearchInfoItem);
        SemesterInfomenu.add(SemesterInfoItem);
        Studentmenu.add(StudentItem);
        
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ApplicantInfoItem) {
            new ApplicantInfoForm();
        
        } else if (e.getSource() == CourseInfoItem) {
            new CourseInfoForm();
        
        } else if (e.getSource() == Financial_issues_infoItem) {
            new Financial_IssuesInfoForm();
       
        } else if (e.getSource() == ProjectResearchInfoItem) {
           new ProjectResearchForm();
        
        } else if (e.getSource() == SemesterInfoItem) {
           new SemesterInfoForm();
           
        } else if (e.getSource() == StudentItem) {
            new StudentForm();
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuForm("TO GRADUATE STUDENT MANAGENT"));
    }
}




