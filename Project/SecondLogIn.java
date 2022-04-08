package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class SecondLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondLogIn frame = new SecondLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SecondLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(138, 78, 176, 14);
		contentPane.add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setBounds(138, 93, 145, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(138, 124, 118, 14);
		contentPane.add(lblPassword);
		
		JLabel lblWelcome = new JLabel("Change Details");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcome.setBounds(125, 25, 200, 56);
		contentPane.add(lblWelcome);
		
		JButton btnConfirmu = new JButton("Confirm");
		btnConfirmu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system?useSSL=false","root","");
	
					String username = textLogin.getText();
					String password = passwordField.getText();		
					
					Statement stm = con.createStatement();
					//mysql query to run
					String sql = "select * from users where username='"+username+"' and Password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					
					if(rs.next())
						{

							Changedetails Changedetails = new Changedetails();
							Changedetails.setVisible(true);
							SecondLogIn.this.dispose();//close login page
						}
					else {
						//if username and password are wrong show message
						JOptionPane.showMessageDialog(btnConfirmu, "username or password is wrong..");
						
							textLogin.setText("");
							passwordField.setText("");
					}
					
					con.close();
					
					}
				catch(Exception E){
					System.out.print(E.getMessage());
				}
			}
		});
		btnConfirmu.setBounds(138, 169, 145, 23);
		contentPane.add(btnConfirmu);
		
		JLabel lblNewLabel = new JLabel("C00260146 BUY/SELL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 219, 176, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SYSTEM PROJECT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 241, 176, 20);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 138, 145, 20);
		contentPane.add(passwordField);
	}

}

