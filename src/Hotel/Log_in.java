package Hotel;
 
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Log_in extends JFrame implements ActionListener {
    
   //private static final int SCALE_DEFAULT = 0;
   JLabel l1,l2,l3;
   JTextField t1, t2;
   JButton b1,b2,b3;
	
  Log_in()
  {
      
	  //Login Panel
	  JPanel login=new JPanel();
	  login.setLayout(null);
	  login.setBounds(250,175,400,450);
	  login.setBackground(new Color(0,0,0,80));
	  
	  l1=new JLabel("Username");
	  l1.setBounds(50,50,300,30);
	  l1.setForeground(Color.WHITE);
	  l1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
	  login.add(l1);
       
	   t1=new JTextField();
       t1.setBackground(new Color(0,0,210,50));
       t1.setBounds(50,100,300,50);
      //username.setOpaque(false);
       t1.setForeground(Color.WHITE);
       login.add(t1);
       
      l2=new JLabel("Password");
 	  l2.setBounds(50,180,300,30);
 	  l2.setForeground(Color.WHITE);
 	  l2.setFont(new Font("SAN_SERIF",Font.BOLD,20));
 	  login.add(l2);
       
       t2=new JTextField();
       t2.setBackground(new Color(0,170,210,50));
      // password.setOpaque(false);
       t2.setForeground(Color.WHITE);
       t2.setBounds(50,220,300,50);
       login.add(t2);
	  
       //Login Button
      b1=new JButton("Login");
      b1.setBounds(50,300,150,40);
      b1.setBackground(new Color(50,100,205));
      b1.setForeground(Color.WHITE);
      b1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
      b1.setBorder(BorderFactory.createEmptyBorder());
      b1.addActionListener(this);
       login.add(b1);
      
       //Signup Button
      b2=new JButton("Signup");
      b2.setBounds(220,300,150,40);
      b2.setBackground(Color.WHITE);
      b2.setForeground(new Color(0,0,205));
      b2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
      b2.setBorder(new LineBorder(new Color(0,0,205)));
      b2.addActionListener(this);
      login.add(b2);
      
      b3=new JButton("Forgot Password ?");
      b3.setBounds(60,370,170,40);
      b3.setBackground(Color.WHITE);
      b3.setForeground(new Color(0,0,205));
      b3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
      b3.setBorder(new LineBorder(new Color(0,0,205)));
      b3.addActionListener(this);
      login.add(b3);
      

       //background image
	  ImageIcon img=new ImageIcon(getClass().getResource("/icons/hotel3.jpg"));
	  Image img1=img.getImage();
	  Image temp_img=img1.getScaledInstance(900,800,Image.SCALE_SMOOTH);//for resize image
	  img=new ImageIcon(temp_img);
	  JLabel l3=new JLabel("",img,JLabel.CENTER);
	  l3.add(login);
	  l3.setBounds(0,0,900,800);
	  add(l3);
	  
	 //frame
	setBounds(400,100,900,800);
	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
 
  
  public void actionPerformed(ActionEvent ae) {
	  if(ae.getSource()==b1) {
		String username=t1.getText();
		String password=t2.getText();
		 
		 //Database Connection
		 Database1 db=new Database1();
		 
		 String str="Select * from account where username= '"+username+"' and password ='"+password+"'";
		 try {
		 ResultSet rs=db.stmt.executeQuery(str);
		 
		 if(rs.next()) {
			 new DashBoard().setVisible(true);
			 this.setVisible(false);
		 }else
		 {
			 JOptionPane.showMessageDialog(null, "Invalid username and password");
			 this.setVisible(false);
		 }
		 
		 }catch(Exception e) {}
		 
   }
	  else if(ae.getSource()==b2) {
		new SignUp().setVisible(true);
		this.setVisible(false);
	  }
	  else if(ae.getSource()==b3) {
		  this.setVisible(false);
		  new ForgetPassword().setVisible(true);
	  }
  }
   
  public static void main(String[]args)
  {
	new Log_in();
}

}
