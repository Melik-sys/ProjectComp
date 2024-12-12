package app;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CustomTools {
	public static JLabel loadImage(String resource) {
		BufferedImage image;
		try {
			InputStream inputStream = CustomTools.class.getResourceAsStream(resource);
			image = ImageIO.read(inputStream);
			return new JLabel(new ImageIcon(image));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		return null;
	}
	
	public static Font createFont(String resource) {
		String filePath = resource;

		try {
			File customFontFile = new File(filePath);
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, customFontFile);
			return customFont;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
}
