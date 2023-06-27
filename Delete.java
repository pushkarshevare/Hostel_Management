import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delete implements ActionListener {
	JFrame Df;
	JTextField dtf;
	JButton db,db2;
	public Delete()
	{
		 Df = new JFrame("Delete");
		
		JLabel dl= new JLabel("Enter Bed No of Student You Want to Delete");
		dl.setBounds(150, 10, 250, 30);
		Df.add(dl);
		
		
		 dtf = new JTextField(20);
		dtf.setBounds(150, 40, 250, 20);
		Df.add(dtf);
		
		
		 db = new JButton("Delete");
		db.setBounds(230, 70, 80, 25);
		Df.add(db);
		
		db2 = new JButton("Back");
		db2.setBounds(230, 100, 80, 25);
		Df.add(db2);
		
		
		
		db.addActionListener(this);
		db2.addActionListener(this);
		Df.setSize(550, 350);
		Df.setLayout(null);
		Df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Df.setVisible(true);

	}
	public static void main(String[] args) {
		new Delete();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if (e.getSource()==db) {
			int n = Integer.parseInt(dtf.getText());
			try {
				Connection con=null;
				Statement st;
				ResultSet rs=null;
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false"; 
				String user = "root";
				String pass = "Pankaj@18";
				
				con = DriverManager.getConnection(url,user,pass);
				st = con.createStatement();
				
				PreparedStatement ps = con.prepareStatement("DELETE FROM HostelData where Bedno=?");
				
				ps.setInt(1, n);
				
				int res = ps.executeUpdate();
				JOptionPane.showMessageDialog(Df, "Record Deleted!!",
			               "Hostel Management", JOptionPane.WARNING_MESSAGE);
				new Fifth();
				Df.setVisible(false);
			
			
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
			
		} else if(e.getSource()==db2){
			new Fifth();
			Df.setVisible(false);
			

		}

		
	}

}
