package custom;

import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;

public class PasswordFieldCustom extends JPasswordField {
	private String placeholderText;
	private boolean hasPlaceHolder;
	
	public PasswordFieldCustom(String placeholderText, int charLimit) {
		super();
		this.placeholderText = placeholderText;
		
		hasPlaceHolder = true;
		setDocument(new LimitText(charLimit));
		setText(this.placeholderText);
		
		setEchoChar((char) 0);
		setMargin(new Insets(0,10,0,0));
		
		addListeners();
	}
	private void addListeners() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (hasPlaceHolder) {
					hasPlaceHolder = false;
					setText("");
					setEchoChar('*');
				}
			}
		});
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (hasPlaceHolder) {
					hasPlaceHolder = false;
					setText("");
					setEchoChar('*');
				}
			}
		});
		addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(getText().toString().length() <=0) {
					hasPlaceHolder = true;
					setText(placeholderText);
					setEchoChar((char) 0);
				}
			}
			
		});
	}

	public boolean isHasPlaceHolder() {
		return hasPlaceHolder;
	}

}
