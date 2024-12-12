package app;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class UserDB {
	public static HashMap<String,String> userDB = new HashMap<>();
	public static HashMap<String,String> userID = new HashMap<>();

	public static void readUser() {
		try {
			
			Scanner scanner = new Scanner(new File(CommonConstants.USER_INFO_TEXT_PATH));
			scanner.nextLine();
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				String[] string = s.split(",");
				userDB.put(string[0], string[1]);
				userID.put(string[1], string[2]);
				
				//System.out.println(string[0] + " " +  string[1]);
			}
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(userDB);
	}
	
	public static void addUser(String username, String password, String ID) {

		userDB.put(username, password);
		
		try {
			FileWriter writer = new FileWriter(CommonConstants.USER_INFO_TEXT_PATH, true);
			writer.write("\n" + username + "," + password + "," + ID);
		
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void addUserInfo(String username, String password) {
		
	}

}
