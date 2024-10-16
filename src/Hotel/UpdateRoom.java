package Hotel;
import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class UpdateRoom extends JFrame implements ActionListener {
    Choice c;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	UpdateRoom(){
		JLabel l1=new JLabel("Update Room Status");
	    l1.setFont(new Font("SEN_SERIF",Font.BOLD,20));
	    l1.setForeground(Color.blue);
	    l1.setBounds(90,30,250,30);
	    add(l1);
		
		
		JLabel l2=new JLabel("Guest Id");
		l2.setFont(new Font("SEN_SERIF",Font.BOLD,18));
        l2.setBounds(30,120,200,30);
        add(l2);
        
        c=new Choice();
        try {
        	Database1 db=new Database1();
        	ResultSet rs=db.stmt.executeQuery("select * from customer");
        	while(rs.next()) {               //for getting column to column values
        		c.add(rs.getString("number"));
        	}
        	
        }catch(Exception e) {
        	
        }
        c.setBounds(230,120,150,30);
        add(c);
       
        JLabel l3=new JLabel("Room Number");
        l3.setFont(new Font("SEN_SERIF",Font.BOLD,18));
        l3.setBounds(30,170,250,30);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(230,170,150,30);
        add(t1);
        
        JLabel l5=new JLabel("Availability");
        l5.setFont(new Font("SEN_SERIF",Font.BOLD,18));
        l5.setBounds(30,220,250,30);
        add(l5);
        
        t2=new JTextField();
        t2.setBounds(230,220,150,30);
        add(t2);
        
        JLabel l6=new JLabel("Cleaning Status");
        l6.setFont(new Font("SEN_SERIF",Font.BOLD,18));
        l6.setBounds(30,270,250,30);
        add(l6);
    
        t3=new JTextField();
        t3.setBounds(230,270,150,30);
        add(t3);
        
        b1=new JButton("CHECK");
    	b1.setBackground(Color.black);
    	b1.setForeground(Color.white);
    	b1.setBounds(110,350,150,40);
    	b1.addActionListener(this);
    	add(b1);
    
    	b2=new JButton("UPDATE");
    	b2.setBackground(Color.black);
    	b2.setForeground(Color.white);
    	b2.setBounds(30,410,150,40);
    	b2.addActionListener(this);
    	add(b2);
    	
    	b3=new JButton("BACK");
    	b3.setBackground(Color.black);
    	b3.setForeground(Color.white);
    	b3.setBounds(220,410,150,40);
    	b3.addActionListener(this);
    	add(b3);

    	ImageIcon img=new ImageIcon(getClass().getResource("/icons/Room1.jpg"));
   	    Image img2=img.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
   	    ImageIcon img3=new ImageIcon(img2);
        JLabel l=new JLabel(img3);
   	    l.setBounds(400,0,600,500);
        add(l);
     	   
        getContentPane().setBackground(Color.white);
    	setLayout(null);
    	setBounds(500,200,1000,550);
    	setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==b1) {
    		String room=null;
    		String s1=c.getSelectedItem();
    		 Database1 db=new Database1();
    		try {
                  ResultSet rs=db.stmt.executeQuery("select * from customer where number = '"+s1+"'"); 
                  
                  while(rs.next()) {
                	  t1.setText(rs.getString("room"));
                	 room=rs.getString("room");
                  }
                  ResultSet rs1=db.stmt.executeQuery("select * from room where room_number = '"+room+"'"); 
                  while(rs1.next()) {
                	  t2.setText(rs1.getString("available"));
                	  t3.setText(rs1.getString("status"));
                   }
                }
    		catch(Exception e) {
    			System.out.println(e);
    		}
    		}else if(ae.getSource()==b2) {
                try {
                	Database1 db=new Database1();
                	String room=t1.getText();
                	String available=t2.getText();
                	String status=t3.getText();
                	
                	String str ="update room set available='"+available+"', status ='"+status+"'";
                	db.stmt.executeUpdate(str);
                	JOptionPane.showMessageDialog(null, "Room Updated Successfully");
                	new Reception().setVisible(true);
        			this.setVisible(false);
                	
                }catch(Exception e) {
                	
                }

    		} else if(ae.getSource()==b3) {
    			new Reception().setVisible(true);
    			this.setVisible(false);
    		} 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new UpdateRoom().setVisible(true);
	}

}
