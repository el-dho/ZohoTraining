
public class Browser {
	class Bookmarks {					//member inner class
		public void display() {
			System.out.println("Inside Bookmarks Class");
		}
	}
	
	class Shortcuts {
		public void display() {
			System.out.println("Inside Shortcuts Class");
		}
	}
	
	static class History {									//nested static class
		public void display() {
			System.out.println("Inside History Class");
		}
	}
}

class Main {
	public static void main(String[] args) {
		Browser brow = new Browser();
		Browser.Bookmarks book = brow.new Bookmarks();
		book.display();
		
		Browser.Shortcuts shorts = brow.new Shortcuts() {
			@Override
			public void display() {
				System.out.println("Inside Anonymous Class");	//Anonymous Inner Class
			}
		};
		shorts.display();
		
		Browser.History hist = new Browser.History();
		hist.display();
		
	}
}
