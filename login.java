package swingproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import swingproject.dashboard;

	public class login implements ActionListener  {
		JTextField user;
		JTextField pass;
		public login() {
			JFrame jf = new JFrame();
			JPanel jp = new JPanel();
			
			
			JLabel jl = new JLabel("User Name:");
			JLabel jl3 = new JLabel("Password :");
			user = new JTextField(10);
			pass = new JPasswordField(10);
			
			JButton jb=new JButton("Sign in");
			JButton jb1=new JButton("Register");
			
			jl.setBounds(10, 10, 190, 30);
			user.setBounds(200, 10, 150, 30);
			jl3.setBounds(10, 40, 190, 30);	
			pass.setBounds(200, 40, 150, 30);
			jb.setBounds(10,90,170,30);
			jb1.setBounds(200,90,170,30);
			jp.add(jl);
			jp.add(user);
			jp.add(jl3);
			jp.add(pass);  
			jp.add(jb);
			jp.add(jb1);
			jb.addActionListener(this);
			jb1.addActionListener(this);
			
			jf.setContentPane(jp); 
			jf.setSize(400,160); 
			jf.setLayout(null);
			jf.setVisible(true); 
			
			
		}
		public static void main(String[] args) {
			login l = new login();
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String Username;
			String Password;
			if(e.getActionCommand()=="Register") {
				try {
					Writer writer = new FileWriter("C:\\javaproject\\login.txt");
					Username= user.getText().toString();
					Password= pass.getText().toString();
					
					writer.write(Username+"\t"+Password+"\n");
					writer.flush();
					writer.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	 
				
			}
			else if(e.getActionCommand()=="Sign in") {
		
				Username= user.getText().toString();
				Password= pass.getText().toString();
				
				
				String uName;
				String passw;
				
				String line = null;
				try {
					BufferedReader reader = new BufferedReader(new FileReader("C:\\javaproject\\login.txt"));
					line =reader.readLine();
					
						String credintials[] = line.split("\t");
						uName=credintials[0];
						passw=credintials[1];
						if(uName.equals(uName) && passw.equals(passw)) {
							dashboard db = new dashboard();
						}
						else {
							JOptionPane.showMessageDialog(null,"username and password didn't match","Status",JOptionPane.INFORMATION_MESSAGE);
						}
							
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
		
		
