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

import MyAllEntities.Financial_issues_info;


public class Financial_IssuesInfoForm  implements ActionListener{
	
	JFrame frame;////financial_info_id	school_fees	library_status	student_id
	JLabel fininfoid_lb=new JLabel("financial_info_id");
	JLabel schlfees_lb=new JLabel("school_fees");
	JLabel libstats_lb=new JLabel("library_status");
	JLabel stdid_lb=new JLabel("student_id");
	
	
	JTextField fininfoid_txf=new JTextField();
	JTextField schlfees_txf=new JTextField();
	
	String []schlfees={"Cleared", "Not Cleared"};
	JComboBox<String> schlfeesBox = new JComboBox<>(schlfees);
	JTextField libstats_txf=new JTextField();
	
	String []libstats={"Cleared", "Not Cleared"};
	JComboBox<String> libstatsBox = new JComboBox<>(libstats);
	JTextField stdid_txf=new JTextField();
	
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public Financial_IssuesInfoForm(){
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
		fininfoid_lb.setBounds(10,10,170,30);
		schlfees_lb.setBounds(10,50,130,30);
		libstats_lb.setBounds(10,90,170,30);
		stdid_lb.setBounds(10,130,170,30);
		
		fininfoid_txf.setBounds(190,10,190,30);
		schlfeesBox .setBounds(190,50,190,30);
		libstatsBox.setBounds(190,90,190,30);
		stdid_txf.setBounds(190,130,190,30);
		
		insert_btn.setBounds(10,220,85,30);
		read_btn.setBounds(110,220,85,30);
		update_btn.setBounds(210,220,85,30);
		delete_btn.setBounds(310,220,85,30);
		
		table.setBounds(500, 20, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		fininfoid_lb.setFont(font);
		schlfees_lb.setFont(font);
		libstats_lb.setFont(font);
		stdid_lb.setFont(font);
		
		fininfoid_txf.setFont(font);
		schlfeesBox.setFont(font);
		libstatsBox.setFont(font);
		stdid_txf.setFont(font);
	
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(fininfoid_lb);
		frame.add(schlfees_lb);
		frame.add(libstats_lb);
		frame.add(stdid_lb);
		
		frame.add(fininfoid_txf);
		frame.add(schlfeesBox);
		frame.add(libstatsBox);
		frame.add(stdid_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
}

@Override
public void actionPerformed(ActionEvent e) {
	Financial_issues_info  fin=new Financial_issues_info ();
	if(e.getSource()==insert_btn) {
		
	    String selectedOption = (String) schlfeesBox.getSelectedItem();
		fin.setSchlfees(selectedOption);
		String selectedOption1 = (String) libstatsBox.getSelectedItem();
		fin.setLibstats(selectedOption1);

        fin.setStdid(stdid_txf.getText());
       
		fin.insertData();
		
	}
	else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("financial_info_id");
        model.addColumn("school_fees");
        model.addColumn("library_status");
        model.addColumn("student_id");
       
        ////financial_info_id	school_fees	library_status	student_id
       ResultSet resultSet =Financial_issues_info .viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource()==update_btn) {
		int id=Integer.parseInt(fininfoid_txf.getText());
		 
		    fin.setSchlfees((String)schlfeesBox.getSelectedItem());
		    fin.setLibstats((String)libstatsBox.getSelectedItem());
		    fin.setStdid(stdid_txf.getText());
	       
		   fin.update(id);
    }
  else {
		int id=Integer.parseInt(fininfoid_txf.getText());
		fin.delete(id);}

  }
	
public static void main(String[] args) {
	Financial_IssuesInfoForm FIf= new Financial_IssuesInfoForm();
	System.out.println(FIf);
  }

}
