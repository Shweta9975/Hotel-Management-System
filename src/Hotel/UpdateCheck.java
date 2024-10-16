package Hotel;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class UpdateCheck extends JFrame implements ActionListener {
     JButton b1,b2,b3;
     Choice c1;
     JTextField t1,t2,t3,t4,t5;
	UpdateCheck(){
    	JLabel l1=new JLabel("Check in Details");
    	l1.setBounds(80,30,200,30);
    	l1.setFont(new Font("SEN_SERIF",Font.BOLD,20));
    	l1.setForeground(Color.blue);
    	add(l1);
    	
    	JLabel l2=new JLabel("Customer-ID");
    	l2.setBounds(30,90,130,30);
    	l2.setFont(new Font("SEN_SERIF",Font.BOLD,18));
    	l2.setForeground(Color.black);
    	add(l2);
    	
    	c1=new Choice();
    	try {
    		Database1 db=new Database1();
    		ResultSet rs=db.stmt.executeQuery("Select * from customer");
    		while(rs.next()) {
    			c1.add(rs.getString("number"));
    		}
    	}catch(Exception e) {
    		
    	}
    	c1.setBounds(210,90,200,30);
    	add(c1);
    	
    	JLabel l3=new JLabel("Room Number");
    	l3.setBounds(30,140,130,30);
    	l3.setFont(new Font("SEN_SERIF",Font.BOLD,18));
    	l3.setForeground(Color.black);
    	add(l3);
    	
    	t1=new JTextField();
        t1.setBounds(210,140,200,30);
       // t1.setBorder(BorderFactory.createEmptyBorder());
        add(t1);
    	
    	JLabel l4=new JLabel("Name");
    	l4.setBounds(30,190,100,30);
    	l4.setFont(new Font("SEN_SERIF",Font.BOLD,18));
    	l4.setForeground(Color.black);
    	add(l4);
    	
    	t2=new JTextField();
        t2.setBounds(210,190,200,30);
       // t1.setBorder(BorderFactory.createEmptyBorder());
        add(t2);
    	
        JLabel l5=new JLabel("Check In");
    	l5.setBounds(30,240,130,30);
    	l5.setFont(new Font("SEN_SERIF",Font.BOLD,18));
    	l5.setForeground(Color.black);
    	add(l5);
    	
    	t3=new JTextField();
        t3.setBounds(210,240,200,30);
       // t1.setBorder(BorderFactory.createEmptyBorder());
        add(t3);
    	
    	JLabel l6=new JLabel("Amount Paid");
    	l6.setBounds(30,290,130,30);
    	l6.setFont(new Font("SEN_SERIF",Font.BOLD,18));
    	l6.setForeground(Color.black);
    	add(l6);
    	
    	t4=new JTextField();
        t4.setBounds(210,290,200,30);
       // t1.setBorder(BorderFactory.createEmptyBorder());
        add(t4);
    	
        JLabel l7=new JLabel("Pending Amount");
    	l7.setBounds(30,340,150,30);
    	l7.setFont(new Font("SEN_SERIF",Font.BOLD,18));
    	l7.setForeground(Color.black);
    	add(l7);
    	
    	t5=new JTextField();
        t5.setBounds(210,340,200,30);
       // t1.setBorder(BorderFactory.createEmptyBorder());
        add(t5);
    	
        b1=new JButton("Search Room");
 	   b1.setBackground(Color.black);
 	   b1.setForeground(Color.white);
 	   b1.setBorder(new LineBorder(Color.black));
 	  // b1.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
 	   b1.setBounds(30,390,100,30);
 	   b1.addActionListener(this);
 	   add(b1);
 	   
 	  b2=new JButton("Check");
	   b2.setBackground(Color.black);
	   b2.setForeground(Color.white);
	   b2.setBorder(new LineBorder(Color.black));
	 // b2.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b2.setBounds(170,390,100,30);
	   b2.addActionListener(this);
	   add(b2);
	   
	   b3=new JButton("Back");
 	   b3.setBackground(Color.black);
 	   b3.setForeground(Color.white);
 	   b3.setBorder(new LineBorder(Color.black));
 	  // b1.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
 	   b3.setBounds(310,390,100,30);
 	   b3.addActionListener(this);
 	   add(b3);
 	   
 	  ImageIcon img=new ImageIcon(getClass().getResource("/icons/Check.jpeg"));
 	 Image img2=img.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
 	 ImageIcon img3=new ImageIcon(img2);
  	   JLabel l=new JLabel(img3);
 	   l.setBounds(450,20,500,400);
   	   add(l);
    	setBounds(500,200,1050,550);
    	getContentPane().setBackground(Color.white);
    	setLayout(null);
    	setVisible(true);
     }
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String room=null;
				int amountPaid;
				String deposit=null;
				String price=null;
				Database1 db=new Database1();
				String id=c1.getSelectedItem();
				String str="select * from customer where number ='"+id+"'";
				ResultSet rs=db.stmt.executeQuery(str);
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("status"));
					t4.setText(rs.getString("deposit"));
					room=rs.getString("room");
					deposit=rs.getString("deposit");
				}
				ResultSet rs1=db.stmt.executeQuery("select * from room where room_number = '"+room+"'");
				while(rs1.next()) {
					price=rs1.getString("price");
					amountPaid=(Integer.parseInt(price))-(Integer.parseInt(deposit));
					t5.setText(Integer.toString(amountPaid));
				}
			}catch(Exception e) {
				
				
			}
		}else if(ae.getSource()==b2) {
			
		}else if(ae.getSource()==b3) {
		  new Reception().setVisible(true);	
		  this.setVisible(false);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new UpdateCheck();
	}

}
