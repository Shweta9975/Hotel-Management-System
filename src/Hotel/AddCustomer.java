package Hotel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;
import java.sql.ResultSet;
public class AddCustomer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;   
	JButton b1,b2;
	JRadioButton r1,r2;
	JComboBox c1;
	Choice c;
	AddCustomer(){
    	
    	JLabel l1=new JLabel("NEW CUSTOMER FORM");
   		l1.setBounds(100,20,300,60);
   		l1.setForeground(Color.black);
   		l1.setFont(new Font("SAN_SERIF",Font.BOLD,17));
   		add(l1);
   		
   		JLabel id=new JLabel(" Id");
   		id.setBounds(20,80,100,30);
   		id.setForeground(Color.black);
   		id.setFont(new Font("SAN_SERIF",Font.BOLD,17));
   		add(id);
   		
   		c1=new JComboBox(new String[] {"Passport","Voter-id Card","Driving Liscense","Aadhar Card"});
   		c1.setBounds(250,80,170,30);
   		c1.setBackground(Color.white);
   		add(c1);
    	JLabel number=new JLabel("Number");
   		number.setBounds(20,120,100,30);
   		number.setForeground(Color.black);
   		number.setFont(new Font("SAN_SERIF",Font.BOLD,17));
   		add(number);
   		t1=new JTextField();
    	t1.setBounds(250,120,170,30);
    	add(t1);
   		
   		JLabel name=new JLabel("Name");
   		name.setBounds(20,160,100,30);
   		name.setForeground(Color.black);
   		name.setFont(new Font("SAN_SERIF",Font.BOLD,17));
   		add(name);
   		t2=new JTextField();
    	t2.setBounds(250,160,170,30);
    	add(t2);
   		
   		JLabel gender=new JLabel("Gender");
   		gender.setBounds(20,200,100,30);
   		gender.setForeground(Color.black);
   		gender.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
   		add(gender);
   		r1=new JRadioButton("Male");
        r1.setBounds(250,200,70,30);
        r1.setBackground(Color.white);
        r1.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        
        
        r2=new JRadioButton("Female");
        r2.setBounds(320,200,100,30);
        r2.setBackground(Color.white);
        r2.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
       
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        add(r1);
        add(r2);
   		JLabel country=new JLabel("Country");
   		country.setBounds(20,240,100,30);
   		country.setForeground(Color.black);
   		country.setFont(new Font("SAN_SERIF",Font.BOLD,17));
   		add(country);
   		t3=new JTextField();
    	t3.setBounds(250,240,170,30);
    	add(t3);
   		JLabel room=new JLabel("Allocated Room Number");
   		room.setBounds(20,280,200,30);
   		room.setForeground(Color.black);
   		room.setFont(new Font("SAN_SERIF",Font.BOLD,17));
   		add(room);
   		
   		c=new Choice();
   		 //Database Conn
   		try {
   		Database1 db=new Database1();
   		String str="select * from room ";
   		ResultSet rs=db.stmt.executeQuery(str);
   		while(rs.next()) {
   			c.add(rs.getString("room_number"));
   		}
   		}catch(Exception e) {
   			
   		}
   		c.setBounds(250,280,170,30);
   		add(c);
   		JLabel status=new JLabel("Checked In");
   		status.setBounds(20,320,180,30);
   		status.setForeground(Color.black);
   		status.setFont(new Font("SAN_SERIF",Font.BOLD,17));
   		add(status);
   		t4=new JTextField();
    	t4.setBounds(250,320,170,30);
    	add(t4);
   		JLabel deposit=new JLabel("Deposit");
   		deposit.setBounds(20,360,180,30);
   		deposit.setForeground(Color.black);
   		deposit.setFont(new Font("SAN_SERIF",Font.BOLD,17));
   		add(deposit);
   		
   		t5=new JTextField();
    	t5.setBounds(250,360,170,30);
    	add(t5);
    	
    	b1=new JButton("ADD Customer");
    	b1.setBackground(Color.black);
    	b1.setForeground(Color.white);
    	b1.setBorder(new LineBorder(Color.black));
    	b1.setBounds(35,410,150,40);
    	b1.addActionListener(this);
    	add(b1);
    	
    	b2=new JButton("Back");
    	b2.setBackground(Color.black);
    	b2.setForeground(Color.white);
    	b2.setBorder(new LineBorder(Color.black));
    	b2.setBounds(220,410,150,40);
    	b2.addActionListener(this);
    	add(b2);
    	
    	ImageIcon img=new ImageIcon(getClass().getResource("/icons/Customer.jpg"));
    	Image img1=img.getImage();
    	Image temp_img=img1.getScaledInstance(450,400,Image.SCALE_SMOOTH);
    	img=new ImageIcon(temp_img);
    	JLabel l=new JLabel(img);
		l.setBounds(440,20,450,400);
		add(l);
   		setBounds(500,200,900,500);
   		getContentPane().setBackground(Color.white);
   		setLayout(null);
   		setVisible(true);
       }
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {		
		String id=(String) c1.getSelectedItem();
		String number=t1.getText();
		String name=t2.getText();
		String gender=null;
		if(r1.isSelected()) {
			gender="Male";
		}else if(r2.isSelected()) {
			gender="Female";
		}
		String country=t3.getText();
		String room=(String)c.getSelectedItem();
		String status=t4.getText();
		String deposit=t5.getText();
		 Database1 db=new Database1();
		String str="insert into customer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
		String str2="update room set available ='Occcupied' where room='"+room+"'";
		try {
	    		db.stmt.executeUpdate(str); 
	    		db.stmt.executeUpdate(str2);
	    		JOptionPane.showMessageDialog(null,"New Customer Added");
	    		this.setVisible(false);
	       
	    	 }catch(Exception e) {
	    		System.out.println(e); 
	    	 }
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new AddCustomer().setVisible(true);
	}

}
