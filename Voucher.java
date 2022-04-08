package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Voucher extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static double total;
	private static String userId;
	private static int voucherid;
	private static int voucherprice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voucher frame = new Voucher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static void getuserid(String userid)
	{
		userId = userid;
	}
	
	public Voucher() {
		setTitle("Insert Voucher");
		setForeground(new Color(46, 139, 87));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 221);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(47, 79, 79));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inset a voucher if you have one");
		lblNewLabel.setBounds(70, 33, 306, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(132, 94, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("If you don't just press Continue");
		lblNewLabel_1.setBounds(70, 69, 203, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage MainPage = new MainPage();
				MainPage.setVisible(true);
				Voucher.this.dispose();//close Voucher page
			}
		});
		btnNewButton.setBounds(70, 148, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String voucher = textField.getText();
				sendvoucher(voucher,userId);
			}
		});
		btnNewButton_1.setBounds(261, 148, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public void sendvoucher(String vouchercode,String userid)
	{
		if(vouchercode.length()!=0)
		{
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system?useSSL=false","root","");	
				
				Statement stm = con.createStatement();
		
				String sql = "SELECT ID FROM voucher WHERE Voucher_number='"+vouchercode+"' AND used=0 ";

				ResultSet rs = stm.executeQuery(sql);
				
				if(rs.next()) {
					voucherid = rs.getInt("ID");
				}			
			}
			catch(Exception E){
				System.out.print(E.getMessage());
			}
			
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system?useSSL=false","root","");	
				
				Statement stm = con.createStatement();
		
				String sql = "SELECT Price FROM voucher WHERE Voucher_number='"+vouchercode+"' AND used=0 ";
	
				ResultSet rs = stm.executeQuery(sql);

					if(rs.next())
						{		
							double voucherprice = rs.getDouble("Price");

							gettotal(voucherprice,userid,voucherid);
						}	
					else
						{
						JOptionPane.showMessageDialog(null, "\n\n\n"
								+ "  Voucher is invalid \n");
						}
				}
			catch(Exception E){
				System.out.print(E.getMessage());
			}
		}
		else if (vouchercode.length()==0)
			{		
				gettotal(0.0,userid,0);
			}
	}
	
	public void gettotal(double voucher,String userid,int voucherid)
	{
		try 
		  { 
		      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query = "SELECT SUM(Selling_Price) FROM cart WHERE userid = '" + userid + "'";

		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);
		      
		        while (res.next()) {
		        	String total2 = res.getString("SUM(Selling_Price)");

		        	total = Double.parseDouble(total2);

		        	total = total - voucher;

		        	String totalstring = String.valueOf(total);

		        	
		        	gettotal.sendtotal(totalstring);
		        	gettotal.sendvoucher(voucherid); 
		        	gettotal.sendvoucherprice(voucher);
		        	
					Checkout Checkout = new Checkout();
					Checkout.setVisible(true);
					Voucher.this.dispose();//close voucher screen	
		        	}
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
	}
}
