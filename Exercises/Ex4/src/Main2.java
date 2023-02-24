import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Url obj = new Url(sc.next());
		while(true) {
			for(int i=0;i<(obj.getLength());i++)  {
				System.out.println(obj.getUrls(i) + " ## " + obj.getCounts(i));
			}
			String add = sc.next();
			if(add.equals("exit")) {
				sc.close();
				break;
			}
	
			else
				obj.addUrl(add);
		}
		
		
	}
}

class Url {
	private String[] urls = new String[0];
	private int[] counts = new int[0];
	
	public Url(String str) {
		addUrl(str);
	}
	
	public void addUrl(String url) {
		int index = search(url);
		if(index==-1) {
			int urlsLength = urls.length;
			String[] newUrls = new String[urlsLength+1];
			System.arraycopy(urls, 0, newUrls, 0, urlsLength);
			newUrls[newUrls.length-1] = url;
			this.urls = newUrls;
			
			int countLength = counts.length;
			int[] newCounts = new int[countLength + 1];
			System.arraycopy(counts, 0, newCounts, 0, countLength);
			newCounts[newCounts.length-1] = 1;
			this.counts = newCounts;
			
		}
		else {
			++counts[index];
		}
	}
	
	public int search(String url) {
		for(int i = 0; i<urls.length;i++) {
			if(urls[i].equals(url)) {
				return i;
			}
		}
		return -1;
	}
	
	public String getUrls(int i) {
		return urls[i];
	}


	public int getCounts(int i) {
		return counts[i];
	}
	
	public int getLength() {
		return urls.length;
	}
}