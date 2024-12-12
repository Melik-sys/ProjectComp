package app;

import javax.swing.SwingUtilities;

public class App {
	public static void main(String[] args) {
		UserDB.readUser();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				new LoginGUI().setVisible(true);
				//new RegisterGUI().setVisible(true);
			}
			
		});
	}

}
