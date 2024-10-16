package Hotel;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class CheckOut extends JFrame implements ActionListener {
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
	CheckOut(){
    	JLabel l1=new JLabel("Check Out");
    	l1.setBounds(70,20,100,30);
    	l1.setFont(new Font("SEN_SERIF",Font.BOLD,20));
    	add(l1);
    	
    	JLabel l2=new JLabel("Customer Id");
    	l2.setFont(new Font("SEN_SERIF",Font.BOLD,17));
    	l2.setBounds(30,80,100,30);
    	add(l2);
    	
    	c1=new Choice();
    	try {
    		Database1 db=new Database1();
    		ResultSet rs=db.stmt.executeQuery("select * from customer");
    		while(rs.next()) {
    			c1.add(rs.getString("number"));
    		}
    		rs.close();
    	}catch(Exception e) {
    		
    	}
    	c1.setBounds(200,80,150,30);
    	add(c1);
    	
    	JLabel l3=new JLabel("Room Number");
    	l3.setFont(new Font("SEN_SERIF",Font.BOLD,17));
    	l3.setBounds(30,140,140,30);
    	add(l3);
    	
    	t1=new JTextField();
    	t1.setBounds(200,140,150,30);
    	add(t1);
    	
    	b1=new JButton("Check Out");
    	b1.setBounds(30,230,150,40);
    	b1.setBackground(Color.black);
    	b1.setForeground(Color.white);
    	b1.addActionListener(this);
    	add(b1);
    	
    	b2=new JButton("Back");
    	b2.setBounds(210,230,150,40);
    	b2.setBackground(Color.black);
    	b2.setForeground(Color.white);
    	b2.addActionListener(this);
    	add(b2);
    	
        ImageIcon i1=new ImageIcon(getClass().getResource("/icons/checkit.jpeg"));
        Image i2=i1.getImage();
        Image i3=i2.getScaledInstance(20,20,Image.SCALE_SMOOTH);
    	i1=new ImageIcon(i3);
        b3=new JButton(i1);
        b3.setBounds(360,80,20,20);
        b3.addActionListener(this);
        add(b3);

        ImageIcon img=new ImageIcon(getClass().getResource("/icons/Cash.jpeg"));
    	Image img1=img.getImage();
    	Image temp_img=img1.getScaledInstance(390,290,Image.SCALE_SMOOTH);
    	img=new ImageIcon(temp_img);
    	JLabel l5=new JLabel(img);
		l5.setBounds(390,10,390,290);
		add(l5);
    	  
    	setLayout(null);
    	getContentPane().setBackground(Color.white);
    	setBounds(500,200,800,350);
    	setVisible(true);
      }
      public void actionPerformed(ActionEvent ae) {
	   if(ae.getSource()==b1) {
		  String id=c1.getSelectedItem();
		  String room=t1.getText();
		  String str="delete * from customer where number ='"+id+"'";
		  String str1="update room set available ='Available' where room ='"+room+"'";
		  Database1 db=new Database1();
		  try {
			  db.stmt.executeUpdate(str);
			  db.stmt.executeUpdate(str1);
              JOptionPane.showMessageDialog(null,"Checkout Done");
              new Reception().setVisible(true);
    		  this.setVisible(false);
			  }catch(Exception e) {
				  
			  }
	   }else if(ae.getSource()==b2) {
		  new Reception().setVisible(true);
		  this.setVisible(false);
	   } else if(ae.getSource()==b3) {
		  Database1 db=new Database1();
		  String id=c1.getSelectedItem();
		  try {
		  ResultSet rs=db.stmt.executeQuery("select * from customer where number ='"+id+"'");
		  while(rs.next()) {
			 t1.setText(rs.getString("room")); 
		  }
		  }catch(Exception e) {
			  
		  }
	   } 
      }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new CheckOut().setVisible(true);
	}

}
