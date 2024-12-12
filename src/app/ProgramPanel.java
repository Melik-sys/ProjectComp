package app;

import java.awt.BorderLayout;

import java.awt.Font;

import javax.swing.JFrame;

public class ProgramPanel extends JFrame{
	private UserDetails userDetails;
	private Font customFont;
	public ProgramPanel(String username, String ID) {
		super("Traveler");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		customFont = CustomTools.createFont(CommonConstants.FONT_PATH);
		getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);
		
		customFont = CustomTools.createFont(CommonConstants.FONT_PATH);
		userDetails = new UserDetails(username, ID);
		
		
		
		getContentPane().add(userDetails, BorderLayout.WEST);
		
		
		//addGuiComponent();
		
	}
}
