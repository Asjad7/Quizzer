package view;

import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.quiz;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class InstructorScreen extends javax.swing.JFrame {

	private JFrame frame;
	private JTextField quizname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorScreen window = new InstructorScreen();
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
	public InstructorScreen() {
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
		
		quizname = new JTextField();
		quizname.setText("Quiz Name");
		quizname.setBounds(10, 56, 166, 20);
		frame.getContentPane().add(quizname);
		quizname.setColumns(10);
		
		JFormattedTextField quizdescription = new JFormattedTextField();
		quizdescription.setText("Quiz Description");
		quizdescription.setBounds(10, 87, 166, 72);
		frame.getContentPane().add(quizdescription);
		
		JLabel lblGenerateQuiz = new JLabel("Generate Quiz");
		lblGenerateQuiz.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblGenerateQuiz.setBounds(134, 11, 129, 28);
		frame.getContentPane().add(lblGenerateQuiz);
		
		JButton btnCreateQuiz = new JButton("Create Quiz");
		btnCreateQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quiz quiznew=new quiz(quizname.getText(),quizdescription.getText());
				QuizCreationScreen scr=new QuizCreationScreen(quiznew);
			   
			    InstructorScreen.this.dispose();
			    scr.setVisible(true);
			    
			}
		});
		btnCreateQuiz.setBounds(174, 180, 89, 23);
		frame.getContentPane().add(btnCreateQuiz);
		
	
	}
}
