package swingproject;

import javax.swing.JButton;
import javax.swing.JPanel;

public class tabledemo {
	public class table extends tabledemo{

		public table() {
			
			JPanel jp = new JPanel();// creating intermediate container
			
			JButton jb = new JButton("Submit");// component
			
			setContentPane(jp);
			setTitle("Second");	
			setSize(300,300);
			setVisible(true);	
		}

		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			tabledemo fed = new tabledemo();

		}


	}

}
