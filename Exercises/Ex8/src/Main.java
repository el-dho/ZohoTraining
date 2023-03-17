import hack.Hacker;

public class Main {
	public static void main(String[] args) {
		final String FILE_LOCATION = "History.txt";
		Browser objB = new Browser();
		objB.visit("www.google.com");
		objB.visit("www.zoho.com");
		objB.visit("www.facebook.com");
		objB.visit("www.cliq.com");
		System.out.println(objB.getHistory());
		objB.createFile(FILE_LOCATION);
		
		Hacker hack = new Hacker();
		hack.readFile(FILE_LOCATION);
		objB.setHistory(hack.getModifiedHistory());
		
		System.out.println(objB.getHistory());
	}
}
