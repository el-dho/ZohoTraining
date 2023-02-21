import java.util.Arrays;
public class Main {
	
	public static void main(String[] args){

		Browser tabOne = new GoogleChrome();
		Browser tabTwo = new Firefox();
		Browser tabThree = new Firefox();
		Browser tabFour = new GoogleChrome();
		Browser tabFive = new GoogleChrome();
		Browser tabSix = new Browser();

		//3.
		tabOne.whoAmI();
		tabTwo.whoAmI();
		tabFive.whoAmI();
		tabSix.whoAmI();
		System.out.println();
		
		//4.
		GoogleChrome tab = new GoogleChrome();
		tab.setPermissions();
		tab.viewPermissions();
		tab.setPermissions(true);
		tab.viewPermissions();
		tab.setPermissions(true, false, true);
		tab.viewPermissions();
		System.out.println();
		
		
		//6.
		Browser[] allBrowsers = {tabOne,tabTwo,tabThree,tabFour,tabFive,tabSix};
		int chromeTabs = Browser.instanceOfChrome(allBrowsers);
		System.out.println("No. of Google Chrome tabs: " + chromeTabs);
		
		
		//7.
		Browser browser = new Firefox();
		browser.addContainer("facebookContainer");
		browser.addContainer("Mails");
		browser.addContainer("Private Browsing");
		String[] containers = browser.viewAllContainers();
		System.out.println("Containers Present: " + Arrays.toString(containers));
		browser.leaveContainer("facebookContainer");
		containers = browser.viewAllContainers();
		System.out.println("Containers Present: " + Arrays.toString(containers));
	}
}