
public class Main {
	public static void main(String[] args) {
		Browser obj = new Browser();
		obj.setTabs(5);
		Integer tabMain = obj.getTabs(); //auto boxing
		System.out.println("After Auto Boxing : " + tabMain);
		obj.setTabInt(9);
		int tabIntMain = obj.getTabInt(); //unboxing
		System.out.println("After unboxing : " + tabIntMain);
	}
}

class Browser {
	private int tabs;
	private Integer tabInt;

	public Integer getTabInt() {
		return tabInt;
	}

	public void setTabInt(Integer tabInt) {
		this.tabInt = tabInt;
	}

	public int getTabs() {
		return tabs;
	}

	public void setTabs(int tabs) {
		this.tabs = tabs;
	}
	
}
