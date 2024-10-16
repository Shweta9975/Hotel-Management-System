
package Hotel;
import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class PickUp extends JFrame implements ActionListener{
    JTable t1;
    Choice c1;
    JButton b1,b2;
    
	PickUp(){
		JLabel l1=new JLabel("Pick Service");
		l1.setFont(new Font("SEN_SERIF",Font.BOLD,20));
		l1.setBounds(400,30,200,30);
		add(l1);
		
		JLabel l2=new JLabel("Type of Car");
		l2.setFont(new Font("SEN_SERIF",Font.BOLD,17));
		l2.setBounds(50,100,120,30);
		add(l2);
		

        c1=new Choice();
        try {
        	Database1 db=new Database1();
        	ResultSet rs=db.stmt.executeQuery("select * from drivers");
        	while(rs.next()) {
        		c1.add(rs.getString("model"));
        	}
        }
		catch(Exception e) {
			
		}
        c1.setBounds(190,100,200,30);
        add(c1);

		
		t1=new JTable();
		t1.setBounds(0, 200, 1000, 300);
		add(t1);
		
		JLabel l3=new JLabel("Driver Name");
		l3.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l3.setBounds(10,170,100,30);
		add(l3);
		JLabel l4=new JLabel("Age");
		l4.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l4.setBounds(180,170,100,30);
		add(l4);
		JLabel l5=new JLabel("Gender");
		l5.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l5.setBounds(320,170,100,30);
		add(l5);
		JLabel l6=new JLabel("Company");
		l6.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l6.setBounds(450,170,100,30);
		add(l6);
		JLabel l7=new JLabel("Model");
		l7.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l7.setBounds(590,170,100,30);
		add(l7);
		JLabel l8=new JLabel("Available");
		l8.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l8.setBounds(740,170,100,30);
		add(l8);
		JLabel l9=new JLabel("Location");
		l9.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l9.setBounds(860,170,100,30);
		add(l9);
		b1=new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(300, 520, 120, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(500, 520, 120, 30);
		b2.addActionListener(this);
		add(b2);
    	setLayout(null);
    	setBounds(500,200,1000,650);
    	setVisible(true);
     }
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		try {
			String str="select* from drivers where model = '"+c1.getSelectedItem()+"'";
           Database1 db=new Database1();
			ResultSet rs=db.stmt.executeQuery(str); 
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
		catch(Exception e) {
			System.out.println(e);
		}
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		} 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new PickUp().setVisible(true);
	}

}

