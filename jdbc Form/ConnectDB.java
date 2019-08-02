import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

public class ConnectDB {

	
 public static Connection dbConn() throws IOException,SQLException,ClassNotFoundException
 {
	 Connection cn;
     Class.forName("oracle.jdbc.driver.OracleDriver");
     cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","cool");
     
     return cn;
 }	
	public static void main(String[] args) {
		 try{
	            
	            System.out.println(dbConn());
	            if(dbConn() != null)
	            {
	                System.out.println("Connected");
	            }
	            else
	            {
	                System.err.println("Not Connceted");
	            }
	            
	        }catch( Exception e)
	        {
	          e.printStackTrace();  
	        }  
		
	}

}
