package Hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddDriver extends JFrame implements ActionListener {
     JTextField t1,t2,t3,t4,t5;
     JRadioButton r1,r2;
     JComboBox c1;
     JButton b1,b2;
	AddDriver(){
		
	   
	   JLabel title=new JLabel("ADD DRIVER");
	   title.setBounds(100,20,200,40);
	   title.setForeground(Color.black);
	   title.setFont(new Font("SAN_SERIF",Font.BOLD,20));
	   add(title);
	
	   JLabel name=new JLabel("Name");
	   name.setBounds(40,70,120,30);
	   name.setForeground(Color.black);
	   name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
	   add(name);
	   
	   t1=new JTextField();
	   t1.setBounds(180,70,170,30);
	   add(t1);
	   
	   JLabel age=new JLabel("Age");
	   age.setBounds(40,120,120,30);
	   age.setForeground(Color.black);
	   age.setFont(new Font("SAN_SERIF",Font.BOLD,18));
	   add(age);
	   
	   t2=new JTextField();
	   t2.setBounds(180,120,170,30);
	   add(t2);
		
	   JLabel gender=new JLabel("Gender");
	   gender.setBounds(40,170,120,30);
	   gender.setForeground(Color.black);
	   gender.setFont(new Font("SAN_SERIF",Font.BOLD,18));
	   add(gender);
	   
	   r1=new JRadioButton("Male");
       r1.setBounds(180,170,70,30);
       r1.setBackground(Color.white);
       r1.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
       
       
       r2=new JRadioButton("Female");
       r2.setBounds(250,170,100,30);
       r2.setBackground(Color.white);
       r2.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
      
       ButtonGroup bg=new ButtonGroup();
       bg.add(r1);
       bg.add(r2);
       add(r1);
       add(r2);
	   
	   JLabel car=new JLabel("Car Company");
	   car.setBounds(40,220,120,30);
	   car.setForeground(Color.black);
	   car.setFont(new Font("SAN_SERIF",Font.BOLD,18));
	   add(car);
	   
	   t3=new JTextField();
	   t3.setBounds(180,220,170,30);
	   add(t3);
	   
	   JLabel model=new JLabel("Car Model");
	   model.setBounds(40,270,120,30);
	   model.setForeground(Color.black);
	   model.setFont(new Font("SAN_SERIF",Font.BOLD,18));
	   add(model);
	   
	   t4=new JTextField();
	   t4.setBounds(180,270,170,30);
	   add(t4);
	   
	   JLabel available=new JLabel("Available");
	   available.setBounds(40,320,120,30);
	   available.setForeground(Color.black);
	   available.setFont(new Font("SAN_SERIF",Font.BOLD,18));
	   add(available);
	   
	   String str[]= {"Available","Busy"};
      c1=new JComboBox(str);
   	  c1.setBackground(Color.white);
   	  c1.setBounds(180,320,170,30);
   	  add(c1);
	   
	   JLabel location=new JLabel("Location");
	   location.setBounds(40,370,120,30);
	   location.setForeground(Color.black);
	   location.setFont(new Font("SAN_SERIF",Font.BOLD,18));
	   add(location);
	   
	   t5=new JTextField();
	   t5.setBounds(180,370,170,30);
	   add(t5);
	   
	   b1=new JButton("ADD DRIVER");
   	   b1.setBackground(Color.black);
   	   b1.setForeground(Color.white);
   	   b1.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
   	   b1.setBounds(40,430,170,40);
   	   b1.addActionListener(this);
   	   add(b1);
   	   
   	   b2=new JButton("CANCEL");
	   b2.setBackground(Color.black);
	   b2.setForeground(Color.white);
	   b2.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
	   b2.setBounds(230,430,170,40);
	   b2.addActionListener(this);
	   add(b2);
	   
	   ImageIcon img=new ImageIcon(getClass().getResource("/icons/Driver.jpeg"));
   	   Image img1=img.getImage();
   	   Image temp_img=img1.getScaledInstance(600,600,Image.SCALE_SMOOTH);
   	   img=new ImageIcon(temp_img);
   	   JLabel l=new JLabel(img);
	   l.setBounds(400,30,600,600);
	   add(l);

	 getContentPane().setBackground(Color.white);
 	setLayout(null);
 	setBounds(500,200,1000,600);
 	setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String name=t1.getText();
			String age=t2.getText();
			 //radio button
	    	 String gender=null;
	    	 if(r1.isSelected()) {
	    		 gender="Male";
	    	 }
	    	 else if(r2.isSelected()) {
	    		 gender="Female";
	    	 }
	    	 String car=t3.getText();
			String model=t4.getText();
			
			 //JComboBox
	    	 String available=(String) c1.getSelectedItem();
	    	 String location=t5.getText();
	    	 
	    	 Database1 db=new Database1();
	    	 String str="insert into drivers values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
    	 try {
	    		db.stmt.executeUpdate(str); 
	    		JOptionPane.showMessageDialog(null,"New Driver Added");
	    		this.setVisible(false);
	       
	    	 }catch(Exception e) {
	    		System.out.println(e); 
	    	 }
		}else if(ae.getSource()==b2) {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new AddDriver();
	}

}
