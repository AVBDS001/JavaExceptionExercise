package application;

public class Menu {
	
	public static void mainMenu() {
		System.out.println("1-Register client account");
		System.out.println("2-Make a deposit");
		System.out.println("3-Make a withdraw");
		System.out.println("4-Check account data");
		System.out.println("5-EXIT");
		System.out.print("Enter one option: ");
	}
	
	
	public static int generateIDNumber() {
		return (int)(Math.random() * 99999 + 1);
	}
	
	public static String generateCode(int length) {
		String alphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwyxz0123456789";
		StringBuilder stringBuilder = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			int charactere = (int)(alphaNumericStr.length() * Math.random());
			stringBuilder.append(alphaNumericStr.charAt(charactere));
		}
		return stringBuilder.toString();
	}
}
