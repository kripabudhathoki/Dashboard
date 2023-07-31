package swingproject;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

	public class dashboard implements ActionListener {
		JTextField firstname;
		JTextField lastname;
		JTextField address;
		JTextField contact;
		JTextField rollno;
		JTextField gender;
		JTextField program;
		JTextField marksof;
		JButton jb;
		JButton jb1;
		JButton jb2;
		JRadioButton radioMale;
		JRadioButton radioFemale;
		JComboBox comboprogram;
		JComboBox combomarksof;
		
		public dashboard() {
			JFrame jf = new JFrame();
			JPanel pp = new JPanel();
			JPanel jp = new JPanel();
			FlowLayout fl = new FlowLayout(FlowLayout.LEFT,10,10);
			GridLayout gl = new GridLayout(6,2,10,10);
			pp.setLayout(gl);			
			jp.setLayout(fl);
			pp.setBorder(new EmptyBorder(10, 10, 10, 15));
			
			JLabel jl = new JLabel("First Name:");
			JLabel jl2 = new JLabel("Last Name:");
			JLabel jl3 = new JLabel("Address:");
			JLabel jl4 = new JLabel("Contact:");
			JLabel jl5 = new JLabel("Roll no:");
			JLabel jl6 = new JLabel("Gender:");
			JLabel jl7 = new JLabel("Program:");
			JLabel jl8 = new JLabel("Marks of:");
//			DefaultTableModel model=new DefaultTableModel();
//			model.addColumn("firstname");
//			model.addColumn("lastname");
//			model.addColumn("address");
//			model.addColumn("contact");
//			model.addColumn("rollno");
//			model.addColumn("gender");
//			model.addColumn("program");
//			model.addColumn("marksof");
			firstname = new JTextField(10);
			lastname = new JTextField(10);
			address = new JTextField(10);
			contact = new JTextField(10);
			rollno = new JTextField(10);
			gender = new JTextField(10);
			program = new JTextField(10);
			marksof = new JTextField(10);
			radioMale = new JRadioButton("Male");
			radioFemale = new JRadioButton("Female");
			jp.add(radioMale);
			jp.add(radioFemale);
			ButtonGroup bg =new ButtonGroup();
			bg.add(radioMale);
			bg.add(radioFemale);
			String Program[] = {"BBA","BBA-BI","BCIS","BBA-TT"};
			comboprogram = new JComboBox(Program);
			String Marksof[] = {"Maths","Java","English","Digital"};
			combomarksof = new JComboBox(Marksof);
			JButton jb=new JButton("Add");
			JButton jb1=new JButton("display");
			JButton jb2=new JButton("Reset");
			
			jl.setBounds(10, 10, 190, 30);
			firstname.setBounds(200, 10, 150, 30);
			jl2.setBounds(10, 30, 190, 50);	
			lastname.setBounds(200, 40, 150, 30);
			jl3.setBounds(10, 50, 190, 80);
			address.setBounds(200, 70, 150, 30);
			jl4.setBounds(10, 70, 190, 100);
			contact.setBounds(200, 100, 150, 30);
			jl5.setBounds(10, 90, 190, 120);
			rollno.setBounds(200, 130, 150, 30);
			jb.setBounds(50,280,100,30);
			jb1.setBounds(150,280,100,30);
			jb2.setBounds(250,280,100,30);
			jl6.setBounds(10,130,190,100);
			jl7.setBounds(10,150,190,120);
			comboprogram.setBounds(200, 190, 150, 30);
			jl8.setBounds(10,180,190,120);
			combomarksof.setBounds(200, 230, 150, 30);
			jp.setBounds(200,150,190,30);
			
			jp.setSize(160,30);
			pp.add(jl);
		    pp.add(firstname);
			pp.add(jl2);
			pp.add(lastname);
			pp.add(jl3);
			pp.add(address);
			pp.add(jl4);
			pp.add(contact);
			pp.add(jl5);
			pp.add(rollno);
			pp.add(jl6);
			pp.add(jp);
			pp.add(program);
			pp.add(jl7);
			pp.add(marksof);
			pp.add(jl8);
			pp.add(jb);
			pp.add(jb1);
			pp.add(jb2);
			pp.add(jl5);
			pp.add(comboprogram);
			pp.add(combomarksof);
			jb.addActionListener(this);
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jf.setContentPane(pp); 
			jf.setSize(400,380); 
			jf.setLayout(null);
			jf.setVisible(true); 

		}
//	public static void main (String[] args) {
//			dashboard d= new dashboard();
//		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()=="Add") {
				String fName= firstname.getText().toString();
				String lName= lastname.getText().toString();
				String add= address.getText().toString();
				String con= contact.getText().toString();
				String roll= rollno.getText().toString();
				String gender=null;
				if(radioMale.isSelected()) {
					gender="male";
				}else {
					gender="female";
				}
				String program= (String) comboprogram.getSelectedItem();
				
				try {
					Writer writer = new FileWriter("C:\\javaproject\\dashboard.txt",true);

					
					writer.write(fName+"\t"+lName+"\t"+add+"\t"+con+"\t"+roll+"\t"+gender+"\t"+program+"\t");
					writer.flush();
					writer.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else if(e.getActionCommand()=="display") {
				//
				String fname;
				String lname,gender,add,con,roll,program;
				
				String line = null;
					
					try {
						BufferedReader reader = new BufferedReader(new FileReader("C:\\javaproject\\dashboard.txt"));
						line =reader.readLine();
						//while(line!=null) {
							String credintials[] = line.split("\t");
							fname=credintials[0];
							lname=credintials[1];
							gender=credintials[2];
							add=credintials[3];
							con=credintials[3];
							roll=credintials[3];
							program=credintials[4];
							
						  JOptionPane.showMessageDialog(null,fname+"\t"+lname+"\t"+gender+"\t"+add+"\t"+con+"\t"+roll+"\t"+program,"Status",JOptionPane.INFORMATION_MESSAGE);
							
						
					  JOptionPane.showMessageDialog(null,fname+"\t"+lname+"\t"+gender+"\t"+add+"\t"+con+"\t"+roll+"\t"+program,"Status",JOptionPane.INFORMATION_MESSAGE);
						
							
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		

		}



