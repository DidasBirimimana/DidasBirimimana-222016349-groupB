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

import MyAllEntities.ApplicantInfo;

public class ApplicantInfoForm implements ActionListener{

	JFrame frame;//applicant_info_id	father_name	mother_name	email	phone	address	age	
	JLabel aplinfoid_lb=new JLabel("applicant_info_id");
	JLabel fathername_lb=new JLabel("father_name");
	JLabel mothername_lb=new JLabel("mother_name");
	JLabel email_lb=new JLabel("email");
	JLabel phnenmbr_lb=new JLabel("phone_number");
	JLabel address_lb=new JLabel("address");
	JLabel age_lb=new JLabel("age");
	
	JTextField aplinfoid_txf=new JTextField();
	JTextField fathername_txf=new JTextField();
	JTextField mothername_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phnenmbr_txf=new JTextField();
	JTextField address_txf=new JTextField();
	JTextField age_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public ApplicantInfoForm(){
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
		frame.setTitle("APPLICANT INFO FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		aplinfoid_lb.setBounds(10,10,190,30);
		fathername_lb.setBounds(10,50,190,30);
		mothername_lb.setBounds(10,90,190,30);
		email_lb.setBounds(10,130,170,30);
		phnenmbr_lb.setBounds(10,170,150,30);
		address_lb.setBounds(10,210,200,30);
		age_lb.setBounds(10,250,150,30);
		
		aplinfoid_txf.setBounds(190,10,190,30);
		fathername_txf.setBounds(190,50,190,30);
		mothername_txf.setBounds(190,90,190,30);
		email_txf.setBounds(190,130,190,30);
		phnenmbr_txf.setBounds(190,170,190,30);
		address_txf.setBounds(190,210,190,30);
		age_txf.setBounds(190,250,190,30);
     
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
		aplinfoid_lb.setFont(font);
		fathername_lb.setFont(font);
		mothername_lb.setFont(font);
		email_lb.setFont(font);
		phnenmbr_lb.setFont(font);
		address_lb.setFont(font);
		age_lb.setFont(font);
	
		aplinfoid_txf.setFont(font);
		fathername_txf.setFont(font);
		mothername_txf.setFont(font);
		email_txf.setFont(font);
		phnenmbr_txf.setFont(font);
		address_txf.setFont(font);
		age_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(aplinfoid_lb);
		frame.add(fathername_lb);
		frame.add(mothername_lb);
		
		frame.add(email_lb);
		frame.add(phnenmbr_lb);
		frame.add(address_lb);
		frame.add(age_lb);
		
		frame.add(aplinfoid_txf);
		frame.add(fathername_txf);
		frame.add(mothername_txf);
		frame.add(email_txf);
		frame.add(phnenmbr_txf);
		frame.add(address_txf);
		frame.add(age_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
 }
@Override
    public void actionPerformed(ActionEvent e) {
	ApplicantInfo api=new ApplicantInfo();
	if(e.getSource()==insert_btn) {
		
        api.setFathername(fathername_txf.getText());
        api.setMothername(mothername_txf.getText());
        api.setEmail(email_txf.getText());
		api.setPhnenmbr(phnenmbr_txf.getText());
		api.setAddress(address_txf.getText());
		api.setAge(age_txf.getText());
		
		api.insertData();
		
	}
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("applicant_info_id");
        model.addColumn("father_name");
        model.addColumn("mother_name");
        model.addColumn("Email");
        model.addColumn("phone_number");
        model.addColumn("address");
        model.addColumn("age");
        
       ResultSet resultSet =ApplicantInfo.viewData();
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
		int id=Integer.parseInt(aplinfoid_txf.getText());
		 api.setFathername(fathername_txf.getText());
	        api.setMothername(mothername_txf.getText());
	        api.setEmail(email_txf.getText());
			api.setPhnenmbr(phnenmbr_txf.getText());
			api.setAddress(address_txf.getText());
			api.setAge(age_txf.getText());
		api.update(id);
    }
  else {
		int id=Integer.parseInt(aplinfoid_txf.getText());
		api.delete(id);}

  }
	
	
    public static void main(String[] args) {
    	ApplicantInfoForm apif= new ApplicantInfoForm();
		System.out.println(apif);

	}
}