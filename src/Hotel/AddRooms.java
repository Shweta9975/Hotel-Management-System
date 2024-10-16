package Hotel;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.*;
public class AddRooms extends JFrame implements ActionListener {
   
	JLabel l1;
     JTextField t1,t2;
     JComboBox c1,c2,c3;
     JButton b1,b2;
	AddRooms(){
		
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(200,60,550,450);
		p.setBackground(new Color(0,0,0,80));
		add(p);
		
		l1=new JLabel("ADD ROOMS");
		l1.setBounds(200,20,200,60);
		l1.setForeground(Color.white);
		l1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		p.add(l1);
		
		 JLabel room=new JLabel("Room Number");
		room.setBounds(100,100,200,30);
		room.setForeground(Color.white);
		room.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		p.add(room);
		
		t1=new JTextField();
		t1.setBounds(300,100,200,30);
		p.add(t1);
		
		JLabel available=new JLabel("Available");
		available.setBounds(100,150,200,30);
		available.setForeground(Color.white);
		available.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		p.add(available);
		
        c1=new JComboBox(new String[] {"Available","Occupied"});
		c1.setBounds(300,150,200,30);
		c1.setBackground(Color.WHITE);
		p.add(c1);
		
		JLabel status=new JLabel("Cleaning Status");
		status.setBounds(100,200,200,30);
		status.setForeground(Color.white);
		status.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		p.add(status);
		c2=new JComboBox(new String[] {"Cleaned","Dirty"});
		c2.setBounds(300,200,200,30);
		c2.setBackground(Color.WHITE);
		p.add(c2);
		
		JLabel price=new JLabel("Price");
		price.setBounds(100,250,200,30);
		price.setForeground(Color.white);
		price.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		p.add(price);
	    t2 = new JTextField();
	    t2.setBackground(Color.white);
		t2.setBounds(300,250,200,30);
		p.add(t2);
		
		JLabel type=new JLabel("Bed Type");
		type.setBounds(100,300,200,30);
		type.setForeground(Color.white);
		type.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		p.add(type);
	    c3 = new JComboBox(new String[] {"Single Bed","Double Bed"});
		c3.setBounds(300,300,200,30);
		c3.setBackground(Color.WHITE);
        p.add(c3);
		
		b1=new JButton("ADD ROOM");
		b1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		b1.setBackground(new Color(102,30,0));
		b1.setForeground(Color.white);
		b1.setBorder(new LineBorder(new Color(102,30,0)));
		b1.setBounds(90,370,150,40);
		b1.addActionListener(this);
		p.add(b1);
		
		b2=new JButton("CANCEL");
		b2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
		b2.setBackground(new Color(102,30,0));
		b2.setForeground(Color.white);
		b2.setBorder(new LineBorder(new Color(102,30,0)));
		b2.setBounds(300,370,150,40);
		b2.addActionListener(this);
		p.add(b2);
		
		ImageIcon img=new ImageIcon(getClass().getResource("/icons/Room.jpg"));
    	Image img1=img.getImage();
    	Image temp_img=img1.getScaledInstance(1000,600,Image.SCALE_SMOOTH);
    	img=new ImageIcon(temp_img);
    	JLabel l=new JLabel("",img,JLabel.CENTER);
    	l.add(p);
		l.setBounds(0,0,1000,600);
		add(l);
		
		setLayout(null);
		setBounds(500,200,1000,600);
		setVisible(true);
	}
	
	
	
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==b1) {
		String room=t1.getText();
		String available=(String) c1.getSelectedItem();
		String status=(String) c2.getSelectedItem();
		String price=t2.getText();
		String type=(String) c3.getSelectedItem();
		
		Database1 db=new Database1();
		try {
			
			String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
			db.stmt.executeUpdate(str);
			
			JOptionPane.showMessageDialog(null,"New Room Added");
			this.setVisible(false);
		}catch(Exception e) {
			System.out.println(e);
		}	
		
		}else if(ae.getSource()==b2)
	{
		this.setVisible(false);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new AddRooms().setVisible(true);
	}

}
