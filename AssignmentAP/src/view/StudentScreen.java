package view;

import java.awt.EventQueue;
import model.quiz;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.quizhandling;

import java.awt.Font;
import java.util.List;
import java.util.ArrayList;

public class StudentScreen extends JFrame {

	public JFrame frame;
	List<quiz> quizzes= new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentScreen window = new StudentScreen();
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
	public StudentScreen() {
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
		
		JLabel lblAttemptQuiz = new JLabel("Attempt Quiz");
		lblAttemptQuiz.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblAttemptQuiz.setBounds(164, 11, 153, 37);
		frame.getContentPane().add(lblAttemptQuiz);
		
		JComboBox quizbox = new JComboBox();
		quizbox.setBounds(10, 71, 307, 20);
		frame.getContentPane().add(quizbox);
		
		JButton attempt = new JButton("Attempt Now");
		attempt.setBounds(10, 122, 117, 23);
		frame.getContentPane().add(attempt);
		
		quizhandling.openFile();
		quizzes=quizhandling.readRecords();
		
		String[] array = new String[quizzes.size()];
		for(int i = 0; i < array.length; i++) {
		    array[i] = quizzes.get(i).toString();
		}
		JComboBox comboBox = new JComboBox(array);
	}

}
