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

import MyAllEntities.CourseInfo;

public class CourseInfoForm implements ActionListener{
	JFrame frame;//course_id	student_id	course_title	department	credits_number	semester_offered	grade
	JLabel crsid_lb=new JLabel("course_id");
	JLabel stdid_lb=new JLabel("student_id");
	JLabel crstittle_lb=new JLabel("course_title");
	JLabel dprtmnt_lb=new JLabel("department");
	JLabel crdtnmbr_lb=new JLabel("credits_number");
	JLabel smstroffrd_lb=new JLabel("semester_offered");
	JLabel grade_lb=new JLabel("grade");
	
	JTextField crsid_txf=new JTextField();
	JTextField stdid_txf=new JTextField();
	JTextField crstittle_txf=new JTextField();
	JTextField dprtmnt_txf=new JTextField();
	JTextField crdtnmbr_txf=new JTextField();
	JTextField smstroffrd_txf=new JTextField();
	JTextField grade_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public CourseInfoForm(){
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
		frame.setTitle("COURSES INFO FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		crsid_lb.setBounds(10,10,190,30);
		stdid_lb.setBounds(10,50,190,30);
		crstittle_lb.setBounds(10,90,190,30);
		dprtmnt_lb.setBounds(10,130,170,30);
		crdtnmbr_lb.setBounds(10,170,150,30);
		smstroffrd_lb.setBounds(10,210,200,30);
		grade_lb.setBounds(10,250,150,30);
		
		crsid_txf.setBounds(190,10,190,30);
		stdid_txf.setBounds(190,50,190,30);
		crstittle_txf.setBounds(190,90,190,30);
		dprtmnt_txf.setBounds(190,130,190,30);
		crdtnmbr_txf.setBounds(190,170,190,30);
		smstroffrd_txf.setBounds(190,210,190,30);
		grade_txf.setBounds(190,250,190,30);
		
     
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
		crsid_lb.setFont(font);
		stdid_lb.setFont(font);
		crstittle_lb.setFont(font);
		dprtmnt_lb.setFont(font);
		crdtnmbr_lb.setFont(font);
		smstroffrd_lb.setFont(font);
		grade_lb.setFont(font);
	
		crsid_txf.setFont(font);
		stdid_txf.setFont(font);
		crstittle_txf.setFont(font);
		dprtmnt_txf.setFont(font);
		crdtnmbr_txf.setFont(font);
		smstroffrd_txf.setFont(font);
		grade_txf.setFont(font);
		
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(crsid_lb);
		frame.add(stdid_lb);
		frame.add(crstittle_lb);
		
		frame.add(dprtmnt_lb);
		frame.add(crdtnmbr_lb);
		frame.add(smstroffrd_lb);
		frame.add(grade_lb);
		
		frame.add(crsid_txf);
		frame.add(stdid_txf);
		frame.add(crstittle_txf);
		frame.add(dprtmnt_txf);
		frame.add(crdtnmbr_txf);
		frame.add(smstroffrd_txf);
		frame.add(grade_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
	
		frame.add(table);
		ActionEvent ();
 }


@Override
public void actionPerformed(ActionEvent e) {
	 CourseInfo cr=new  CourseInfo();
	if(e.getSource()==insert_btn) {
		
        cr.setStdid(stdid_txf.getText());
        cr.setCrstittle(crstittle_txf.getText());
        cr.setDprtmnt(dprtmnt_txf.getText());
		cr.setCrdtnmbr(crdtnmbr_txf.getText());
		cr.setSmstroffrd(smstroffrd_txf.getText());
		cr.setGrade(grade_txf.getText());
		
		cr.insertData();
		
	}
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("course_id");
        model.addColumn("student_id");
        model.addColumn("course_title");
        model.addColumn("department");
        model.addColumn("credits_number");
        model.addColumn("semester_offered");
        model.addColumn("grade");
        //course_id	student_id	course_title	department	credits_number	semester_offered	grade
       ResultSet resultSet = CourseInfo.viewData();
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
		int id=Integer.parseInt(crsid_txf.getText());
		 cr.setStdid(stdid_txf.getText());
	        cr.setCrstittle(crstittle_txf.getText());
	        cr.setDprtmnt(dprtmnt_txf.getText());
			cr.setCrdtnmbr(crdtnmbr_txf.getText());
			cr.setSmstroffrd(smstroffrd_txf.getText());
			cr.setGrade(grade_txf.getText());
		cr.update(id);
    }
  else {
		int id=Integer.parseInt(crsid_txf.getText());
		cr.delete(id);}

  }
	

	public static void main(String[] args) {
		 CourseInfoForm crsf= new CourseInfoForm();
			System.out.println(crsf);

	}

}
