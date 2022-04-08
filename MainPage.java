package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainPage extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private String secondquery = "";
	private int x=0;
	
	private JTextField textFieldIDSelection;
	private static String IDSelection;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private String choise="";
	private static int userid;
	private int firststart = 1;
	
	JPanel paneMainContent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public static void getuser(String userID,String firstnameIn,String secondnameIn,String emailIn,String loginIn,String passwordIn,String phonenrIn)
	{
		String iduser = userID;
		String firstname = firstnameIn;
		String secondname = secondnameIn;
		String email = emailIn;
		String login = loginIn;
		String password = passwordIn;
		String phonenr = phonenrIn;
		
		addtoCart.getuserid(iduser);
		userid = Integer.parseInt(iduser);
	}
	/**
	 * Create the frame.
	 */
	public MainPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
		});		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		if(firststart == 1)
		{
			choise = "Gaming";
			queryDB(choise);
		}
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(0, 128, 128));
		paneMenu.setBounds(0, 0, 243, 561);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C00260146 BUY/SELL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 223, 39);
		paneMenu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SYSTEM PROJECT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 39, 223, 44);
		paneMenu.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Catalogue");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 80, 223, 53);
		paneMenu.add(lblNewLabel_2);
		
		JPanel panelGaming = new JPanel();
		panelGaming.addMouseListener(new PanelButtonMouseAdapter(panelGaming) {
			@Override
			public void mouseClicked(MouseEvent e) {
				choise = "Gaming";
				queryDB(choise);
			}
		});
		panelGaming.setBackground(new Color(0, 128, 128));
		panelGaming.setForeground(new Color(255, 250, 250));
		panelGaming.setToolTipText("");
		panelGaming.setBounds(20, 144, 213, 58);
		paneMenu.add(panelGaming);
		panelGaming.setLayout(null);
		
		JLabel lblGaming = new JLabel("Gaming");
		lblGaming.setForeground(new Color(255, 255, 255));
		lblGaming.setHorizontalAlignment(SwingConstants.CENTER);
		lblGaming.setFont(new Font("Dialog", Font.BOLD, 20));
		lblGaming.setBounds(41, 11, 129, 26);
		lblGaming.setVerticalAlignment(SwingConstants.BOTTOM);
		panelGaming.add(lblGaming);
		
		JPanel panelPhones = new JPanel();
		panelPhones.addMouseListener(new PanelButtonMouseAdapter(panelPhones) {
			@Override
			public void mouseClicked(MouseEvent e) {
				choise = "Phones";
				queryDB(choise);
			}
		});
		panelPhones.setBackground(new Color(0, 128, 128));
		panelPhones.setForeground(new Color(255, 250, 250));
		panelPhones.setBounds(20, 213, 213, 58);
		paneMenu.add(panelPhones);
		panelPhones.setLayout(null);
		
		JLabel lblPhones = new JLabel("Phones");
		lblPhones.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhones.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhones.setForeground(Color.WHITE);
		lblPhones.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPhones.setBounds(42, 11, 129, 26);
		panelPhones.add(lblPhones);
		
		JPanel panelElectronics = new JPanel();
		panelElectronics.addMouseListener(new PanelButtonMouseAdapter(panelElectronics) {
			@Override
			public void mouseClicked(MouseEvent e) {
				choise = "Electronics";
				queryDB(choise);
			}
		});
		panelElectronics.setBackground(new Color(0, 128, 128));
		panelElectronics.setForeground(new Color(255, 250, 250));
		panelElectronics.setBounds(20, 282, 213, 58);
		paneMenu.add(panelElectronics);
		panelElectronics.setLayout(null);
		
		JLabel lblElectronics = new JLabel("Electronics");
		lblElectronics.setVerticalAlignment(SwingConstants.BOTTOM);
		lblElectronics.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectronics.setForeground(Color.WHITE);
		lblElectronics.setFont(new Font("Dialog", Font.BOLD, 20));
		lblElectronics.setBounds(42, 11, 129, 26);
		panelElectronics.add(lblElectronics);
		
		JPanel panelFilmtv = new JPanel();
		panelFilmtv.addMouseListener(new PanelButtonMouseAdapter(panelFilmtv) {
			@Override
			public void mouseClicked(MouseEvent e) {
				choise = "Film/Tv";
				queryDB(choise);
			}
		});
		panelFilmtv.setBackground(new Color(0, 128, 128));
		panelFilmtv.setForeground(new Color(255, 250, 250));
		panelFilmtv.setBounds(20, 351, 213, 58);
		paneMenu.add(panelFilmtv);
		panelFilmtv.setLayout(null);
		
		JLabel lblFilmtv = new JLabel("Film/TV");
		lblFilmtv.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFilmtv.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilmtv.setForeground(Color.WHITE);
		lblFilmtv.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFilmtv.setBounds(45, 11, 129, 26);
		panelFilmtv.add(lblFilmtv);
		
		JPanel panelComputing = new JPanel();
		panelComputing.addMouseListener(new PanelButtonMouseAdapter(panelComputing) {
			@Override
			public void mouseClicked(MouseEvent e) {
				choise = "Computing";
				queryDB(choise);
			}
		});
		panelComputing.setBackground(new Color(0, 128, 128));
		panelComputing.setForeground(new Color(255, 250, 250));
		panelComputing.setBounds(20, 420, 213, 58);
		paneMenu.add(panelComputing);
		panelComputing.setLayout(null);
		
		JLabel lblComputing = new JLabel("Computing");
		lblComputing.setVerticalAlignment(SwingConstants.BOTTOM);
		lblComputing.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputing.setForeground(Color.WHITE);
		lblComputing.setFont(new Font("Dialog", Font.BOLD, 20));
		lblComputing.setBounds(47, 11, 129, 26);
		panelComputing.add(lblComputing);
		
		JButton btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choise = "Cart";
				queryDB(choise);
			}
		});
		btnCart.setBounds(0, 504, 106, 32);
		paneMenu.add(btnCart);
		
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to Sign Out?") == 0)
				{
					LogIn LogIn = new LogIn();
					LogIn.setVisible(true);
					MainPage.this.dispose();
				}
			}
		});
		btnLogOut.setBounds(885, 11, 89, 23);
		contentPane.add(btnLogOut);
		
		JButton btnSupport = new JButton("Support");
		btnSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "  FAQs: \n\n\n"
						+ "  What is this project used for? \n"
						+ "This is a Sell-Buy system that allows the user to buy and sell items easy and comfortable. \n\n"
						+ "  Are the products new or second hand? \n"
						+ "Most of them are second hand but we have products brand new as well. \n\n"
						+ "  How can I cancel my order? \n"
						+ "If you've changed your mind about an order and wish to cancel it, you need to email us. \n\n\n\n\n"
						+ "												                                             For any questions you can contact us on E-mail:\n"
						+ "												                                             C00260146@itcarlow.ie");
			}
		});
		btnSupport.setBounds(786, 11, 89, 23);
		contentPane.add(btnSupport);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "				About \n\n\n\n\n\n\n"
						+ "Our first shop was opened in London in 1992. We \n"
						+ "have stores in UK,Spain,Ireland,India.\n"
						+ "Australia, Portugal, Netherlands, Mexico, Poland\n"
						+ "and Canarias.We buy, sell and exchange a range\n"
						+ "of technology and entertainment products\n"
						+ "including mobile phones, video games, DVDs and \n"
						+ "Blu-ray movies, computers, digital electronics, TVs \n"
						+ "and monitors, and music CDs. \n\n\n\n\n\n\n");
			}
		});
		btnAbout.setBounds(687, 11, 89, 23);
		contentPane.add(btnAbout);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile Profile = new Profile();
				Profile.setVisible(true);
				MainPage.this.dispose();
			}
		});
		btnProfile.setBounds(588, 11, 89, 23);
		contentPane.add(btnProfile);
		
		textFieldIDSelection = new JTextField(IDSelection);
		textFieldIDSelection.setColumns(10);
		textFieldIDSelection.setBounds(278, 527, 89, 23);
		contentPane.add(textFieldIDSelection);
		
		JButton btnBuy = new JButton("Add to Cart");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String v =(textFieldIDSelection.getText());
				addtoCart.gettheid(v);
			}
		});
		btnBuy.setBounds(377, 527, 101, 23);
		contentPane.add(btnBuy);
		
		JButton btnSell = new JButton("Proceed to checkout");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voucher Voucher = new Voucher();
				Voucher.setVisible(true);
				MainPage.this.dispose();
			}
		});
		btnSell.setBounds(817, 527, 157, 23);
		contentPane.add(btnSell);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(253, 525, 29, 23);
		contentPane.add(lblNewLabel_3);
		
		JButton btnDelete = new JButton("Delete from Cart");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String v =(textFieldIDSelection.getText());
				int idout = Integer.parseInt(v);
				deletefromCart.delfromCart(idout,userid);
			}
		});
		btnDelete.setBounds(488, 527, 133, 23);
		contentPane.add(btnDelete);
	}

	// queryDB
	public void queryDB(String choise){
		
		if (paneMainContent != null) {
			contentPane.remove(paneMainContent);
		}
		contentPane.repaint();
		
		paneMainContent = 	new JPanel();
		paneMainContent.setBounds(253, 42, 721, 474);
		paneMainContent.setVisible(true);
		contentPane.add(paneMainContent);
		paneMainContent.setLayout(null);
		paneMainContent.setVisible(true);
		contentPane.repaint();


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 701, 452);
		paneMainContent.add(scrollPane);
		x=0;
		if(choise!="Cart") {
		try 
		  { 
		      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      
		      String query2 = "SELECT COUNT(*) FROM products WHERE CLASS = '"+choise+"'";
		      Statement stm2 = con.createStatement();
		      ResultSet res2 = stm2.executeQuery(query2);
		      
		      while (res2.next()) {
		      String x2 = res2.getString("COUNT(*)");
		      x = Integer.parseInt(x2);
		      }
		      
		      
		      String query = "SELECT * FROM products WHERE CLASS='"+choise+"'";
		      
		      
		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);

		      String columns[] = { "ID", "Name_of_product", "Quantity_in_stock", "Selling_Price", "	Buying_Price", "Voucher", "Class"};
		      String data[][] = new String[x][7];
		    
		        int i = 0;
		        
		        while (res.next()) {
			        int id = res.getInt("ID");
			        String name = res.getString("Name_of_product");
			        int quantity = res.getInt("Quantity_in_stock");
			        double sellprice = res.getDouble("Selling_Price");
			        double buyprice = res.getDouble("Buying_Price");
			        double Voucher = res.getDouble("Voucher");
			        String classs = res.getString("Class");
			        data[i][0] = id + "";
			        data[i][1] = name;
			        data[i][2] = quantity + "";
			        data[i][3] = sellprice + "";
			        data[i][4] = buyprice + "";
			        data[i][5] = Voucher + "";
			        data[i][6] = classs;
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
		else {
			try 
			  { 
			      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
			      
			      String query2 = "SELECT COUNT(*) FROM cart WHERE userid = '"+userid+"';";
			      Statement stm2 = con.createStatement();
			      ResultSet res2 = stm2.executeQuery(query2);
			      
			      while (res2.next()) {
			      String x2 = res2.getString("COUNT(*)");
			      x = Integer.parseInt(x2);
			      }
			      
			      
			      String query = "SELECT * FROM cart WHERE userid = '" + userid + "'";
			      
			      Statement stm = con.createStatement();
			      ResultSet res = stm.executeQuery(query);

			      String columns[] = { "ID", "Name_of_product", "Quantity_in_stock", "Selling_Price", "	Buying_Price", "Voucher", "Class"};

			      String data[][] = new String[x][7];
			    
			        int i = 0;
			        while (res.next()) {
				        int id = res.getInt("ID");
				        String name = res.getString("Name_of_product");
				        int quantity = res.getInt("Quantity_in_stock");
				        double sellprice = res.getDouble("Selling_Price");
				        double buyprice = res.getDouble("Buying_Price");
				        double Voucher = res.getDouble("Voucher");
				        String classs = res.getString("Class");
				        data[i][0] = id + "";
				        data[i][1] = name;
				        data[i][2] = quantity + "";
				        data[i][3] = sellprice + "";
				        data[i][4] = buyprice + "";
				        data[i][5] = Voucher + "";
				        data[i][6] = classs;
				        ++i;
				        ++x;
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

	private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(0, 128, 128));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(0, 128, 128));
		}
		
	}
}


