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
					int pos = index + temp.length() + 4;
					System.out.println(pos);
					char num = str.charAt(pos);
					System.out.println(num);
					String numStr = String.valueOf(num);
					System.out.println(numStr);
					int number = Integer.parseInt(numStr);
					System.out.println(number);
					String newNum = String.valueOf(++number);
					System.out.println(newNum);
					str.replace(pos, pos+1,newNum);
				}
				System.out.println(str);
				
			}
		}
	}
}
