package Hotel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.awt.event.*;      
public class AddEmployee extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1;
     AddEmployee(){
    	
    	 JLabel name=new JLabel("Name");
    	name.setBounds(60,30,120,30);
    	name.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
    	add(name);
    	t1=new JTextField();
    	t1.setBounds(200,30,170,30);
    	add(t1);
    	
    	JLabel age=new JLabel("Age");
    	age.setBounds(60,80,120,30);
    	age.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
    	add(age);
    	
    	t2=new JTextField();
    	t2.setBounds(200,80,170,30);
    	add(t2);
    	
    	JLabel gender=new JLabel("Gender");
    	gender.setBounds(60,130,120,30);
    	gender.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
    	add(gender);
    	
        r1=new JRadioButton("Male");
        r1.setBounds(200,130,70,30);
        r1.setBackground(Color.white);
        r1.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
        
        
        r2=new JRadioButton("Female");
        r2.setBounds(267,130,130,30);
        r2.setBackground(Color.white);
        r2.setFont(new Font("SAN_SERIF",Font.PLAIN,19));
       
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        add(r1);
        add(r2);
        
        JLabel job=new JLabel("Job");
    	job.setBounds(60,180,120,30);
    	job.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    	add(job);
    	
    	String str[]= {"Front Desk Clerks","Porters","HouseKepping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
    	c1=new JComboBox(str);
    	c1.setBackground(Color.white);
    	c1.setBounds(200,180,170,30);
    	add(c1);
    	
    	JLabel salary=new JLabel("Salary");
    	salary.setBounds(60,230,120,30);
    	salary.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    	add(salary);
    	
    	t3=new JTextField();
    	t3.setBounds(200,230,170,30);
    	add(t3);
    	
    	JLabel phone=new JLabel("Phone");
    	phone.setBounds(60,280,120,30);
    	phone.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    	add(phone);
    	t4=new JTextField();
    	t4.setBounds(200,280,170,30);
    	add(t4);
    	
    	JLabel adhar=new JLabel("Adhar");
    	adhar.setBounds(60,330,120,30);
    	adhar.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    	add(adhar);
    	
    	t5=new JTextField();
    	t5.setBounds(200,330,170,30);
    	add(t5);
    	
    	JLabel email=new JLabel("Email");
    	email.setBounds(60,380,120,30);
    	email.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    	add(email);
    	t6=new JTextField();
    	t6.setBounds(200,380,170,30);
    	add(t6);
    	
    	b1=new JButton("SUBMIT");
    	b1.setBackground(Color.black);
    	b1.setForeground(Color.white);
    	b1.setBounds(200,430,170,40);
    	b1.addActionListener(this);
    	add(b1);
    	
    	ImageIcon img=new ImageIcon(getClass().getResource("/icons/Job1.jpeg"));
    	Image img1=img.getImage();
    	Image temp_img=img1.getScaledInstance(600,600,Image.SCALE_SMOOTH);
    	img=new ImageIcon(temp_img);
    	JLabel l=new JLabel(img);
		l.setBounds(400,30,600,600);
		add(l);
		
		JLabel l1=new JLabel("ADD EMPLOYEE DETAILS");
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Times New Roman",Font.BOLD,23));
		l1.setBounds(50,5,400,40);
		l.add(l1);
		
		getContentPane().setBackground(Color.white);
    	setLayout(null);
    	setBounds(500,200,1000,600);
    	setVisible(true);
     }
     public void actionPerformed(ActionEvent ae) {
    	 String name=t1.getText();
    	 String age=t2.getText();
    	 String salary=t3.getText();
    	 String phone=t4.getText();
    	 String adhar=t5.getText();
    	 String email=t6.getText();
    	 
    	 //radio button
    	 String gender=null;
    	 if(r1.isSelected()) {
    		 gender="Male";
    	 }
    	 else if(r2.isSelected()) {
    		 gender="Female";
    	 }
    	 
    	 //JComboBox
    	 String job=(String) c1.getSelectedItem();
    	 
    	 //Database Connection
    	 Database1 db=new Database1();
    	 String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+adhar+"','"+email+"')";
    	 try {
    		db.stmt.executeUpdate(str); 
    		JOptionPane.showMessageDialog(null,"New Employee Added");
    		this.setVisible(false);
       
    	 }catch(Exception e) {
    		System.out.println(e); 
    	 }
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new AddEmployee();
	}

}
