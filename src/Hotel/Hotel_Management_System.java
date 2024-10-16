package Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hotel_Management_System extends JFrame implements ActionListener {
	
	Hotel_Management_System(){
		setBounds(300,100,1500,800);
		getContentPane().setBackground(Color.BLACK);
		
		//setLocation(300,300);
		
		ImageIcon i1=new ImageIcon(getClass().getResource("/icons/hotel2.jpeg"));
		JLabel l1=new JLabel("",i1,JLabel.CENTER);
		l1.setBounds(0,0,1400,600);
		
		add(l1);
		
		JLabel l2=new JLabel("Hotel Management System");
        l2.setBounds(60, 600, 1000, 90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Serif",Font.PLAIN,70));
		add(l2);
		
		JButton b1=new JButton("NEXT");
		b1.setBackground(Color.RED);
		b1.setForeground(Color.BLACK);
		b1.setBounds(1150, 650, 150, 50);
		b1.addActionListener(this);
		add(b1);
		
		setLayout(null);
		setVisible(true);
		
		while(true) {
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				l2.setVisible(true);
			}
			l2.setVisible(true);
			try {
			Thread.sleep(500);
			}
			catch(Exception e)
			{}
		}
	}
	
	//form Connection
   public void actionPerformed(ActionEvent ae) {
	   new Log_in().setVisible(true);
	   this.setVisible(false);
   }  


		public static void main(String[] args)
		{
		new Hotel_Management_System();

	}

}
