package Hotel;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener {
  JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
  Reception(){
	  b1=new JButton("New Customer Form");
	   b1.setBackground(Color.black);
	   b1.setForeground(Color.white);
	   b1.setBorder(new LineBorder(Color.black));
	   b1.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b1.setBounds(20,30,200,30);
	   b1.addActionListener(this);
	   add(b1);
	   
	   b2=new JButton("Room");
	   b2.setBackground(Color.black);
	   b2.setForeground(Color.white);
	   b2.setBorder(new LineBorder(Color.black));
	   b2.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b2.setBounds(20,70,200,30);
	   b2.addActionListener(this);
	   add(b2);
	   
	   b3=new JButton("Department");
	   b3.setBackground(Color.black);
	   b3.setForeground(Color.white);
	   b3.setBorder(new LineBorder(Color.black));
	   b3.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b3.setBounds(20,110,200,30);
	   b3.addActionListener(this);
	   add(b3);
	   
	   b4=new JButton("All Employee Info");
	   b4.setBackground(Color.black);
	   b4.setForeground(Color.white);
	   b4.setBorder(new LineBorder(Color.black));
	   b4.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b4.setBounds(20,150,200,30);
	   b4.addActionListener(this);
	   add(b4);
	   
	   b5=new JButton("Customer Info");
	   b5.setBackground(Color.black);
	   b5.setForeground(Color.white);
	   b5.setBorder(new LineBorder(Color.black));
	   b5.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b5.setBounds(20,190,200,30);
	   b5.addActionListener(this);
	   add(b5);
	   
	   b6=new JButton("Manager Info");
	   b6.setBackground(Color.black);
	   b6.setForeground(Color.white);
	   b6.setBorder(new LineBorder(Color.black));
	   b6.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b6.setBounds(20,230,200,30);
	   b6.addActionListener(this);
	   add(b6);
	   
	   b7=new JButton("Check Out");
	   b7.setBackground(Color.black);
	   b7.setForeground(Color.white);
	   b7.setBorder(new LineBorder(Color.black));
	   b7.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b7.setBounds(20,270,200,30);
	   b7.addActionListener(this);
	   add(b7);
	   
	   b8=new JButton("Update Check Status");
	   b8.setBackground(Color.black);
	   b8.setForeground(Color.white);
	   b8.setBorder(new LineBorder(Color.black));
	   b8.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b8.setBounds(20,310,200,30);
	   b8.addActionListener(this);
	   add(b8);
	   
	   b9=new JButton("Update Room Status");
	   b9.setBackground(Color.black);
	   b9.setForeground(Color.white);
	   b9.setBorder(new LineBorder(Color.black));
	   b9.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b9.setBounds(20,350,200,30);
	   b9.addActionListener(this);
	   add(b9);
	  
	   b10=new JButton("Pick Up Service");
	   b10.setBackground(Color.black);
	   b10.setForeground(Color.white);
	   b10.setBorder(new LineBorder(Color.black));
	   b10.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b10.setBounds(20,390,200,30);
	   b10.addActionListener(this);
	   add(b10);
	   
	   b11=new JButton("Search Room");
	   b11.setBackground(Color.black);
	   b11.setForeground(Color.white);
	   b11.setBorder(new LineBorder(Color.black));
	   b11.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b11.setBounds(20,430,200,30);
	   b11.addActionListener(this);
	   add(b11);
	   
	   b12=new JButton("Log Out");
	   b12.setBackground(Color.black);
	   b12.setForeground(Color.white);
	   b12.setBorder(new LineBorder(Color.black));
	   b12.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	   b12.setBounds(20,470,200,30);
	   b12.addActionListener(this);
	   add(b12);
	  
	   ImageIcon img=new ImageIcon(getClass().getResource("/icons/reception.jpeg"));
   	   JLabel l=new JLabel(img);
	   l.setBounds(250,30,510,500);
    	add(l);
	   setLayout(null);
	   setBounds(500,200,800,600);
	   getContentPane().setBackground(Color.white);
	   setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ae) {
	  if(ae.getSource()==b1) {
		 new AddCustomer().setVisible(true);
		 this.setVisible(false);
	  }else if(ae.getSource()==b2) {
		  new Room().setVisible(true);
		  this.setVisible(false);
	  }else if(ae.getSource()==b3) {
		  new Department().setVisible(true);
		  this.setVisible(false);
	  }else if(ae.getSource()==b4) {
		 new EmployeeInfo().setVisible(true);
		 this.setVisible(false);
	  }else if(ae.getSource()==b5) {
		  new CustomerInfo().setVisible(true);
			this.setVisible(false);
	  }else if(ae.getSource()==b6) {
		new ManagerInfo().setVisible(true);
		this.setVisible(false);
	  }else if(ae.getSource()==b7) {
		 new CheckOut().setVisible(true); 
		 this.setVisible(false);
	  }else if(ae.getSource()==b8) {
		  new UpdateCheck().setVisible(true); 
			 this.setVisible(false); 
	  }else if(ae.getSource()==b9) {
		  new UpdateRoom().setVisible(true); 
			 this.setVisible(false); 
	  }else if(ae.getSource()==b10) {
		  new PickUp().setVisible(true); 
			 this.setVisible(false);  
	  }else if(ae.getSource()==b11) {
		  new SearchRoom().setVisible(true); 
			 this.setVisible(false);  
	  }else if(ae.getSource()==b12) {
		 setVisible(false); 
	  }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new Reception();
	}

}
