package app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import custom.ErrorLabel;
import custom.PasswordFieldCustom;
import custom.TextFieldCustom;

public class RegisterGUI extends JFrame implements ActionListener, FocusListener{
	private ErrorLabel usernameErrorLabel, usernameErrorLabel2, passwordErrorLabel, passwordErrorLabel2, confirmPasswordErrorLabel, IDErrorLabel;
	private TextFieldCustom usernameField, IDField;
	private PasswordFieldCustom passwordField, confirmPasswordField;
	private Font customFont;
	public RegisterGUI() {
		super("Traveler Register");
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
		JLabel registerLabel = new JLabel("Register");
		registerLabel.setFont(customFont.deriveFont(68f));
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setForeground(CommonConstants.SECONDARY);
		registerLabel.setBounds(
				0,
				0,
				CommonConstants.REGISTER_LABEL_SIZE.width, CommonConstants.REGISTER_LABEL_SIZE.height
				);
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
				registerLabel.getY() + 160,
				CommonConstants.TEXTFIELD_SIZE.width, CommonConstants.TEXTFIELD_SIZE.height
				);
		usernameField.addFocusListener(this);
		usernameErrorLabel = new ErrorLabel("*Invalid: Can't be less than 6 characters");
		usernameErrorLabel.setFont(customFont.deriveFont(26f));
		usernameErrorLabel.setBounds(
				270,
				usernameField.getY() + 30,
				CommonConstants.TEXTFIELD_SIZE.width, 25
				);
		usernameErrorLabel2 = new ErrorLabel("*Invalid: There already exists such username");
		usernameErrorLabel2.setFont(customFont.deriveFont(26f));
		usernameErrorLabel2.setBounds(
				270,
				usernameField.getY() + 30,
				CommonConstants.TEXTFIELD_SIZE.width, 25
				);
		
		IDField = new TextFieldCustom("Enter ID", 30);
		IDField.setFont(customFont.deriveFont(32f));
		IDField.setBackground(CommonConstants.SECONDARY);
		IDField.setForeground(Color.WHITE);
		IDField.setBounds(
				270,
				usernameField.getY() + 60,
				CommonConstants.TEXTFIELD_SIZE.width, CommonConstants.TEXTFIELD_SIZE.height
				);
		IDField.addFocusListener(this);
		IDErrorLabel = new ErrorLabel("*Invalid: Please Enter a Valid ID");
		IDErrorLabel.setFont(customFont.deriveFont(26f));
		IDErrorLabel.setBounds(
				270,
				IDField.getY() + 30,
				CommonConstants.TEXTFIELD_SIZE.width, 25
				);
		
		
		passwordField = new PasswordFieldCustom("Enter Password", 30);
		passwordField.setFont(customFont.deriveFont(32f));
		passwordField.setBackground(CommonConstants.SECONDARY);
		passwordField.setForeground(Color.WHITE);
		passwordField.setBounds(
				270,
				IDField.getY() + 60,
				CommonConstants.TEXTFIELD_SIZE.width, CommonConstants.TEXTFIELD_SIZE.height
				);
		passwordField.addFocusListener(this);
		passwordErrorLabel = new ErrorLabel("*Invalid: Size>6, 1 Upper and Lower, 1 #, and 1 Special Char");
		passwordErrorLabel.setFont(customFont.deriveFont(26f));
		passwordErrorLabel.setBounds(
				270,
				passwordField.getY() + 30,
				CommonConstants.TEXTFIELD_SIZE.width, 25
				);
		passwordErrorLabel2 = new ErrorLabel("*Invalid: There already exists such password");
		passwordErrorLabel2.setFont(customFont.deriveFont(26f));
		passwordErrorLabel2.setBounds(
				270,
				passwordField.getY() + 30,
				CommonConstants.TEXTFIELD_SIZE.width, 25
				);

		confirmPasswordField = new PasswordFieldCustom("Confirm Password", 30);
		confirmPasswordField.setFont(customFont.deriveFont(32f));
		confirmPasswordField.setBackground(CommonConstants.SECONDARY);
		confirmPasswordField.setForeground(Color.WHITE);
		confirmPasswordField.setBounds(
				270,
				passwordField.getY() + 60,
				CommonConstants.TEXTFIELD_SIZE.width, CommonConstants.TEXTFIELD_SIZE.height
				);
		confirmPasswordField.addFocusListener(this);
		confirmPasswordErrorLabel = new ErrorLabel("*Invalid: Passwords are not the same");
		confirmPasswordErrorLabel.setFont(customFont.deriveFont(26f));
		confirmPasswordErrorLabel.setBounds(
				270,
				confirmPasswordField.getY() + 30,
				CommonConstants.TEXTFIELD_SIZE.width, 25
				);

		
		JButton registerButton = new JButton("Register");
		registerButton.setFont(customFont.deriveFont(32f));
		registerButton.setBackground(CommonConstants.BUTTON_COLOR);
		registerButton.setForeground(Color.WHITE);
		registerButton.setBounds(
				360,
				confirmPasswordField.getY() + 60,
				CommonConstants.TEXTFIELD_SIZE.width/2, CommonConstants.TEXTFIELD_SIZE.height
				);
		registerButton.addActionListener(this);
		JLabel loginLabel = new JLabel("Already registered? Click here");
		loginLabel.setFont(customFont.deriveFont(32f));
		loginLabel.setForeground(CommonConstants.SECONDARY);
		loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginLabel.setBounds(
				320,
				registerButton.getY() + 30,
				loginLabel.getPreferredSize().width,loginLabel.getPreferredSize().height
				);
		loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new LoginGUI().setVisible(true);
			}
			public void mouseEntered(MouseEvent e) {
				loginLabel.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				loginLabel.setForeground(CommonConstants.SECONDARY);
			}
		});
		getContentPane().add(registerLabel);
		
		getContentPane().add(usernameField);
		getContentPane().add(usernameErrorLabel);
		getContentPane().add(usernameErrorLabel2);
		
		getContentPane().add(IDField);
		getContentPane().add(IDErrorLabel);
		
		getContentPane().add(passwordField);
		getContentPane().add(passwordErrorLabel);
		getContentPane().add(passwordErrorLabel2);
		
		getContentPane().add(confirmPasswordField);
		getContentPane().add(confirmPasswordErrorLabel);
		
		getContentPane().add(registerButton);
		getContentPane().add(loginLabel);
		getContentPane().add(loginImage);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		Object fieldSource = e.getSource();
		if(fieldSource == usernameField) {
			if(usernameField.getText().length() < 6 || usernameField.isHasPlaceHolder()) {
				usernameErrorLabel2.setVisible(false);
				usernameErrorLabel.setVisible(true);
				
			}else if (UserDB.userDB.get(usernameField.getText()) != null){
				usernameErrorLabel.setVisible(false);
				usernameErrorLabel2.setVisible(true);
			}
			else {
				usernameErrorLabel.setVisible(false);
				usernameErrorLabel2.setVisible(false);
			}
		}else if(fieldSource == IDField) {
			String passwordRegex = "^[0-9]{6,30}$";
			Pattern p = Pattern.compile(passwordRegex);
			Matcher m =p.matcher(IDField.getText());
			if(!m.find()) {
				IDErrorLabel.setVisible(true);
			}else {
				IDErrorLabel.setVisible(false);
			}
			
		}else if(fieldSource == passwordField) {
			String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&-+=()<>~'])(?=\\S+$).{6,30}$";
			Pattern p = Pattern.compile(passwordRegex);
			Matcher m =p.matcher(passwordField.getText());
			if(!m.find()) {
				passwordErrorLabel2.setVisible(false);
				passwordErrorLabel.setVisible(true);
			}
			else if(UserDB.userDB.containsValue(passwordField.getText()) != false) {
				passwordErrorLabel.setVisible(false);
				passwordErrorLabel2.setVisible(true);
			}
			else {
				passwordErrorLabel.setVisible(false);
				passwordErrorLabel2.setVisible(false);
			}
		}else if(fieldSource == confirmPasswordField) {
			if(!passwordField.getText().equals(confirmPasswordField.getText())) {
				confirmPasswordErrorLabel.setVisible(true);
			}else {
				confirmPasswordErrorLabel.setVisible(false);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		boolean isValid = false;
		if(command.equals("Register")) {
			isValid = !usernameErrorLabel.isVisible() && !usernameErrorLabel2.isVisible() && !IDErrorLabel.isVisible() && !passwordErrorLabel.isVisible()
			&& !passwordErrorLabel2.isVisible() && !confirmPasswordErrorLabel.isVisible() && !usernameField.isHasPlaceHolder() && !IDField.isHasPlaceHolder()
			&& !passwordField.isHasPlaceHolder() && !confirmPasswordField.isHasPlaceHolder();
		}
		JDialog resultDialog = new JDialog();
		resultDialog.setSize(CommonConstants.RESULT_DIALOG_SIZE);
		resultDialog.setLocationRelativeTo(this);
		resultDialog.setModal(true);
		resultDialog.getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);
		
		JLabel resultLabel = new JLabel();
		resultLabel.setFont(customFont.deriveFont(26f));
		resultLabel.setForeground(CommonConstants.SECONDARY);
		resultLabel.setPreferredSize(CommonConstants.RESULT_DIALOG_SIZE);
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultDialog.add(resultLabel);
		
		if(isValid) {
			String username = usernameField.getText();
			String password = passwordField.getText();
			String ID = IDField.getText();
			UserDB.addUser(username, password, ID);

			resultLabel.setText("Account Created!");
			resultDialog.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
					new LoginGUI().setVisible(true);
				}
			});
		}else {
			resultLabel.setText("Invalid Credentials");
		}
		resultDialog.setVisible(true);
	}
}
