package Sinup;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Admin.Admin;
import Login.AdminLogin;

public class AdminSinup extends JFrame{
	
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fnametext;
	private JTextField lnametext;
	private JTextField phonetext;
	private JTextField martialStatustext;
	private JTextField dobtxt;
	private JTextField emailtext;
	private JPasswordField passwordtext;
	private JComboBox gendertxt;

	/**
	 * Launch the application.
	 */

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			AdminSinup frame = new AdminSinup();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});
}

/**
* Create the frame.
*/
public AdminSinup() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 633, 505);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblfnmae = new JLabel("FIRST NAME :");
lblfnmae.setBounds(10, 25, 77, 23);
contentPane.add(lblfnmae);

JLabel lbllname = new JLabel("LAST NAME :");
lbllname.setBounds(10, 72, 77, 23);
contentPane.add(lbllname);

fnametext = new JTextField();
fnametext.setBounds(97, 20, 180, 33);
contentPane.add(fnametext);
fnametext.setColumns(10);

lnametext = new JTextField();
lnametext.setBounds(97, 74, 180, 33);
lnametext.setColumns(10);
contentPane.add(lnametext);

JLabel lblPhone = new JLabel("Phone :");
lblPhone.setBounds(10, 130, 77, 23);
contentPane.add(lblPhone);

phonetext = new JTextField();
phonetext.setBounds(97, 130, 180, 33);
phonetext.setColumns(10);
contentPane.add(phonetext);

JLabel lblGender = new JLabel(" Gender :");
lblGender.setBounds(10, 210, 77, 23);
contentPane.add(lblGender);

JLabel lblMartialStatus = new JLabel("Martial status :");
lblMartialStatus.setBounds(348, 30, 77, 23);
contentPane.add(lblMartialStatus);

martialStatustext = new JTextField();
martialStatustext.setBounds(425, 27, 180, 33);
martialStatustext.setColumns(10);
contentPane.add(martialStatustext);

JLabel lblDateOfBirth = new JLabel("Date of Birth :");
lblDateOfBirth.setBounds(348, 77, 77, 23);
contentPane.add(lblDateOfBirth);

dobtxt = new JTextField();
dobtxt.setBounds(425, 73, 180, 33);
dobtxt.setColumns(10);
contentPane.add(dobtxt);

JLabel lblEmail = new JLabel("Email :");
lblEmail.setBounds(348, 124, 77, 23);
contentPane.add(lblEmail);

emailtext = new JTextField();
emailtext.setBounds(425, 123, 180, 33);
emailtext.setColumns(10);
contentPane.add(emailtext);

JLabel lblPhone_1_1 = new JLabel("Password :");
lblPhone_1_1.setBounds(348, 183, 77, 23);
contentPane.add(lblPhone_1_1);

passwordtext = new JPasswordField();
passwordtext.setBounds(423, 179, 182, 33);
contentPane.add(passwordtext);

JButton btnNewButton = new JButton("CANCEL");
btnNewButton.setBounds(209, 285, 126, 33);
contentPane.add(btnNewButton);

JButton signUp = new JButton("SIGN UP");
signUp.setBounds(380, 285, 132, 33);
signUp.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		AdminLogin frame = new AdminLogin();
		frame.setVisible(true);
		Admin ad = new Admin();
		if(e.getSource()==signUp) {
			ad.setFname(fnametext.getText());
			ad.setLname(lnametext.getText());
			ad.setPhone(phonetext.getText());
			ad.setMartialStatus(martialStatustext.getText());
			String selectedOption = gendertxt.getSelectedItem().toString();
			ad.setGender(selectedOption);
			ad.setDoB(dobtxt.getText());
			ad.setEmail(emailtext.getText());
			char[] passwordChars = passwordtext.getPassword();
			String passwordString = new String(passwordChars);
			ad.setPassword(passwordString);
			ad.insertData();
			System.out.print(ad.getFname() + " " + ad.getLname() + " " + ad.getGender() + " " + ad.getPhone() + " " + ad.getMartialStatus() + " " + ad.getDoB() + " " + ad.getEmail() + " " + ad.getPassword() );
		}
	}
});
contentPane.add(signUp);
String[] gender = {"Male", "Female"};
gendertxt = new JComboBox(gender);
gendertxt.setBounds(97, 210, 180, 23);
contentPane.add(gendertxt);
}


}


