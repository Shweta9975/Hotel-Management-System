package Hotel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SignUp extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4;
   JButton b1,b2;
	Choice c1;
	//Constructor
	SignUp(){
		
        
        //For Division of JFrame
        JPanel p1=new JPanel();
        p1.setBounds(200,150,450,450);
        p1.setBackground(new Color(0,0,0,60));
        p1.setLayout(null);
        
        //UserName
        l1=new JLabel("Username");
        l1.setBounds(50,30,150,25);
        l1.setFont(new Font("TAHOMA",Font.BOLD,15));
        l1.setForeground(Color.BLACK);
        p1.add(l1);
        
        t1=new JTextField();
        t1.setBounds(210,30,200,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);
        
        //Name
         l2=new JLabel("Name");
        l2.setBounds(50,70,150,25);
        l2.setFont(new Font("TAHOMA",Font.BOLD,15));
        l2.setForeground(Color.BLACK);
        p1.add(l2);
        
        t2=new JTextField();
        t2.setBounds(210,70,200,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);
        
        //Password
         l3=new JLabel("Password");
        l3.setBounds(50,110,150,25);
        l3.setFont(new Font("TAHOMA",Font.BOLD,15));
        l3.setForeground(Color.BLACK);
        p1.add(l3);
        
        t3=new JTextField();
        t3.setBounds(210,110,200,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);
        
        //Security Question
         l4=new JLabel("Security Question");
        l4.setBounds(50,150,150,25);
        l4.setFont(new Font("TAHOMA",Font.BOLD,15));
        l4.setForeground(Color.BLACK);
        p1.add(l4);
        
        c1=new Choice();
        c1.add("What is your favourite color?");
        c1.add("What is your lucky number?");
        c1.add("Your childhood superhero?");
        c1.add("what is your favourite fruit?");
        c1.setBounds(210,150,200,25);
        p1.add(c1);
        
        l5=new JLabel("Answer");
        l5.setBounds(50,190,150,25);
        l5.setFont(new Font("TAHOMA",Font.BOLD,15));
        l5.setForeground(Color.BLACK);
        p1.add(l5);
        
        t4=new JTextField();
        t4.setBounds(210,190,200,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);
        
        //Create Button
        b1=new JButton("Create");
        b1.setBounds(50,300,150,40);
        b1.setBackground(new Color(0,100,200));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
         p1.add(b1);

         b2=new JButton("Back");
         b2.setBounds(250,300,150,40);
         b2.setBackground(Color.WHITE);
         b2.setForeground(new Color(0,100,200));
         b2.setFont(new Font("SAN_SERIF",Font.BOLD,17));
         b2.setBorder(BorderFactory.createEmptyBorder());
         b2.addActionListener(this);
          p1.add(b2);
          setVisible(true);
          
          ImageIcon img=new ImageIcon(getClass().getResource("/icons/signUp1.jpeg"));
      	  Image img1=img.getImage();
      	  Image temp_img=img1.getScaledInstance(950,800,Image.SCALE_SMOOTH);
      	  img=new ImageIcon(temp_img);
      	  l6=new JLabel("",img,JLabel.CENTER);
      	  l6.add(p1);
      	  l6.setBounds(0,0,950,800);
      	  add(l6);
      	  
      	  
      	setBounds(400,100,950,800);
      //  setBackground(Color.WHITE);
          setLayout(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String username=t1.getText(); //'',""//'Admin'
			String name=t2.getText();
		    String password=t3.getText();
			String security=c1.getSelectedItem();
		    String answer=t4.getText();
		    
		    String query="insert into account values('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"')";
		    try {
		    	Database1 db=new Database1();
		    	db.stmt.executeUpdate(query);
		    	JOptionPane.showMessageDialog(null, "Account Created Successfully");
		    	
		    	this.setVisible(false);
		    	new Log_in().setVisible(true);
		    }catch(Exception ex) {
		    	
		    }
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
			new Log_in().setVisible(true);
			
		}
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new SignUp();
       
	}

}
