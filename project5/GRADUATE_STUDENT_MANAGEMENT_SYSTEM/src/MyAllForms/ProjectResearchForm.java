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

import MyAllEntities.ProjectResearchInfo;


public class ProjectResearchForm implements ActionListener{
	JFrame frame;//project_id	project_name	project_purpose	student_id	project_invigilator_name	
	JLabel prjctid_lb=new JLabel("project_id");
	JLabel prjctname_lb=new JLabel("project_name");
	JLabel prjctprpse_lb=new JLabel("project_purpose");
	JLabel stdid_lb=new JLabel("student_id");
	JLabel prjctinvgltrname_lb=new JLabel("project_invigilator_name");
	
	
	JTextField prjctid_txf=new JTextField();
	JTextField prjctname_txf=new JTextField();
	JTextField prjctprpse_txf=new JTextField();
	JTextField stdid_txf=new JTextField();
	JTextField prjctinvgltrname_txf=new JTextField();

	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public ProjectResearchForm(){
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
		frame.setTitle("PROJECT RESEARCH INFO FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		prjctid_lb.setBounds(10,10,190,30);
		prjctname_lb.setBounds(10,50,190,30);
		prjctprpse_lb.setBounds(10,90,190,30);
		stdid_lb.setBounds(10,130,170,30);
		prjctinvgltrname_lb.setBounds(10,170,190,30);
		
		
		prjctid_txf.setBounds(250,10,190,30);
		prjctname_txf.setBounds(250,50,190,30);
		prjctprpse_txf.setBounds(250,90,190,30);
		stdid_txf.setBounds(250,130,190,30);
		prjctinvgltrname_txf.setBounds(250,170,190,30);
		
		insert_btn.setBounds(10,220,85,30);
		read_btn.setBounds(110,220,85,30);
		update_btn.setBounds(210,220,85,30);
		delete_btn.setBounds(310,220,85,30);
		
		table.setBounds(500, 20, 700, 290);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		prjctid_lb.setFont(font);
		prjctname_lb.setFont(font);
		prjctprpse_lb.setFont(font);
		stdid_lb.setFont(font);
		prjctinvgltrname_lb.setFont(font);
		
	    prjctid_txf.setFont(font);
		prjctname_txf.setFont(font);
		prjctprpse_txf.setFont(font);
		stdid_txf.setFont(font);
		prjctinvgltrname_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(prjctid_lb);
		frame.add(prjctname_lb);
		frame.add(prjctprpse_lb);
		frame.add(stdid_lb);
		frame.add(prjctinvgltrname_lb);
		
	    frame.add(prjctid_txf);
		frame.add(prjctname_txf);
		frame.add(prjctprpse_txf);
		frame.add(stdid_txf);
		frame.add(prjctinvgltrname_txf);
	
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
	
		frame.add(table);
		ActionEvent ();
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	ProjectResearchInfo sm=new  ProjectResearchInfo();
	if(e.getSource()==insert_btn) {

        sm.setPrjctname(prjctname_txf.getText());
        sm.setPrjctprpse(prjctprpse_txf.getText());
		sm.setStdid(stdid_txf.getText());
		sm.setPrjctinvgltrname(prjctinvgltrname_txf.getText());
	     sm.insertData();
		
	}
	else if (e.getSource() == read_btn) {
       model.setColumnCount(0);
       model.setRowCount(1);
       model.addColumn("project_id");
       model.addColumn("project_name");
       model.addColumn("project_purpose");
       model.addColumn("student_id");
       model.addColumn("project_invigilator_name");
      
      ResultSet resultSet = ProjectResearchInfo.viewData();
       if (resultSet != null) {
           try {
               while (resultSet.next()) {
                   model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                           resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
               }
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       }
   }
   else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(prjctid_txf.getText());

        sm.setPrjctname(prjctname_txf.getText());
        sm.setPrjctprpse(prjctprpse_txf.getText());
		sm.setStdid(stdid_txf.getText());
		sm.setPrjctinvgltrname(prjctinvgltrname_txf.getText());
		sm.update(id);
   }
 else {
		int id=Integer.parseInt(prjctid_txf.getText());
		sm.delete(id);}

	
}

public static void main(String[] args) {
	ProjectResearchForm Psf= new ProjectResearchForm();
		System.out.println(Psf);
 }

}