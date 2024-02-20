package MyAllForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MyAllEntities.Student;


public class StudentForm implements ActionListener{
	
	JFrame frame;
	JLabel stdid_lb=new JLabel("student_id");
	JLabel fnme_lb=new JLabel("first_name");
	JLabel lnme_lb=new JLabel("last_name");
	JLabel dob_lb=new JLabel("date_of_birth");
	JLabel email_lb=new JLabel("email");
	JLabel phnenmbr_lb=new JLabel("phone_number");
	JLabel gender_lb=new JLabel("Gender");
	
	JTextField stdid_txf=new JTextField();
	JTextField fnme_txf=new JTextField();
	JTextField lnme_txf=new JTextField();
	JTextField dob_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phnenmbr_txf=new JTextField();
	JTextField gender_txf=new JTextField();
	
	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public StudentForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("STUDENT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		stdid_lb.setBounds(10,10,130,30);
		fnme_lb.setBounds(10,50,130,30);
		lnme_lb.setBounds(10,90,130,30);
		dob_lb.setBounds(10,130,170,30);
		email_lb.setBounds(10,170,150,30);
		phnenmbr_lb.setBounds(10,210,200,30);
		gender_lb.setBounds(10,250,150,30);
		
		stdid_txf.setBounds(190,10,190,30);
		fnme_txf.setBounds(190,50,190,30);
		lnme_txf.setBounds(190,90,190,30);
		dob_txf.setBounds(190,130,190,30);
		email_txf.setBounds(190,170,190,30);
		phnenmbr_txf.setBounds(190,210,190,30);
		genderBox.setBounds(190,250,190,30);
     
		insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		
		table.setBounds(500, 20, 700, 290);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		stdid_lb.setFont(font);
		fnme_lb.setFont(font);
		lnme_lb.setFont(font);
		dob_lb.setFont(font);
		email_lb.setFont(font);
		phnenmbr_lb.setFont(font);
		gender_lb.setFont(font);
	
		stdid_txf.setFont(font);
		fnme_txf.setFont(font);
		lnme_txf.setFont(font);
		dob_txf.setFont(font);
		email_txf.setFont(font);
		phnenmbr_txf.setFont(font);
		genderBox.setFont(font);
		
	
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(stdid_lb);
		frame.add(fnme_lb);
		frame.add(lnme_lb);
		frame.add(dob_lb);
		frame.add(email_lb);
		frame.add(phnenmbr_lb);
		frame.add(gender_lb);
		
		frame.add(stdid_txf);
		frame.add(fnme_txf);
		frame.add(lnme_txf);
		frame.add(dob_txf);
		frame.add(email_txf);
		frame.add(phnenmbr_txf);
		frame.add(genderBox);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();}

	@Override
	public void actionPerformed(ActionEvent e) {
		Student st=new Student();
		if(e.getSource()==insert_btn) {
			
            st.setFnme(fnme_txf.getText());
            st.setLnme(lnme_txf.getText());
            st.setDob(dob_txf.getText());
			st.setEmail(email_txf.getText());
			st.setPhnenmbr(phnenmbr_txf.getText());
			
		    String selectedOption = (String) genderBox.getSelectedItem();
			st.setGender(selectedOption);
			st.insertData();
			
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("financial_info_id");
            model.addColumn("school_fees");
            model.addColumn("library_status");
            model.addColumn("student_id");
            model.addColumn("Email");
            model.addColumn("phone_number");
            model.addColumn("Gender");
            //financial_info_id	school_fees	library_status	student_id
           ResultSet resultSet =Student.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)
                                , resultSet.getString(7)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(stdid_txf.getText());
			    st.setFnme(fnme_txf.getText());
	            st.setLnme(lnme_txf.getText());
	            st.setDob(dob_txf.getText());
				st.setEmail(email_txf.getText());
				st.setPhnenmbr(phnenmbr_txf.getText());
			    st.setGender((String)genderBox.getSelectedItem());
			st.update(id);
	    }
	  else {
			int id=Integer.parseInt(stdid_txf.getText());
			st.delete(id);}

	  }
		
	public static void main(String[] args) {
		StudentForm stf= new StudentForm();
		System.out.println(stf);

	
	}

}
