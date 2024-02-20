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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MyAllEntities.SemesterInfo;


public class SemesterInfoForm implements ActionListener{
	JFrame frame;//semester_info_id	start_date	ending_date	student_id	semester_code	total_number_of_modules	failed_modules	
	JLabel smstinfoid_lb=new JLabel("semester_info_id");
	JLabel strtdate_lb=new JLabel("start_date");
	JLabel enddate_lb=new JLabel("ending_date");
	JLabel stdid_lb=new JLabel("student_id");
	JLabel smstcode_lb=new JLabel("semester_code");
	JLabel totnmbrmdls_lb=new JLabel("total_number_of_modules");
	JLabel failedmdls_lb=new JLabel("failed_modules");
	
	
	JTextField smstinfoid_txf=new JTextField();
	JTextField strtdate_txf=new JTextField();
	JTextField enddate_txf=new JTextField();
	JTextField stdid_txf=new JTextField();
	JTextField smstcode_txf=new JTextField();
	JTextField totnmbrmdls_txf=new JTextField();
	JTextField failedmdls_txf=new JTextField();
	

	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public SemesterInfoForm(){
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
		frame.setTitle("SEMESTER INFO FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		smstinfoid_lb.setBounds(10,10,190,30);
		strtdate_lb.setBounds(10,50,190,30);
		enddate_lb.setBounds(10,90,190,30);
		stdid_lb.setBounds(10,130,170,30);
		smstcode_lb.setBounds(10,170,150,30);
		totnmbrmdls_lb.setBounds(10,210,250,30);
		failedmdls_lb.setBounds(10,250,150,30);
		
		smstinfoid_txf.setBounds(250,10,190,30);
		strtdate_txf.setBounds(250,50,190,30);
		enddate_txf.setBounds(250,90,190,30);
		stdid_txf.setBounds(250,130,190,30);
		smstcode_txf.setBounds(250,170,190,30);
		totnmbrmdls_txf.setBounds(250,210,190,30);
		failedmdls_txf.setBounds(250,250,190,30);
		

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
		smstinfoid_lb.setFont(font);
		strtdate_lb.setFont(font);
		enddate_lb.setFont(font);
		stdid_lb.setFont(font);
		smstcode_lb.setFont(font);
		totnmbrmdls_lb.setFont(font);
		failedmdls_lb.setFont(font);
	
		smstinfoid_txf.setFont(font);
		strtdate_txf.setFont(font);
		enddate_txf.setFont(font);
		stdid_txf.setFont(font);
		smstcode_txf.setFont(font);
		totnmbrmdls_txf.setFont(font);
		failedmdls_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(smstinfoid_lb);
		frame.add(strtdate_lb);
		frame.add(enddate_lb);
		
		frame.add(stdid_lb);
		frame.add(smstcode_lb);
		frame.add(totnmbrmdls_lb);
		frame.add(failedmdls_lb);
		
		frame.add(smstinfoid_txf);
		frame.add(strtdate_txf);
		frame.add(enddate_txf);
		frame.add(stdid_txf);
		frame.add(smstcode_txf);
		frame.add(totnmbrmdls_txf);
		frame.add(failedmdls_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
	
		frame.add(table);
		ActionEvent ();
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	SemesterInfo sm=new  SemesterInfo();
	if(e.getSource()==insert_btn) {
		
        sm.setStrtdate(strtdate_txf.getText());
        sm.setEnddate(enddate_txf.getText());
        sm.setStdid(stdid_txf.getText());
		sm.setSmstcode(smstcode_txf.getText());
		sm.setTotnmbrmdls(totnmbrmdls_txf.getText());
		sm.setFailedmdls(failedmdls_txf.getText());
		
		sm.insertData();
		
	}
	else if (e.getSource() == read_btn) {
       model.setColumnCount(0);
       model.setRowCount(1);
       model.addColumn("semester_info_id");
       model.addColumn("start_date");
       model.addColumn("ending_date");
       model.addColumn("student_id");
       model.addColumn("semester_code");
       model.addColumn("total_number_of_modules");
       model.addColumn("failed_modules");
       //semester_info_id	start_date	ending_date	student_id	semester_code	total_number_of_modules	failed_modules	
      ResultSet resultSet = SemesterInfo.viewData();
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
		int id=Integer.parseInt(smstinfoid_txf.getText());

        sm.setStrtdate(strtdate_txf.getText());
        sm.setEnddate(enddate_txf.getText());
        sm.setStdid(stdid_txf.getText());
		sm.setSmstcode(smstcode_txf.getText());
		sm.setTotnmbrmdls(totnmbrmdls_txf.getText());
		sm.setFailedmdls(failedmdls_txf.getText());
		sm.update(id);
   }
 else {
		int id=Integer.parseInt(smstinfoid_txf.getText());
		sm.delete(id);}

 }
	
	 public static void main(String[] args) {
		 SemesterInfoForm smsf= new SemesterInfoForm();
			System.out.println(smsf);

	
	}

}
