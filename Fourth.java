import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class Fourth implements ActionListener {
	JFrame f;
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JRadioButton r1,r2;
	JButton b,b1;
	
	
	public Fourth()
	{
		f = new JFrame("Hostel Management");
		l= new JLabel("Student Registration");
		l.setFont(new Font("Serif", Font.PLAIN, 34));
		l.setBounds(490, 10, 500, 100);
		
		
		l1 = new JLabel("Bed No:");
		l1.setBounds(450, 70, 500, 100);
		tf1 = new JTextField();
		tf1.setBounds(550, 110, 200, 20);
		
		
		l2 = new JLabel("First Name:");
		l2.setBounds(450, 100, 500, 100);
		tf2 = new JTextField();
		tf2.setBounds(550, 140, 200, 20);
		
		
		l3 = new JLabel("Last Name :");
		l3.setBounds(450, 130, 500, 100);
		tf3 = new JTextField();
		tf3.setBounds(550, 170, 200, 20);
		
		
		l4 = new JLabel("Age :");
		l4.setBounds(450, 160, 500, 100);
		tf4 = new JTextField();
		tf4.setBounds(550, 200, 200, 20);
		
		
		l5 = new JLabel("Stream :");
		l5.setBounds(450, 190, 500, 100);
		tf5 = new JTextField();
		tf5.setBounds(550, 230, 200, 20);
		
		
		l6 = new JLabel("Gender :");
		l6.setBounds(450, 220, 500, 100);
		r1 = new JRadioButton("Male");
		r1.setBounds(550, 260, 80, 20);
		r2 = new JRadioButton("Female");
		r2.setBounds(650, 260, 90, 20);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);
		
		
		l7 = new JLabel("Contact No. :");
		l7.setBounds(450, 250, 500, 100);
		tf6 = new JTextField();
		tf6.setBounds(550, 290, 200, 20);
		
		
		l8 = new JLabel("Parent's No:");
		l8.setBounds(450, 280, 500, 100);
		tf7 = new JTextField();
		tf7.setBounds(550, 320, 200, 20);
		
		b = new JButton("Submit");
		b.setBounds(540, 370, 100, 30);
		b1 = new JButton("Back");
		b1.setBounds(540, 420, 100, 30);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		
		
		
		
		
		
		
		f.add(l);
		f.add(l1);
		f.add(tf1);
		f.add(l2);
		f.add(tf2);
		f.add(l3);
		f.add(tf3);
		f.add(l4);
		f.add(tf4);
		f.add(l5);
		f.add(tf5);
		f.add(l6);
		f.add(r1);
		f.add(r2);
		f.add(l7);
		f.add(tf6);
		f.add(l8);
		f.add(tf7);
		f.add(b);
		f.add(b1);
		
		
		f.setSize(1366, 768);
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Fourth();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		String s=null;
		if (e.getSource()==b) {
			if (r1.isSelected()) {
				s=r1.getText();
			}
			else if (r2.isSelected()) {
				s=r2.getText();
			}
			
			
			try {
				Connection con = null;
				ResultSet rs = null;
				Statement st;
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false"; // (sys?useSSL=false)== url for connection
				String user = "root";
				String pass = "Pankaj@18";
				con = DriverManager.getConnection(url,user,pass);
				st = con.createStatement();
				
				PreparedStatement ps = con.prepareStatement("INSERT INTO HostelData values(?,?,?,?,?,?,?,?)");
				
				ps.setString(1, tf1.getText());
				ps.setString(2, tf2.getText());
				ps.setString(3, tf3.getText());
				ps.setString(4, tf4.getText());
				ps.setString(5, tf5.getText());
				ps.setString(6, s);
				ps.setString(7, tf6.getText());
				ps.setString(8, tf7.getText());
				
				int res = ps.executeUpdate();
				JOptionPane.showMessageDialog(f, "Submitted!!",
			               "Hostel Management", JOptionPane.WARNING_MESSAGE);
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
			
			
			
			
			
		} else if(e.getSource()==b1){
			
				new Third();
				f.setVisible(false);
		}
		
		
	}

}
