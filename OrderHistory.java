package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OrderHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static String userId;
	private static int x;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderHistory frame = new OrderHistory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OrderHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Return to Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage MainPage = new MainPage();
				MainPage.setVisible(true);
				OrderHistory.this.dispose();//close login page
			}
		});
		btnNewButton.setBounds(273, 362, 162, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 708, 334);
		contentPane.add(scrollPane);
		
		userId = gettotal.getuserid();
		try 
		  { 
		      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query2 = "SELECT COUNT(*) FROM orders WHERE userId = '"+userId+"'";
		      Statement stm2 = con.createStatement();
		      ResultSet res2 = stm2.executeQuery(query2);
		      
		      while (res2.next()) {
		      String x2 = res2.getString("COUNT(*)");
		      x = Integer.parseInt(x2);
		      }
		      
		      
		      String query = "SELECT * FROM orders WHERE userId='"+userId+"'";
		      
		      
		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);

		      String columns[] = { "orderId", "Name_of_product", "Selling_Price", "Class"};
		      String data[][] = new String[x][4];
		    
		        int i = 0;
		        
		        while (res.next()) {
			        int id = res.getInt("orderId");
			        String name = res.getString("Name_of_product");
			        double sellprice = res.getDouble("Selling_Price");
			        String classs = res.getString("Class");
			        data[i][0] = id + "";
			        data[i][1] = name;
			        data[i][2] = sellprice + "";
			        data[i][3] = classs;
			        i++;
			        x++;
		        }
		    
		      
		      table = new JTable();
			  scrollPane.setViewportView(table);
			  table.setModel(new DefaultTableModel(data, columns));
			  table.setShowGrid(true);
			  table.setShowVerticalLines(true);
		      scrollPane.repaint();
		      
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
		}
		
		
	}
