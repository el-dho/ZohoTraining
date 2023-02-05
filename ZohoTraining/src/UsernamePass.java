import java.util.*;
public class UsernamePass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] User, Pass;
		String request;
		User = new String[]{ "Ardra", "Eldho", "Bharath" };
		Pass = new String[]{ "njn shoopera", "abcdefg", "BoomBoom" };
		System.out.print("Enter Username to Display Password:");
		request = sc.nextLine();
		for(int i=0;i<User.length;i++) {
			if(Objects.equals(User[i], request)) {
				System.out.println(Pass[i]);
			}
		}
	}	
}