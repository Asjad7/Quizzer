package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.userhandlingadd;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterScreen {

	private JFrame frame;
	private JTextField usertext;
	private JTextField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterScreen window = new RegisterScreen();
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
	public RegisterScreen() {
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
		
		JLabel lblRegisterUser = new JLabel("Register User");
		lblRegisterUser.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblRegisterUser.setBounds(156, 11, 163, 27);
		frame.getContentPane().add(lblRegisterUser);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 70, 91, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 107, 66, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(10, 140, 46, 14);
		frame.getContentPane().add(lblRole);
		
		usertext = new JTextField();
		usertext.setBounds(132, 67, 86, 20);
		frame.getContentPane().add(usertext);
		usertext.setColumns(10);
		
		passwordtext = new JTextField();
		passwordtext.setBounds(132, 104, 86, 20);
		frame.getContentPane().add(passwordtext);
		passwordtext.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 137, 86, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(("Instructor".equals(comboBox.getSelectedItem()))||("instructor".equals(comboBox.getSelectedItem()))){
			            userhandlingadd.addRecordInstructor((String)usertext.getText(),(String)passwordtext.getText(),"Instructor");
			            JOptionPane.showMessageDialog(null,"Instructor added successfully!");
			        }
			        else if(("Student".equals(comboBox.getSelectedItem()))||("student".equals(comboBox.getSelectedItem()))){
			            userhandlingadd.addRecordStudent((String)usertext.getText(),(String)passwordtext.getText(),"Student", 0);
			            JOptionPane.showMessageDialog(null,"Student added successfully!");
			        }
			}
		});
		btnRegister.setBounds(213, 206, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Instructor"}));
		
		
	}
	

}
