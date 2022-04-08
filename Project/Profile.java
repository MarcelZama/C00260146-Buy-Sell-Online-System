package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile extends JFrame {

	private JPanel contentPane;
	
	private static String iduser;
	private static String firstname;
	private static String secondname;
	private static String email;
	private static String login;
	private static String password;
	private static String phonenr;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	
	public Profile() {
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
		lblWelcome.setBounds(149, 0, 118, 56);
		contentPane_1.add(lblWelcome);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(279, 78, 176, 14);
		contentPane_1.add(lblLogin);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 144, 118, 14);
		contentPane_1.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(279, 114, 118, 14);
		contentPane_1.add(lblPassword);
		
		JButton btnConfirm = new JButton("Return to Main Menu");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage MainPage = new MainPage();
				MainPage.setVisible(true);
				Profile.this.dispose();
			}
		});
		btnConfirm.setBounds(109, 194, 166, 23);
		contentPane_1.add(btnConfirm);
		
		JLabel lblNewLabel = new JLabel("C00260146 BUY/SELL");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(248, 0, 176, 20);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SYSTEM PROJECT");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(285, 22, 176, 20);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblPhoneNumber = new JLabel("Mobile number:");
		lblPhoneNumber.setBounds(279, 144, 118, 14);
		contentPane_1.add(lblPhoneNumber);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(10, 78, 75, 14);
		contentPane_1.add(lblFirstName);
		
		JLabel lblSecondName = new JLabel("Second name:");
		lblSecondName.setBounds(10, 108, 104, 25);
		contentPane_1.add(lblSecondName);
		
		JButton btnWantToChange = new JButton("Want to change details?");
		btnWantToChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SecondLogIn SecondLogIn = new SecondLogIn();
				SecondLogIn.setVisible(true);
				Profile.this.dispose();
			}
		});
		
		btnWantToChange.setBounds(248, 228, 176, 23);
		contentPane_1.add(btnWantToChange);
		
		JLabel lblfn = new JLabel(firstname);
		lblfn.setBounds(10, 93, 104, 14);
		contentPane_1.add(lblfn);
		
		JLabel lblsn = new JLabel(secondname);
		lblsn.setBounds(10, 128, 104, 14);
		contentPane_1.add(lblsn);
		
		JLabel lblemaill = new JLabel(email);
		lblemaill.setBounds(10, 161, 104, 14);
		contentPane_1.add(lblemaill);
		
		JLabel lbllogin = new JLabel(login);
		lbllogin.setBounds(279, 93, 104, 14);
		contentPane_1.add(lbllogin);
		
		JLabel lblpasswor = new JLabel(password);
		lblpasswor.setBounds(279, 128, 104, 14);
		contentPane_1.add(lblpasswor);
		
		JLabel lblnumber = new JLabel(phonenr);
		lblnumber.setBounds(279, 161, 104, 14);
		contentPane_1.add(lblnumber);
		
		JLabel lblforID = new JLabel(iduser);
		lblforID.setBounds(229, 53, 46, 14);
		contentPane_1.add(lblforID);
		
		JLabel lblid = new JLabel("User ID: ");
		lblid.setBounds(177, 53, 54, 14);
		contentPane_1.add(lblid);
		
		JButton btnNewButton = new JButton("Order History");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderHistory OrderHistory = new OrderHistory();
				OrderHistory.setVisible(true);
				Profile.this.dispose();
			}
		});
		btnNewButton.setBounds(-4, 228, 132, 23);
		contentPane_1.add(btnNewButton);
	}
}
