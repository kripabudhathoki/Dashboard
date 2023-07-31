package swingproject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class table {
	public table() {


		JTable jt= new JTable();
//		Object[]columns= {"firstname","lastname","address","contact","rollno","gender","program","marksof"};
//		DefaultTableModel model=new DefaultTableModel();
//		model.addColumn("firstname");
//		model.addColumn("lastname");
//		model.addColumn("address");
//		model.addColumn("contact");
//		model.addColumn("rollno");
//		model.addColumn("gender");
//		model.addColumn("program");
//		model.addColumn("marksof");
		JFrame f=new JFrame();
		f.setSize(420,240);
		f.setLayout(null);
		f.setVisible(true);
		
		f.setTitle("first frame");
		
		JPanel jp = new JPanel();
		
		JButton jb = new JButton("Add");
		
		
		jp.add(jb);
		
		f.setContentPane(jp);
		
		f.setLayout(null);
		f.setSize(250,250);
		f.setVisible(true);
}
public static void main(String[] args) {
	table fd = new table();
}


	}


