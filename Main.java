import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Main implements ActionListener {
	
	JFrame f;
	JLabel l,l1;
	JButton b;
	public Main()
	{
		
		f = new JFrame("Hostel Management");
		

		l1 = new JLabel(new ImageIcon("C:/Users/Lenovo/eclipse/Hostel/Hostel/src/hostel.png"));
		
		l1.setBounds(400, 10, 500, 500);
		b = new JButton("Let's Started");
		b.setBounds(580, 550, 150, 30);
		b.addActionListener(this);
	
	
		
		
		f.add(l1);
		f.add(b);
		
		
		
		
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		new Main();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Second();
		f.setVisible(false);
}

}
