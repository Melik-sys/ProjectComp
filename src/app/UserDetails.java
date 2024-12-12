package app;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserDetails extends JPanel {
	private Font customFont;
	public UserDetails(String username, String ID) {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		customFont = CustomTools.createFont(CommonConstants.FONT_PATH);
		setBackground(CommonConstants.SECONDARY);
		setBorder(BorderFactory.createTitledBorder("Personal Details"));
		
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setFont(customFont.deriveFont(32f));
		
		JLabel user = new JLabel(username);
		user.setFont(customFont.deriveFont(32f));
		
		JLabel IDLabel = new JLabel("ID: ");
		IDLabel.setFont(customFont.deriveFont(32f));
		
		JLabel id = new JLabel(ID);
		id.setFont(customFont.deriveFont(32f));
		
		setLayout(new GridBagLayout());
		
		
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(usernameLabel, gc );
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(user, gc);
		
		gc.weighty = 10;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 0;
		gc.gridy = 1;
		add(IDLabel, gc);
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 1;	
		add(id, gc);
		
		
		
		
	}
}
