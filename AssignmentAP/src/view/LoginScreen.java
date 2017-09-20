package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.userhandling;
import model.user;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginScreen extends JFrame{

	private JFrame frame;
	private JTextField usertext;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(10, 120, 65, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 176, 65, 14);
		frame.getContentPane().add(lblPassword);
		
		usertext = new JTextField();
		usertext.setBounds(160, 119, 181, 20);
		frame.getContentPane().add(usertext);
		usertext.setColumns(10);
		
		passwordtext = new JPasswordField();
		passwordtext.setBounds(160, 175, 181, 20);
		frame.getContentPane().add(passwordtext);
		
		JButton Loginbtn = new JButton("Login");
		Loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  String userentered= usertext.getText().toString();
			  String passwordentered=passwordtext.getText().toString();
			  
			  user newuser=userhandling.finduser(usertext.getText(),passwordtext.getText());
			  
			  if(userentered.equals("")) {
				  JOptionPane.showMessageDialog(null, "Please enter Username");
			  }
			  else if(passwordentered.equals("")) {
				  JOptionPane.showMessageDialog(null, "Please enter Password");
			  }
						  
			 
			  else if(newuser.getusername()==null){
		            JOptionPane.showMessageDialog(null, "Incorrect Password or Username");
		        }
		        else if(("Instructor".equals(newuser.getrole()))||"instructor".equals(newuser.getrole())){
		            JOptionPane.showMessageDialog(null,"Login Successful!");
		            InstructorScreen is=new InstructorScreen();
		            is.setVisible(true);
		        }
		        else if(("Student".equals(newuser.getrole()))||"student".equals(newuser.getrole())){
		            JOptionPane.showMessageDialog(null,"Login Successful!");
		            StudentScreen sv=new StudentScreen();
		            sv.setVisible(true);
		        }
			
			}
		});
		Loginbtn.setBackground(Color.LIGHT_GRAY);
		Loginbtn.setForeground(Color.BLACK);
		Loginbtn.setBounds(68, 227, 89, 23);
		frame.getContentPane().add(Loginbtn);
		
		JButton RegisterBtn = new JButton("Register");
		RegisterBtn.setBackground(Color.LIGHT_GRAY);
		RegisterBtn.setForeground(Color.BLACK);
		RegisterBtn.setBounds(252, 227, 89, 23);
		frame.getContentPane().add(RegisterBtn);
		
		JLabel lblQuizManagementSystem = new JLabel("Quiz Management System");
		lblQuizManagementSystem.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
		lblQuizManagementSystem.setBounds(122, 11, 219, 41);
		frame.getContentPane().add(lblQuizManagementSystem);
		
	
	}
}
