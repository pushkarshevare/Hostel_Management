import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import javax.swing.*;

public class Second implements ActionListener {
	JFrame f1;
	JTextField tf;
	JPasswordField p1;
	JButton b1;
	JLabel l1,l2,l3;
	
	public Second()
	{
		f1 = new JFrame("Hostel Management");
		l1= new JLabel("Login");
		l1.setFont(new Font("Serif", Font.PLAIN, 24));
		l1.setBounds(220, 20, 500, 100);
		l2 = new JLabel("Username:");
		l2.setBounds(150, 70, 500, 100);
		tf = new JTextField();
		tf.setBounds(250, 110, 120, 20);
		l3 = new JLabel("PassWord:");
		l3.setBounds(150, 100, 500, 100);
		p1 = new JPasswordField();
		p1.setToolTipText("Numbers Only");
		p1.setBounds(250, 140, 120, 20);
		
		
		b1 = new JButton("Login");
		b1.setBounds(200, 190, 150, 30);
		
		b1.addActionListener(this);
		

		
		
		
	
		f1.add(l1);
		f1.add(l2);
		f1.add(tf);
		f1.add(l3);
		f1.add(p1);
		f1.add(b1);
				
		f1.setSize(550, 350);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}
	public static void main(String[] args) {
		new Second();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username = tf.getText();
		String password = p1.getText();
		String a = null;
		String b = null;
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
			
			rs = st.executeQuery("select * from HostelLogin");
	    	
	    	while (rs.next()) {
	    		a = rs.getString(1);
	    		b = rs.getString(2);
	    		
			}
	    	if (username.equals(a) && password.equals(b)) {
	    		
				new Third();
				f1.setVisible(false);
			} else {
				 JOptionPane.showMessageDialog(f1, "Error!!\nInvalid Credentials",
			               "Hostel Management", JOptionPane.ERROR_MESSAGE);
			}
		
	    	
	 
		} catch (Exception e1) {
			System.out.println(e1);
		}
	
	
		
		
		
		
		
	}

}
