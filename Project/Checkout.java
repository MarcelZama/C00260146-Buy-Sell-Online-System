package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Checkout extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAddress;
	private JTextField textFieldtown;
	private JTextField textFieldcounty;
	private JTextField textFieldEircode;
	private static String total;
	private static double total2;
	private static int maxorderid;
	private static int maxtransaction;
	private static String userId;
	private static double voucher; //sum of voucher
	private static int voucherid;
	private static int id;
	private static int quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkout frame = new Checkout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Checkout() {

		userId = gettotal.getuserid();

		total = gettotal.getttotal();
		
		voucherid = gettotal.getvoucher();

		voucher = gettotal.getvoucherprice();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(47, 79, 79));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Total amount to pay:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(181, 60, 326, 68);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(total);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(472, 60, 124, 68);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Please insert delivery address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(181, 11, 326, 61);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(124, 115, 83, 25);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("City/Town :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(103, 151, 104, 25);
		contentPane_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("County :");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(132, 187, 75, 25);
		contentPane_1.add(lblNewLabel_3_1_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage MainPage = new MainPage();
				MainPage.setVisible(true);
				Checkout.this.dispose();
			}
		});
		btnCancel.setBounds(217, 272, 124, 23);
		contentPane_1.add(btnCancel);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(217, 121, 319, 20);
		contentPane_1.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldtown = new JTextField();
		textFieldtown.setBounds(217, 157, 319, 20);
		contentPane_1.add(textFieldtown);
		textFieldtown.setColumns(10);
		
		textFieldcounty = new JTextField();
		textFieldcounty.setBounds(217, 193, 319, 20);
		contentPane_1.add(textFieldcounty);
		textFieldcounty.setColumns(10);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("    Eircode :");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1.setBounds(103, 223, 115, 25);
		contentPane_1.add(lblNewLabel_3_1_1_1);
		
		textFieldEircode = new JTextField();
		textFieldEircode.setColumns(10);
		textFieldEircode.setBounds(217, 229, 319, 20);
		contentPane_1.add(textFieldEircode);
		
		if(voucher>=0)
		{
		JLabel lblNewLabel_Voucher = new JLabel("Voucher:");
		lblNewLabel_Voucher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_Voucher.setBounds(13, 11, 83, 23);
		contentPane_1.add(lblNewLabel_Voucher);
		
		String stringvoucher = Double.toString(voucher);
		JLabel lblNewLabelvoucherid = new JLabel(stringvoucher);
		lblNewLabelvoucherid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelvoucherid.setBounds(95, 11, 56, 22);
		contentPane_1.add(lblNewLabelvoucherid);
		
		JButton btnConfirm = new JButton("Confirm Order");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String address=textFieldAddress.getText();
				String town=textFieldtown.getText();
				String county=textFieldcounty.getText();
				String eircode=textFieldEircode.getText();
				
				int useridint = Integer.parseInt(userId);
				getdeleteq(useridint);
				getitems(useridint);
				confirmorder( useridint, total2, voucher, address, town, county, eircode);
				
				if(JOptionPane.showConfirmDialog(null, "Success your transaction was sucesfully confimed. \n would you like to continue shoping?") == 0)
				{
					MainPage MainPage = new MainPage();
					MainPage.setVisible(true);
					Checkout.this.dispose();
				}
				else
				{
					Checkout.this.dispose();
				}
			}
		});
		btnConfirm.setBounds(412, 272, 124, 23);
		contentPane_1.add(btnConfirm);
		}
	}
	
	
	
	public void confirmorder(int useridin,double pricein,double voucherin,String addressin,String cityin,String countyin,String eircodein)
	{
		
		////Get max transaction id////
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system?useSSL=false","root","");	
		
		Statement stm = con.createStatement();
		
		String query = "Select MAX(orderId) FROM orders";
		ResultSet rs = stm.executeQuery(query);
		
		if(rs.next())
		{
			maxorderid = rs.getInt("MAX(orderId)");
		}
		}
		catch(Exception E){
			System.out.print(E.getMessage());
		}
		inserttransaction(useridin, maxorderid, pricein, addressin, cityin, countyin, eircodein, voucher, voucherid);
		
	}
	public void getitems(int useridin) // get items from cart table
	{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system?useSSL=false","root","");	
			
			Statement stm = con.createStatement();
			
			String query = "Select MAX(orderId) FROM orders";
			ResultSet rs = stm.executeQuery(query);
			
			rs.next();
			
			maxorderid = rs.getInt("MAX(orderId)");
			
			if (maxorderid == 0){
				maxorderid = 1;
			}
			else if(maxorderid >= 1)
			{
				maxorderid++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}					

		try 
		  { 
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query2 = "SELECT COUNT(*) FROM cart WHERE userId = '"+useridin+"'";
		      Statement stm2 = conn.createStatement();
		      ResultSet res2 = stm2.executeQuery(query2);
		      
		      res2.next();
		      String x2 = res2.getString("COUNT(*)");
		      int x = Integer.parseInt(x2);	  
			
		      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query = "SELECT Name_of_product, Selling_Price, Class FROM cart WHERE userId = '" + useridin + "'";

		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);
		      
		      String data[][] = new String[x][3];
		      int i = 0;
		        
		         while (res.next()) {
			        String name = res.getString("Name_of_product");
			        
			        double sellprice = res.getDouble("Selling_Price");

			        String classs = res.getString("Class");	 
			            
			        senditems(maxorderid,name,sellprice,classs,useridin);
		         }
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
		 	deleteitems(useridin);
	}
	
	
	public void senditems(int max,String name,double sellprice,String classs,int userid) // send items to order table
	{
		try{
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");

		      String query = "INSERT INTO orders VALUES ('"+max+"','"+name+"','"+sellprice+"','"+classs+"','"+userid+"')";
		      
		      Statement stm = con.createStatement();
		      stm.executeUpdate(query);
		      
		  } catch(SQLException e) {
		      e.printStackTrace();
		  }
	}
	
	
	public void deleteitems(int userid) //empty user cart 
	{
		try{
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query = "DELETE FROM cart WHERE userId = '" + userid + "'";
		      
		      Statement stm = con.createStatement();
		      stm.executeUpdate(query);
		      
		  } catch(SQLException e) {
		      e.printStackTrace();
		  }
	}
	public void inserttransaction(int userid,int orderid,double price,String Address,String City,String County,String eircode,double voucherprice,int voucherid)//add record of the transaction to the transaction table
	{
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system?useSSL=false","root","");	
		
		Statement stm = con.createStatement();
		
		String query = "Select MAX(TransactionId) FROM transaction";
		ResultSet rs = stm.executeQuery(query);
		
		rs.next();
		
		maxtransaction = rs.getInt("MAX(TransactionId)");
			
		if(maxtransaction == 0)
		{
			maxtransaction =1;
		}
		else if(maxtransaction >=1)
		{
			maxtransaction++;
		}
			
		} catch(SQLException e) {
		      e.printStackTrace();
		  }	
		
		try{
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query = "INSERT INTO transaction VALUES ('"+maxtransaction+"', '"+userid+"', '"+orderid+"', '"+price+"', '"+Address+"', '"+City+"', '"+County+"', '"+eircode+"', '"+voucherprice+"', '"+voucherid+"')"; //  WHERE ID = '" + voucherid + "'
		      
		      Statement stm = con.createStatement();

		      stm.executeUpdate(query);

		      markvoucherused(voucherid);
		      
		  } catch(SQLException e) {
		      e.printStackTrace();
		  }
	}
	
	public void getdeleteq(int useridin)
	{
		try 
		  { 
		      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query = "SELECT ID, Quantity_in_stock, Class FROM cart WHERE userId = '" + useridin + "'";

		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query); 
		     
		         while (res.next()) {
		        	 id = res.getInt("ID");
			         quantity = res.getInt("Quantity_in_stock");
			         quantity--;
		         }
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
		try {
		     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		
		     String query2 = "UPDATE products SET Quantity_in_stock = '"+quantity+"' WHERE ID = '" + id + "'";
	         Statement stm2 = con.createStatement();
	         stm2.executeUpdate(query2);
	         
		} catch(SQLException e) {
		      e.printStackTrace();
		    }
	}

	public void markvoucherused(int voucher)
	{
		try{
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      	
		      String query = "UPDATE voucher SET used = 1 WHERE ID = '" + voucher + "'";
		      
		      Statement stm = con.createStatement();
		      stm.executeUpdate(query);
		      
		  } catch(SQLException e) {
		      e.printStackTrace();
		  }
	}
}
