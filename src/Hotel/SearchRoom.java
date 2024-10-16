package Hotel;
import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class SearchRoom extends JFrame implements ActionListener{
    JTable t1;
    //Choice c1;
    JComboBox cb;
    JCheckBox cb1;
    JButton b1,b2;
    
	SearchRoom(){
		JLabel l1=new JLabel("Search For Room");
		l1.setFont(new Font("SEN_SERIF",Font.BOLD,20));
		l1.setBounds(400,30,200,30);
		add(l1);
		
		JLabel l2=new JLabel("Room Bed Type");
		l2.setFont(new Font("SEN_SERIF",Font.BOLD,17));
		l2.setBounds(50,100,150,30);
		add(l2);
		
		cb=new JComboBox(new String[] {"Single Bed","Double Bed"});
		cb.setBounds(200,100,150,30);
		cb.setBackground(Color.white);
		add(cb);
		
		cb1=new JCheckBox("Only display Available");
		cb1.setBounds(600,100,200,40);
		cb1.setBackground(Color.white);
		cb1.setFont(new Font("SEN_SERIF",Font.PLAIN,15));
		add(cb1);
		
		t1=new JTable();
		t1.setBounds(0, 200, 1000, 300);
		add(t1);
		
		JLabel l3=new JLabel("Room Number");
		l3.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l3.setBounds(50,170,150,30);
		add(l3);
		JLabel l4=new JLabel("Available");
		l4.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l4.setBounds(250,170,150,30);
		add(l4);
		JLabel l5=new JLabel("Cleaning Status");
		l5.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l5.setBounds(450,170,150,30);
		add(l5);
		JLabel l6=new JLabel("Room Price");
		l6.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l6.setBounds(650,170,150,30);
		add(l6);
		JLabel l7=new JLabel("Room Bed Type");
		l7.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l7.setBounds(850,170,150,30);
		add(l7);
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
			String str="select* from room where bed_type = '"+cb.getSelectedItem()+"'";
			String str1="select * from room where available = 'Available' AND bed_type ='"+cb.getSelectedItem()+"'";
			Database1 db=new Database1();
			ResultSet rs;
            if((cb1).isSelected()) {
				 rs=db.stmt.executeQuery(str1);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}else {
			    rs=db.stmt.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}
		}	catch(Exception e) {
			System.out.println(e);
		}
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		} 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new SearchRoom().setVisible(true);
	}

}
