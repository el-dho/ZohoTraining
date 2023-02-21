import java.util.*;
public class Main {
	public static void main(String[] args){
		Browser tabOne = new GoogleChrome();
		Browser tabTwo = new Firefox();
		Browser tabThree = new Firefox();
		Browser tabFour = new GoogleChrome();
		Browser tabFive = new GoogleChrome();
		Browser tabSix = new Browser();
		tabOne.whoAmI();
		tabTwo.whoAmI();
		tabFive.whoAmI();
		tabSix.whoAmI();
		Browser[] allBrowsers = {tabOne,tabTwo,tabThree,tabFour,tabFive,tabSix};
		int chromeTabs = Browser.instanceOfChrome(allBrowsers);
		System.out.println("No. of Google Chrome tabs: " + chromeTabs);
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