import java.util.*;

public class Browser {
	List<String> history = new ArrayList<>();
	
	public void visit(String url) {
		history.add(url);
	}
	
	public void getHistory() {
		synchronized(this) {
			while(!history.isEmpty()) {
				System.out.println(history.get(0));
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				notifyAll(); 
			}
		}
	}
	
	
	public void deleteHistory() {
		synchronized(this) {
			while(!history.isEmpty()) {	
			
				System.out.println(history.get(0) + " removed");
				history.remove(0);
				notifyAll();
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
		}
	}
	
	
	public void getHistoryUrl() {
		System.out.println(history);
	}
}
