import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

import controller.Controller;
import view.Iview;

public class Login implements view.Iview.Login{

	private JFrame frame;
	private JTextField email;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("OptionPane.errorDialog.titlePane.foreground"));
		frame.setBounds(100, 100, 584, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setForeground(Color.RED);
		lblLogin.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 28));
		lblLogin.setBounds(34, 24, 112, 210);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("email");
		lblUsername.setForeground(Color.CYAN);
		lblUsername.setBounds(195, 128, 103, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(Color.CYAN);
		lblPassword.setBounds(195, 189, 103, 15);
		frame.getContentPane().add(lblPassword);
		
		email = new JTextField();
		email.setBounds(316, 126, 216, 31);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(316, 187, 216, 31);
		frame.getContentPane().add(pass);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller cl = new Controller();
				cl.setLview(new Login());
				cl.onLogin(email.getText(), pass.getText());
				
			}
		});
		btnLogin.setBounds(415, 254, 117, 25);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblregister = new JLabel("go to registration");
		lblregister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register rg = new Register();
				frame.setVisible(false);
				rg.frame.setVisible(true);
			}
		});
		lblregister.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblregister.setForeground(new Color(0, 255, 0));
		lblregister.setBounds(339, 287, 156, 15);
		frame.getContentPane().add(lblregister);
	}

	@Override
	public void onLoginSuccess(String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void onLoginFailure(String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message,"warning",JOptionPane.WARNING_MESSAGE);
	}
}

