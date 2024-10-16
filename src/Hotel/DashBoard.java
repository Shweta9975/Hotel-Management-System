package Hotel;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class DashBoard extends JFrame implements ActionListener {
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
     DashBoard(){
    	mb=new JMenuBar();
    	add(mb);
    	
    	m1=new JMenu("HOTEL MANAGEMENT");
    	m1.setForeground(Color.red);
    	mb.add(m1);
    	m2=new JMenu("ADMIN");
    	m2.setForeground(Color.blue);
    	mb.add(m2);
    	
    	i1=new JMenuItem("RECEPTION");
    	i1.addActionListener(this);
    	m1.add(i1);
    	
    	i2=new JMenuItem("ADD EMPLOYEE");
    	i2.addActionListener(this);
    	m2.add(i2);
    	
    	i3=new JMenuItem("ADD ROOMS");
    	i3.addActionListener(this);
    	m2.add(i3);
    	
    	i4=new JMenuItem("ADD DRIVERS");
    	i4.addActionListener(this);
    	m2.add(i4);
    	
    	mb.setBounds(0,0,1930,30);
    	setLayout(null);
    	
    	ImageIcon img=new ImageIcon(getClass().getResource("/icons/DashBoard1.jpeg"));
    	Image img1=img.getImage();
    	Image temp_img=img1.getScaledInstance(1930,1080,Image.SCALE_SMOOTH);
    	  img=new ImageIcon(temp_img);
    	JLabel l1=new JLabel("",img,JLabel.CENTER);
		l1.setBounds(0,0,1930,1080);
		
		JLabel l2=new JLabel("Hotel Trivago Welcomes You ");
		l2.setForeground(Color.white);
		l2.setFont(new Font("Serif",Font.PLAIN,50));
		l2.setBounds(700,60,1000,70);
		l1.add(l2);
		
		add(l1);
    	setBounds(0,0,1930,1080);
    	setVisible(true);
     }
     
     public void actionPerformed(ActionEvent ae) {
    	 if(ae.getActionCommand().equals("RECEPTION")) {
    		 new Reception().setVisible(true);
    	 }else if(ae.getActionCommand().equals("ADD EMPLOYEE")) {
    		 new AddEmployee().setVisible(true);
    	 }
    	 else if(ae.getActionCommand().equals("ADD ROOMS")) {
    		 new AddRooms().setVisible(true);
    	 }
    	 else if(ae.getActionCommand().equals("ADD DRIVERS")) {
    		 new AddDriver().setVisible(true);
    	 }
    	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new DashBoard().setVisible(true);
	}

}
