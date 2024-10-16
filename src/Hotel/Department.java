package Hotel;
import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.*;
public class Department extends JFrame implements ActionListener{
    JTable t1;
    
    JButton b1,b2;
    
	Department(){
		/*JLabel l1=new JLabel("Department");
		l1.setFont(new Font("SEN_SERIF",Font.BOLD,20));
		l1.setBounds(400,30,200,30);
		add(l1);*/
		
        t1=new JTable();
		t1.setBounds(0, 50, 700, 350);
		add(t1);
		
		JLabel l3=new JLabel("Department");
		l3.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l3.setBounds(140,10,100,30);
		add(l3);
		JLabel l4=new JLabel("Budget");
		l4.setFont(new Font("SEN_SERIF",Font.BOLD,15));
		l4.setBounds(450,10,100,30);
		add(l4);


		b1=new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(200, 400, 120, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(400, 400, 120, 30);
		b2.addActionListener(this);
		add(b2);
    	setLayout(null);
    	setBounds(500,200,750,550);
    	setVisible(true);
     }
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		try {
			String str="select* from department";
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
      new Department().setVisible(true);
	}

}

