package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class CommonConstants {
	public final static Dimension FRAME_SIZE = new Dimension(900,514);
	public final static String FONT_PATH = "CustomFont.ttf";
	public final static String LOGIN_IMAGE_PATH = "login.png";
	public final static String USER_INFO_TEXT_PATH = "UserInfo.txt";
	public final static Color PRIMARY_COLOR = new Color(38,37,70);
	public final static Color SECONDARY = new Color(255,171,63);
	public final static Color BUTTON_COLOR = new Color(207,6,0);
	public final static Dimension LOGIN_IMAGE_SIZE = new Dimension(FRAME_SIZE.width,FRAME_SIZE.height);
	public final static Dimension TEXTFIELD_SIZE = new Dimension((int)(FRAME_SIZE.width * 0.80)/2, 30);
	public final static Dimension RESULT_DIALOG_SIZE = new Dimension((int) FRAME_SIZE.width/3,(int) FRAME_SIZE.height/6);
	public final static Dimension REGISTER_LABEL_SIZE = new Dimension(FRAME_SIZE.width, 200);

}
