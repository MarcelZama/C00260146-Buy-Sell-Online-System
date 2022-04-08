package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textFirstName;
	private JTextField textSecondName;
	private JTextField textEmail;
	private JTextField textLogin;
	private JTextField textPassword;
	private JTextField textMobileNumber;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcome.setBounds(163, 11, 118, 56);
		contentPane.add(lblWelcome);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(279, 78, 176, 14);
		contentPane.add(lblLogin);
		
		textFirstName = new JTextField();
		textFirstName.setColumns(10);
		textFirstName.setBounds(10, 93, 145, 20);
		contentPane.add(textFirstName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 144, 118, 14);
		contentPane.add(lblEmail);
		
		textSecondName = new JTextField();
		textSecondName.setColumns(10);
		textSecondName.setBounds(10, 124, 145, 20);
		contentPane.add(textSecondName);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(10, 155, 145, 20);
		contentPane.add(textEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(279, 114, 118, 14);
		contentPane.add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first_name = textFirstName.getText();
                String last_name = textSecondName.getText();
                String Email = textEmail.getText();
                String userName = textLogin.getText();
                String mobileNumber = textMobileNumber.getText();
                int len = mobileNumber.length();
                String password = textPassword.getText();

                String msg = "" + first_name;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnRegister, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c00260146 buy/sell system", "root", "");

                    String query = "INSERT INTO users (first_name, last_name, Username, Password, Email, mobile_number) VALUES('" + first_name + "','" + last_name + "','" + userName + "','" +password + "','" + Email + "','" + mobileNumber + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnRegister, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnRegister,
                            "Welcome, " + msg + "Your account is sucessfully created ,You can proceed to LogIn screen.");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
			}
		});
		btnRegister.setBounds(197, 186, 84, 23);
		contentPane.add(btnRegister);
		
		JButton btnLogin = new JButton("Login");	
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn LogIn = new LogIn();
				LogIn.setVisible(true);
				Register.this.dispose();
			}
		});
		btnLogin.setBounds(136, 186, 66, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("C00260146 BUY/SELL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 220, 176, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SYSTEM PROJECT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 241, 176, 20);
		contentPane.add(lblNewLabel_1);
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(279, 93, 145, 20);
		contentPane.add(textLogin);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(279, 124, 145, 20);
		contentPane.add(textPassword);
		
		textMobileNumber = new JTextField();
		textMobileNumber.setColumns(10);
		textMobileNumber.setBounds(279, 155, 145, 20);
		contentPane.add(textMobileNumber);
		
		JLabel lblPhoneNumber = new JLabel("Mobile number:");
		lblPhoneNumber.setBounds(279, 144, 118, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(10, 78, 75, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblSecondName = new JLabel("Second name:");
		lblSecondName.setBounds(10, 108, 104, 25);
		contentPane.add(lblSecondName);
	}
}
