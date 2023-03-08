import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Homepage:");
		String homepage = sc.next();
		String command=null;
		String url=null;
		BrowserHistory obj = new BrowserHistory(homepage);
		while(true) {
			System.out.println("1. Visit Url");
			System.out.println("2. Go Back");
			System.out.println("3. Go Forward");
			System.out.println("4. Get Url");
			
			command = sc.next();
			
			if(command.equals("1")) {
				System.out.println("Enter URL to visit:");
				url = sc.next();
				obj.visit(url);
			}
			
			else if(command.equals("2")) {
				System.out.println("Enter steps to go back:");
				int stepsBack = sc.nextInt();
				try {
					System.out.println(obj.back(stepsBack));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(command.equals("3")) {
				System.out.println("Enter steps to go forward:");
				int stepsForward = sc.nextInt();
				try {
					System.out.println(obj.forward(stepsForward));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(command.equals("4")) {
				System.out.println("Enter Position to get URL:");
				int position = sc.nextInt();
				try {
					System.out.println(obj.get(position));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(command.equals("exit")) {
				System.out.println("Bye");
				break;
			}
			else
				System.out.println("Invalid Input");
		}
	}
}
