import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.Controller;
import view.Iview;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register implements Iview.Register{

	public JFrame frame;
	private JTextField name;
	private JTextField email;
	private JPasswordField password;


	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 520, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.CYAN);
		lblName.setBounds(223, 51, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.CYAN);
		lblEmail.setBounds(223, 108, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.CYAN);
		lblPassword.setBounds(197, 175, 96, 15);
		frame.getContentPane().add(lblPassword);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller cl = new Controller();
				cl.setRview(new Register());
				cl.onRegister(name.getText(), email.getText(),password.getText());
			}
		});
		btnRegister.setBounds(346, 224, 117, 25);
		frame.getContentPane().add(btnRegister);
		
		name = new JTextField();
		name.setBounds(310, 49, 184, 30);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(310, 106, 184, 30);
		frame.getContentPane().add(email);
		
		password = new JPasswordField();
		password.setBounds(311, 173, 183, 25);
		frame.getContentPane().add(password);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 31));
		lblRegister.setForeground(Color.ORANGE);
		lblRegister.setBounds(28, 81, 146, 155);
		frame.getContentPane().add(lblRegister);
	}

	@Override
	public void onRegistrationSuccess(String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void onRegistrationFailure(String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message,"warning",JOptionPane.WARNING_MESSAGE);
	}

}
