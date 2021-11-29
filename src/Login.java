import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	Window window;
	
	JButton btnNewButton,btnNewButton_1;
	JTextField textID;
	JPasswordField textPW;

	/**
	 * Create the panel.
	 */
	public Login() {
		setTitle("LPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 328);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel center = new JPanel();
		getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(58, 58, 329, 138);
		center.add(panel);
		panel.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		buttonPanel.setBounds(36, 86, 247, 42);
		panel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 2, 10, 0));
		
		btnNewButton = new JButton("Guest \uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.condition = Window.GUEST;
				try {
					window = new Window();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.setVisible(true);
				setVisible(false);
			}
		});
		buttonPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(true) {
				if(textID.getText().equals("sys") && textPW.getText().equals("sys") ) {
					Window.condition = Window.ADMIN;
					try {
						window = new Window();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					window.setVisible(true);
					setVisible(false);
				}
				else {
					textID.setText("");
					textPW.setText("");
				}
			}
		});
		buttonPanel.add(btnNewButton_1);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.LIGHT_GRAY);
		labelPanel.setBounds(41, 10, 74, 48);
		panel.add(labelPanel);
		labelPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pass Word");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPanel.add(lblNewLabel_1);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(127, 10, 156, 54);
		panel.add(inputPanel);
		inputPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		textID = new JTextField();
		textID.setText("");
		inputPanel.add(textID);
		textID.setColumns(10);
		
		textPW = new JPasswordField();
		inputPanel.add(textPW);

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
