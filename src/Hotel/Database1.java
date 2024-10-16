package Hotel;
import java.sql.*;
public class Database1 {
      Statement stmt;
      Connection conn;
	public Database1()  {
		// TODO Auto-generated method stub
       try {
    	  // Class.forName("con.mysql.jdbc.Driver");
    	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel","root","Shweta@123");
    	    stmt=conn.createStatement();
       }
       catch(SQLException ex){
    	   
       }
	}
       public static void main(String[] args) {
    	   new Database1();
	}

}
