package Hotel;
import javax.swing.*;
import javax.swing.border.LineBorder;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Room extends JFrame implements ActionListener {
	JTable t1;
    JButton b1,b2;
    Room(){
  	t1=new JTable();
  	t1.setBounds(0,40,500,500);
  	add(t1);
  	
  	JLabel l1=new JLabel("Room no");
	l1.setBounds(30,10,70,20);
	add(l1);
	
	/*JLabel l2=new JLabel("Available");
	l2.setBounds(120,10,70,20);
	add(l2);
	
	JLabel l3=new JLabel("Status");
	l3.setBounds(220,10,70,20);
	add(l3);
	
	JLabel l4=new JLabel("Price");
	l4.setBounds(320,10,70,20);
	add(l4);
	
	JLabel l5=new JLabel("Bed Type");
	l5.setBounds(410,10,70,20);
	add(l5);*/
  	
  	b1=new JButton("Load data");
	b1.setBounds(100,560,120,30);
	b1.setBackground(Color.black);
	b1.setForeground(Color.white);
	b1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
	b1.setBorder(new LineBorder(Color.black));
	b1.addActionListener(this);
	add(b1);
	
	b2=new JButton("Back");
	b2.setBounds(250,560,120,30);
	b2.setBackground(Color.black);
	b2.setForeground(Color.white);
	b2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
	b2.setBorder(new LineBorder(Color.black));
	b2.addActionListener(this);
	add(b2);	 
  	
	 ImageIcon img=new ImageIcon(getClass().getResource("/icons/Room1.jpg"));
	 Image img2=img.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
	 ImageIcon img3=new ImageIcon(img2);
 	 JLabel l=new JLabel(img3);
	 l.setBounds(500,-10,600,700);
  	 add(l);
	//getContentPane().setBackground(Color.white);
	setLayout(null);
	setBounds(500,200,1050,700);
	setVisible(true);	 
     }
    
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==b1) {
    		try {
      		  Database1 db=new Database1();
      		  String str="Select * from room";
      		  ResultSet rs=db.stmt.executeQuery(str);
      		  
      		  t1.setModel(DbUtils.resultSetToTableModel(rs));
      	   }catch(Exception e) {
      		   
      	   }
    	}else if(ae.getSource()==b2) {
    		this.setVisible(false);
    		new Reception().setVisible(true);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new Room().setVisible(true);
	}

}
