package view;

import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import model.quiz;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuizCreationScreen extends JFrame{
	
	static public quiz q;

	public JFrame frame;
	private JTextField o1text;
	private JTextField o2text;
	private JTextField o3text;
	private JTextField o4text;
	private JTextField expectedtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizCreationScreen window = new QuizCreationScreen(q);
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
	public QuizCreationScreen(quiz a) {
		q=a;
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
		
		JLabel lblCreateQuestions = new JLabel("Create Questions");
		lblCreateQuestions.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblCreateQuestions.setBounds(147, 11, 160, 28);
		frame.getContentPane().add(lblCreateQuestions);
		
		JComboBox typebox = new JComboBox();
		typebox.setBounds(10, 44, 183, 20);
		frame.getContentPane().add(typebox);
		
		JButton Selectbtn = new JButton("Select");
		
		Selectbtn.setBounds(238, 41, 89, 23);
		frame.getContentPane().add(Selectbtn);
		
		
		
		typebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MCQ", "True/False", "Numeric" }));
		
		JTextPane Questiontxt = new JTextPane();
		Questiontxt.setText("Enter Question");
		Questiontxt.setBounds(10, 86, 317, 48);
		frame.getContentPane().add(Questiontxt);
		
		o1text = new JTextField();
		o1text.setText("Option 1");
		o1text.setBounds(10, 145, 86, 20);
		frame.getContentPane().add(o1text);
		o1text.setColumns(10);
		
		o2text = new JTextField();
		o2text.setText("Option 2");
		o2text.setBounds(147, 145, 86, 20);
		frame.getContentPane().add(o2text);
		o2text.setColumns(10);
		
		o3text = new JTextField();
		o3text.setText("Option 3");
		o3text.setBounds(10, 176, 86, 20);
		frame.getContentPane().add(o3text);
		o3text.setColumns(10);
		
		o4text = new JTextField();
		o4text.setText("Option 4");
		o4text.setBounds(147, 176, 86, 20);
		frame.getContentPane().add(o4text);
		o4text.setColumns(10);
		
		JButton Createbtn = new JButton("Create Question");
		Createbtn.setBounds(173, 216, 177, 23);
		frame.getContentPane().add(Createbtn);
		
		expectedtext = new JTextField();
		expectedtext.setText("Expected Answer");
		expectedtext.setBounds(270, 145, 116, 51);
		frame.getContentPane().add(expectedtext);
		expectedtext.setColumns(10);
		
		Questiontxt.setVisible(false);
		o1text.setVisible(false);
		o2text.setVisible(false);
		o3text.setVisible(false);
		o4text.setVisible(false);
		Createbtn.setVisible(false);
		expectedtext.setVisible(false);
		
		Selectbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if("MCQ".equals((String)typebox.getSelectedItem())){
					
					Questiontxt.setVisible(true);
					o1text.setVisible(true);
					o2text.setVisible(true);
					o3text.setVisible(true);
					o4text.setVisible(true);
					Createbtn.setVisible(true);
					expectedtext.setVisible(true);
					
					Createbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							q.addquestion(Questiontxt.getText(), 1, o1text.getText(), o2text.getText(),
									o3text.getText(), o4text.getText(), expectedtext.getText());
							JOptionPane.showMessageDialog(null, "Question Added");
							Questiontxt.setText("");
							o1text.setText("");
							o2text.setText("");
							o3text.setText("");
							o4text.setText("");
							expectedtext.setText("");
							
						}
					});
		            
		        }
				
				
		        else if("True/False".equals((String)typebox.getSelectedItem())){
		        	
		        	Questiontxt.setVisible(true);
					o1text.setVisible(true);
					o2text.setVisible(true);
					Createbtn.setVisible(true);
					o1text.setText("True");
					o2text.setText("False");
					o3text.setVisible(false);
					o4text.setVisible(false);
					expectedtext.setVisible(true);
					
					Createbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							q.addquestiontf(Questiontxt.getText(), 1, o1text.getText(), o2text.getText(), expectedtext.getText());
							JOptionPane.showMessageDialog(null, "Question Added");
							Questiontxt.setText("");
							o1text.setText("");
							o2text.setText("");
							o3text.setText("");
							o4text.setText("");
							expectedtext.setText("");
							
						}
					});
		        }
				
				
		        else if("Numeric".equals((String)typebox.getSelectedItem())){
		        	
		        	Questiontxt.setVisible(true);
					o1text.setVisible(false);
					Createbtn.setVisible(true);
					o3text.setVisible(false);
					o4text.setVisible(false);
					o2text.setVisible(false);
					expectedtext.setVisible(true);
					Createbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							q.addquestionnumeric(Questiontxt.getText(), 1, o1text.getText(),expectedtext.getText());
							JOptionPane.showMessageDialog(null, "Question Added");
							Questiontxt.setText("");
							o1text.setText("");
							o2text.setText("");
							o3text.setText("");
							o4text.setText("");
							expectedtext.setText("");
							
						}
					});
		        
		        }
			}
		});
		
		
		
	}
}
