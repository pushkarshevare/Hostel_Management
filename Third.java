import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Third implements ActionListener {
	JFrame f1;
	JButton b1,b2,b3,b4;
	JLabel l1;
	
	public Third()
	{
		f1 = new JFrame("Hostel Management");
		l1= new JLabel("WelCome To Pushkar PG");
		l1.setFont(new Font("Serif", Font.PLAIN, 24));
		l1.setBounds(150, 10, 500, 100);
		
		b1 = new JButton("New Registration");
		b1.setBounds(200, 110, 150, 30);
		
		b2 = new JButton("Student Data");
		b2.setBounds(200, 160, 150, 30);
		
		b3 = new JButton("Fee Structure");
		b3.setBounds(200, 210, 150, 30);
		
		b4 = new JButton("Logout");
		b4.setBounds(410, 270, 110, 30);
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		

		
		
		
		
		f1.add(l1);
		f1.add(b1);
		f1.add(b2);
		f1.add(b3);
		f1.add(b4);
		
		
		f1.setSize(550, 350);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}
	public static void main(String[] args) {
		
		new Third();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==b1)
		{
			
			new Fourth();
			f1.setVisible(false);
		}
		else if(e.getSource()==b2)
		{
			
			new Fifth();
			f1.setVisible(false);
		}
		else if(e.getSource()==b3)
		{
			
			new Sixth();
			f1.setVisible(false);
		}
		else if(e.getSource()==b4)
		{
			new Second();
			f1.setVisible(false);
		}
	}

}
