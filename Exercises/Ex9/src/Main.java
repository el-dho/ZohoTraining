
public class Main {

	public static void main(String[] args) {
			Browser obj = new Browser();
			obj.visit("www.google.com");
			obj.visit("www.zoho.com");
			obj.visit("www.cliq.com");
			obj.visit("www.fast.com");
			obj.getHistoryUrl();
			Thread t1 = new Thread() {
				@Override
				public void run() {
					obj.getHistory();
				}
			};
			
			Thread t2 = new Thread() {
				@Override
				public void run() {
					obj.deleteHistory();
				}
			};

			t1.start();
			t2.start();
			
			try {
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			obj.getHistoryUrl();
	}
}
