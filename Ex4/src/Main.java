import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> urls = new HashMap<>();
		while(true) {
			String url = sc.next();
			if(url.equals("exit")) {
				sc.close();
				break;
			}
			
			else if(!urls.containsKey(url))
				urls.put(url, 1);
			else
				urls.put(url, urls.get(url)+1);
			
			for(Map.Entry<String, Integer> entry : urls.entrySet())
				System.out.println(entry.getKey() + " ## " + entry.getValue());
		}
	}
}