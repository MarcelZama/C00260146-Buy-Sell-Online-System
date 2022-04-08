package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class addtoCart {

	private static int id;
	private static String name;
	private static int quantity;
	private static double Sellp;
	private static double Buyp;
	private static double voucher;
	private static String classs;
	private static int userid;
	
	public static void addtooCart(int idin,String namein,int quantityin,double Sellpin,double Buypin,double voucherin,String classsin)
	{
		id = idin;
		name = namein;
		quantity = quantityin;
		Sellp = Sellpin;
		Buyp = Buypin;
		voucher = voucherin;
		classs = classsin;
		try 
		  { 
		      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      
		      String query = "insert into cart (ID, Name_of_product, Quantity_in_stock, Selling_Price, Buying_Price, Voucher, Class, userid) values (?,?,?,?,?,?,?,?)";
		      
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt    (1, id);
		      preparedStmt.setString (2, name);
		      preparedStmt.setInt    (3, quantity);
		      preparedStmt.setDouble (4, Sellp);
		      preparedStmt.setDouble (5, Buyp);
		      preparedStmt.setDouble (6, voucher);
		      preparedStmt.setString (7, classs);
		      preparedStmt.setInt    (8, userid);

		      preparedStmt.execute();
		      
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
	}
	
	public static void getbyid(int productid)
	{
		try 
		  { 
		      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      System.out.println("It tryes3");
		      
		      String query = "SELECT * FROM products WHERE ID = '" + productid + "'";
		      
		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);
		        
		      		res.next();
			        int id = res.getInt("ID");
			        String name = res.getString("Name_of_product");
			        int quantity = res.getInt("Quantity_in_stock");
			        double sellprice = res.getDouble("Selling_Price");
			        double buyprice = res.getDouble("Buying_Price");
			        double Voucher = res.getDouble("Voucher");
			        String classs = res.getString("Class");	 
			        
			        addtooCart(id,name,quantity,sellprice,buyprice,Voucher,classs);
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
	}
	public static void gettheid(String id1)
	{
		int IDSelected = Integer.parseInt(id1);
		getbyid(IDSelected);
	}
	public static void getuserid(String useridin)
	{
		userid = Integer.parseInt(useridin);
	}
}
