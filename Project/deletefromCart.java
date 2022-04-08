package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class deletefromCart {
	
	public static void delfromCart(int idin,int userid)
	{
		try 
		  { 
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query = "Delete FROM cart WHERE ID='"+ idin +"' AND userid = '"+ userid +"' LIMIT 1";
		           
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.execute();
		      
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
	}
}
