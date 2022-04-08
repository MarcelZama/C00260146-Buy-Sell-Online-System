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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Changedetails extends JFrame {

	private JPanel contentPane;
	private JTextField textfname;
	private JTextField textsname;
	private JTextField textemail;
	private JTextField textlogin;
	private JTextField textpassword;
	private JTextField textmobilenr;
	
	private static String iduser;
	private static String firstname;
	private static String secondname;
	private static String email;
	private static String login;
	private static String password;
	private static String phonenr;
	
	private static int useridint;
	private static String firstname2;
	private static String secondname2;
	private static String email2;
	private static String login2;
	private static String password2;
	private static String phonenr2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Changedetails frame = new Changedetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void getuser(String userID,String firstnameIn,String secondnameIn,String emailIn,String loginIn,String passwordIn,String phonenrIn)
	{
		iduser=userID;
		firstname = firstnameIn;
		secondname = secondnameIn;
		email = emailIn;
		login = loginIn;
		password = passwordIn;
		phonenr = phonenrIn;
	}
	
	public Changedetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(0, 128, 128));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcome.setBounds(163, 11, 118, 56);
		contentPane_1.add(lblWelcome);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(279, 78, 176, 14);
		contentPane_1.add(lblLogin);
		
		textfname = new JTextField(firstname);
		textfname.setColumns(10);
		textfname.setBounds(10, 93, 145, 20);
		contentPane_1.add(textfname);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 144, 118, 14);
		contentPane_1.add(lblEmail);
		
		textsname = new JTextField(secondname);
		textsname.setColumns(10);
		textsname.setBounds(10, 124, 145, 20);
		contentPane_1.add(textsname);
		
		textemail = new JTextField(email);
		textemail.setColumns(10);
		textemail.setBounds(10, 155, 145, 20);
		contentPane_1.add(textemail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(279, 114, 118, 14);
		contentPane_1.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("C00260146 BUY/SELL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 209, 176, 20);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SYSTEM PROJECT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 231, 176, 20);
		contentPane_1.add(lblNewLabel_1);
		
		textlogin = new JTextField(login);
		textlogin.setColumns(10);
		textlogin.setBounds(279, 93, 145, 20);
		contentPane_1.add(textlogin);
		
		textpassword = new JTextField(password);
		textpassword.setColumns(10);
		textpassword.setBounds(279, 124, 145, 20);
		contentPane_1.add(textpassword);
		
		textmobilenr = new JTextField(phonenr);
		textmobilenr.setColumns(10);
		textmobilenr.setBounds(279, 155, 145, 20);
		contentPane_1.add(textmobilenr);
		
		JLabel lblPhoneNumber = new JLabel("Mobile number:");
		lblPhoneNumber.setBounds(279, 144, 118, 14);
		contentPane_1.add(lblPhoneNumber);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(10, 78, 75, 14);
		contentPane_1.add(lblFirstName);
		
		JLabel lblSecondName = new JLabel("Second name:");
		lblSecondName.setBounds(10, 108, 104, 25);
		contentPane_1.add(lblSecondName);
		
		JLabel lblid = new JLabel("User ID: ");
		lblid.setBounds(173, 61, 55, 14);
		contentPane_1.add(lblid);
		
		JLabel lblforID = new JLabel(iduser);
		lblforID.setBounds(235, 61, 46, 14);
		contentPane_1.add(lblforID);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				useridint = Integer.parseInt(iduser);
				firstname2 = textfname.getText();
				secondname2 = textsname.getText();
				login2 = textlogin.getText();
				password2 = textpassword.getText();
				email2 = textemail.getText();
				phonenr2 = textmobilenr.getText();
				changevalue(useridint,firstname2,secondname2,login2,password2,email2,phonenr2);
				JOptionPane.showMessageDialog(null,"Changes have been saved!");
				LogIn LogIn = new LogIn();
				LogIn.setVisible(true);
				Changedetails.this.dispose();
			}
		});
		btnConfirm.setBounds(177, 185, 84, 23);
		contentPane_1.add(btnConfirm);
	}
	
	public void changevalue(int iduser,String firstnamein,String lastnamein,String usernamein,String passwordin,String email,String mobilenrin)
	{
		try{
			System.out.println(iduser);
			System.out.println(firstnamein);
			System.out.println(lastnamein);
			System.out.println(usernamein);
			System.out.println(passwordin);
			System.out.println(email);
			System.out.println(mobilenrin);
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");
		      	
		      String query = "UPDATE users SET first_name = '"+ firstnamein +"', last_name = '"+ lastnamein +"', Username = '"+ usernamein +"', Password = '"+ passwordin +"', Email = '"+ email +"', mobile_number = '"+ mobilenrin +"' WHERE ID = '" + iduser + "'";
		      
		      Statement stm = con.createStatement();
		      stm.executeUpdate(query);
		      
		  } catch(SQLException e) {
		      e.printStackTrace();
		  }
	}
}
