import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Fifth implements ActionListener  {
	
	JFrame f;
	JButton b,b1,b2,b3;
	JTable t;
	
	public Fifth()
	{
		
		f= new JFrame("Display Data");
		b= new JButton("Display");
		b.setBounds(58, 56, 95, 25);
		b1 = new JButton("Delete");
		b1.setBounds(58, 96, 95, 25);
		b2 = new JButton("Update");
		b2.setBounds(58, 136, 95, 25);
		b3 = new JButton("Back");
		b3.setBounds(58, 176, 95, 25);
		
		t = new JTable();
		t.setBounds(268, 52, 800, 500);
		

		 t.setPreferredScrollableViewportSize(new Dimension(450,63));
	        t.setFillsViewportHeight(true);

	    JScrollPane js=new JScrollPane(t);
	    js.setVisible(true);
	    f.add(js);
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		f.add(b);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(t);
		

		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	


	
	
	public static void main(String[] args) {
		new Fifth();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getSource()==b) {
				try {
					Connection con = null;
					ResultSet rs = null;
					Statement st;
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false"; // (sys?useSSL=false)== url for connection
					String user = "root";
					String pass = "Pankaj@18";
					con = DriverManager.getConnection(url,user,pass);
					st =con.createStatement();
					rs = st.executeQuery("select * from HostelData");
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) t.getModel();
					
					
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for (int i = 0; i < cols; i++) 
						colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						
						String Bedno,fname,lname,age,stream,gender,cno,pno;
					while (rs.next()) {
						Bedno = rs.getString(1);
						fname = rs.getString(2);
						lname = rs.getString(3);
						age = rs.getString(4);
						stream = rs.getString(5);
						gender = rs.getString(6);
						cno = rs.getString(7);
						pno = rs.getString(8);
						
						String row[]= {Bedno,fname,lname,age,stream,gender,cno,pno};
						model.addRow(row);
					}
				
					
				} catch (Exception e2) {
					System.out.println(e2);
				}
				
			}
			if(e.getSource()==b1)
			{
				new Delete();
				f.setVisible(false);
			}
			if(e.getSource()==b2)
			{
				new Update();
				f.setVisible(false);
			}
			if(e.getSource()==b3)
			{
				new Third();
				f.setVisible(false);
			}
			
			
			
			
			
			
		
		
	}

}
