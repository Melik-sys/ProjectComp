package app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import custom.PasswordFieldCustom;
import custom.TextFieldCustom;

public class LoginGUI extends JFrame implements ActionListener{
	private TextFieldCustom usernameField;
	private PasswordFieldCustom passwordField;
	private Font customFont;
	public LoginGUI() {
		super("Traveler Login");
		setSize(CommonConstants.FRAME_SIZE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);
		
		customFont = CustomTools.createFont(CommonConstants.FONT_PATH);
		
		addGuiComponent();
	}

	private void addGuiComponent() {
		JLabel loginImage = CustomTools.loadImage(CommonConstants.LOGIN_IMAGE_PATH);
		loginImage.setBounds(
				0,
				0, 
				CommonConstants.LOGIN_IMAGE_SIZE.width, 514
				);
		usernameField = new TextFieldCustom("Enter Username", 30);
		usernameField.setFont(customFont.deriveFont(32f));
		usernameField.setBackground(CommonConstants.SECONDARY);
		usernameField.setForeground(Color.WHITE);
		usernameField.setBounds(
				270,
				loginImage.getY() + 160,
				CommonConstants.TEXTFIELD_SIZE.width, CommonConstants.TEXTFIELD_SIZE.height
				);
		
		passwordField = new PasswordFieldCustom("Enter Password", 30);
		passwordField.setFont(customFont.deriveFont(32f));
		passwordField.setBackground(CommonConstants.SECONDARY);
		passwordField.setForeground(Color.WHITE);
		passwordField.setBounds(
				270,
				usernameField.getY() + 60,
				CommonConstants.TEXTFIELD_SIZE.width, CommonConstants.TEXTFIELD_SIZE.height
				);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(customFont.deriveFont(32f));
		loginButton.setBackground(CommonConstants.BUTTON_COLOR);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBounds(
				360,
				passwordField.getY() + 60,
				CommonConstants.TEXTFIELD_SIZE.width/2, CommonConstants.TEXTFIELD_SIZE.height
				);
		loginButton.addActionListener(this);
		JLabel registerLabel = new JLabel("Not registered! Click Here!    ");
		registerLabel.setFont(customFont.deriveFont(32f));
		registerLabel.setForeground(CommonConstants.SECONDARY);
		
		registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerLabel.setBounds(
				330,
				loginButton.getY() + 30,
				registerLabel.getPreferredSize().width,registerLabel.getPreferredSize().height
				);
		registerLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new RegisterGUI().setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				registerLabel.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				registerLabel.setForeground(CommonConstants.SECONDARY);
			}
		}
				
				
				);
		
		getContentPane().add(usernameField);
		getContentPane().add(passwordField);
		getContentPane().add(loginButton);
		getContentPane().add(registerLabel);
		getContentPane().add(loginImage);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equalsIgnoreCase("Login")) {
			JDialog resultDialog = new JDialog();
			
			resultDialog.setPreferredSize(CommonConstants.RESULT_DIALOG_SIZE);
			resultDialog.pack();
			resultDialog.setLocationRelativeTo(this);
			resultDialog.setModal(true);
			resultDialog.getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);
			
			JLabel resultLabel = new JLabel();
			resultLabel.setFont(customFont.deriveFont(26f));
			resultLabel.setForeground(CommonConstants.SECONDARY);
			resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
			resultDialog.add(resultLabel);
			
			String username = usernameField.getText();
			String password = passwordField.getText();
			
			if(UserDB.userDB.get(username) != null) {
				String validPass = UserDB.userDB.get(username);
				if(password.equals(validPass)) {
					String ID = UserDB.userID.get(password);
					resultLabel.setText("Login Succesful!");
					resultDialog.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							dispose();
							new ProgramPanel(username, ID).setVisible(true);
						}
					});
					
				}else {
					resultLabel.setText("Invalid Password!");
				}
			}else {
				resultLabel.setText("Invalid Username!");
			}
			resultDialog.setVisible(true);
		}
		
	}
}
