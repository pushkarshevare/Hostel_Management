import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
public class Sixth implements ActionListener {
	JFrame f;
	JLabel l,l1;
	JButton b,b1 ;
	
	public Sixth()
	{
		f = new JFrame("Hostel Management");
		l = new JLabel("Fee Structure");
		l.setFont(new Font("Serif", Font.PLAIN, 34));
		l.setBounds(550	, 50, 500, 100);
				
				
	    l1 = new JLabel(new ImageIcon("C:\\Users\\Lenovo\\eclipse\\Hostel\\src\\ss.png"));
	    
      
        Dimension size = l1.getPreferredSize();
        l1.setBounds(400, 150, size.width, size.height);
        
        b = new JButton("Download Broucher");
        b.setBounds(550, 400, 150, 30);
        b.addActionListener(this);
        
        b1 = new JButton("Back");
        b1.setBounds(550, 450, 150, 30);
        b1.addActionListener(this);
        
        
        f.add(l);
        f.add(l1);
        f.add(b);
        f.add(b1);

		f.setSize(1366, 768);
		f.setLayout(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		
		new Sixth();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		URI uri = null;
		try {
			uri = new URI("https://drive.google.com/file/d/1Dt3zTFxrlKvY2ZYKIrAJ0nwfddaDLB3Q/view?usp=sharing");
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		 if (e.getSource()==b) {
			 
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							desktop.browse(uri);
						} catch (Exception ex) {
						}
					} else {
					}
				}
			
		
		 else if(e.getSource()==b1)
		 {
			 f.setVisible(false);
			 new  Third();
		 }
	}

}
