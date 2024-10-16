package Hotel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class ForgetPassword extends JFrame implements ActionListener {
     JTextField t1,t2,t3,t4;
     JTextField t5;
     JButton b1,b2,b3;
	ForgetPassword(){
	
		setBounds(500,200,900,600);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(160,90,550,300);
		p.setBackground(new Color(0,0,0,30));
		add(p);
		
		JLabel l1=new JLabel("Username");
		l1.setBounds(40,20,100,30);
		l1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		p.add(l1);
		
		t1=new JTextField();
		t1.setBounds(230,20,170,30);
		p.add(t1);
		
		b1=new JButton("Search");
		b1.setBackground(Color.red);
		b1.setForeground(Color.white);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.setBounds(410,20,100,30);
		b1.addActionListener(this);
		p.add(b1);
		
		JLabel l2=new JLabel("Name");
		l2.setBounds(40,60,100,30);
		l2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		p.add(l2);
		
		t2=new JTextField();
		t2.setBounds(230,60,170,30);
		p.add(t2);
		
		JLabel l3=new JLabel("Your Security Question");
		l3.setBounds(40,100,170,30);
		l3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		p.add(l3);
		
		t3=new JTextField();
		t3.setBounds(230,100,250,30);
		p.add(t3);
		
		JLabel l4=new JLabel("Answer");
		l4.setBounds(40,140,100,30);
		l4.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		p.add(l4);
		
		t4=new JTextField();
		t4.setBounds(230,140,170,30);
		p.add(t4);
		
		b2=new JButton("Retrieve");
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);
		b2.setBorder(BorderFactory.createEmptyBorder());
		b2.setBounds(410,140,100,30);
		b2.addActionListener(this);
		p.add(b2);
		
		JLabel l5=new JLabel("Password");
		l5.setBounds(40,180,100,30);
		l5.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		p.add(l5);
		
		t5=new JTextField();
		t5.setBounds(230,180,170,30);
		p.add(t5);
		
		b3=new JButton("Back");
		b3.setBackground(Color.RED);
		b3.setForeground(Color.white);
		b3.setBorder(BorderFactory.createEmptyBorder());
		b3.setBounds(180,230,100,40);
		b3.addActionListener(this);
		p.add(b3);
		
		ImageIcon img=new ImageIcon(getClass().getResource("/icons/password1.png"));
		  Image img1=img.getImage();
		  Image temp_img=img1.getScaledInstance(900,800,Image.SCALE_SMOOTH);//for resize image
		  img=new ImageIcon(temp_img);
		  JLabel l6=new JLabel("",img,JLabel.CENTER);
		  l6.add(p);
		  l6.setBounds(0,0,900,600);
		  add(l6);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Database1 db=new Database1();
		if(ae.getSource()==b1) {
			//resultset because it returns complete row
			try {
			String sql="select * from account where Username = '"+t1.getText()+"'";
			ResultSet rs=db.stmt.executeQuery(sql);
			//For column to column jump
			while(rs.next()) {
				t2.setText(rs.getString("Name"));
				t3.setText(rs.getString("Security"));
			}
			}catch(Exception e) {
				
			}
		}else if(ae.getSource()==b2) {
			try {
				String str="select * from account where Answer = '"+t4.getText()+"' AND Username '"+t1.getText()+"'";
				ResultSet rs=db.stmt.executeQuery(str);
				
				while(rs.next()) {
					t5.setText(rs.getString("Password"));
              }
				}catch(Exception e) {
					
				}
		}
		else if(ae.getSource()==b3) {
			this.setVisible(false);
			new Log_in().setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new ForgetPassword().setVisible(true);
	}

}
