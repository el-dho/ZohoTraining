import java.util.*;														//util for Scanner and Arrays

class Browser{															//Browser class
	private static String[] url;										//private variable for urls
	Scanner ip = new Scanner(System.in);
		
	Browser(){															//Initial Constructor
		setMethod();													//Initial url
		new Browser(url);												//Second Constructor
	}
	
	Browser(String[] url) {												//Second Constructor
		this.url = url;
		System.out.print("New Session?(true/false): ");					//Ask for second session
		boolean newSession = ip.nextBoolean();
		if(newSession == true) {
			this.url = setMethod(this.url);								//Update url
			new Browser(this.url);										//run Second Constructor
		}
		else {
			System.out.println("The URLs in the history are: " + Arrays.toString(this.url));					//print if  no update
		}
	}

	String[] setMethod() {												//method for initialization
		System.out.print("Enter the number of URLs: ");
		int n = ip.nextInt();
		System.out.println("Enter the URLs: ");
		url = new String[n];
		for(int i=0; i<n; i++) {
			url[i] = ip.next();
		}
		return url;
	
	}
	
	String[] setMethod(String[] url) {									//method for updation
		System.out.print("Enter the number of URLs to add: ");
		int n = ip.nextInt();
		int totalURLs = n + url.length;
		String[] newURL = new String[totalURLs];
		System.arraycopy(url, 0, newURL, 0, url.length);
		System.out.println("Enter the URLs:");
		for (int i = url.length;i<totalURLs;i++) {
			newURL[i]=ip.next();
		}
		return newURL;
	}
	
}

class mainClass{														//Main Class
	public static void main(String[] args) {							//Main Method
		new Browser();													//Call constructor for initialize
	}
}