
public class Browser {
	
	Browser() {
		//Empty Constructor
	}
	
	public void whoAmI() {
		System.out.println("I am a browser");
	}
	
	static int instanceOfChrome(Browser[] allBrowsers) {
		int chromeTabs = 0;
		for(Browser tab : allBrowsers) {
			if(tab instanceof GoogleChrome) {
				chromeTabs++;
			}
		}
		return chromeTabs;
	}
	
	public void addContainer(String container) {
		//Method made to call browser.addContainer
 }
	
	public void leaveContainer(String container) {
		//Method made to call browser.leaveContainer
	}
	
	public String[] viewAllContainers() {
		return new String[0];
	}
}
