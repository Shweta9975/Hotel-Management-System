

package Hotel;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
      JTable t1;
      JButton b1,b2;
      CustomerInfo(){
    	t1=new JTable();
    	t1.setBounds(0,40,1000,500);
    	add(t1);
    	JLabel l1=new JLabel("Document Type");
    	l1.setBounds(10,10,100,20);
    	add(l1);
    	
    	JLabel l2=new JLabel("Number");
    	l2.setBounds(170,10,70,20);
    	add(l2);
    	
    	JLabel l3=new JLabel("Name");
    	l3.setBounds(290,10,70,20);
    	add(l3);
    	JLabel l4=new JLabel("Gender");
    	l4.setBounds(410,10,70,20);
    	add(l4);
    	
    	JLabel l5=new JLabel("Country");
    	l5.setBounds(530,10,70,20);
    	add(l5);
    	
    	JLabel l6=new JLabel("Room Number");
    	l6.setBounds(640,10,100,20);
    	add(l6);
    	
    	JLabel l7=new JLabel("Status");
    	l7.setBounds(780,10,70,20);
    	add(l7);
    	
    	JLabel l8=new JLabel("Deposit");
    	l8.setBounds(890,10,70,20);
    	add(l8);
    	
    	b1=new JButton("Load data");
    	b1.setBounds(350,550,120,30);
    	b1.setBackground(Color.black);
    	b1.setForeground(Color.white);
    	b1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
    	b1.setBorder(new LineBorder(Color.black));
    	b1.addActionListener(this);
    	add(b1);
    	
    	b2=new JButton("Back");
    	b2.setBounds(520,550,120,30);
    	b2.setBackground(Color.black);
    	b2.setForeground(Color.white);
    	b2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
    	b2.setBorder(new LineBorder(Color.black));
    	b2.addActionListener(this);
    	add(b2);
    	
    	getContentPane().setBackground(Color.white);
    	setLayout(null);
    	setBounds(500,200,1020,650);
    	setVisible(true);
      }
      
      public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==b1) {
    	   try {
    		  Database1 db=new Database1();
    		  String str="Select * from customer";
    		  ResultSet rs=db.stmt.executeQuery(str);
    		  
    		  t1.setModel(DbUtils.resultSetToTableModel(rs));
    	   }catch(Exception e) {
    		   
    	   }
    	}else if(ae.getSource()==b2) {
    		this.setVisible(false);
    		new Reception().setVisible(true);
    	}  
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new CustomerInfo();
	}

}


