import java.util.Scanner;
public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		while(true) {
			String temp = sc.next();
			if(temp.equals("exit")) {
				sc.close();
				break;
			}
			else {
				int index = str.indexOf(temp);
				if(index==-1) {
					str.append(temp + " ## " + 1 + "\n");
				}
				else {
					str.replace(index+temp.length()+4, index+temp.length()+5, String.valueOf(Integer.parseInt(String.valueOf(str.charAt(index+temp.length()+4)))+1));
				}
				System.out.println(str);
				
			}
		}
	}
}
