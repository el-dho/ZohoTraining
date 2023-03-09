
public class Main {

	public static void main(String[] args) {
		BrowserHistory1 obj1 = new BrowserHistory1();
		obj1.visit("www.google.com");
		obj1.visit("www.facebook.com");
		obj1.visit("www.zoho.com");
		obj1.visit("www.india.in");
		obj1.visit("www.levi.us");
		obj1.visit("www.facebook.com");
		obj1.visit("www.india.com");
		obj1.visit("www.zoho.com");
		obj1.fetchHistory();
		System.out.println();
		obj1.search(".us");
		System.out.println();
		obj1.sort();
		System.out.println();
		obj1.size();
		System.out.println();
		obj1.updateHistory(2, "www.poha.com");
		obj1.fetchHistory();
		
		BrowserHistory2 obj2 = new BrowserHistory2();
		obj2.visit("www.cliq.com");
		obj2.visit("www.facebook.com");
		obj2.visit("www.visit.in");
		obj2.visit("www.kick.org");
		obj2.fetchHistory(".in");
		obj2.deleteHistory(".org");
		obj2.fetchHistory(".org");
		System.out.println("Hash Map:");
		System.out.println(obj2.urlHashMap);
		System.out.println("Linked Hash Map:");
		System.out.println(obj2.urlLinkedHashMap);
		System.out.println("Tree Map:");
		System.out.println(obj2.urlTreeMap);
		
	}

}
