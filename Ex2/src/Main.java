import java.util.*;
public class Main{
	public static void main(String[] args){
		Browser tabOne = new GoogleChrome();
		Browser tabTwo = new Firefox();
		Browser tabThree = new Firefox();
		Browser tabFour = new GoogleChrome();
		Browser tabFive = new GoogleChrome();
		Browser tabSix = new Browser();
		tabSix.whoAmI();
		tabTwo.whoAmI();
		tabFive.whoAmI();
		Browser[] allBrowsers = {tabOne,tabTwo,tabThree,tabFour,tabFive,tabSix};
		int chromeTabs = GoogleChrome.instanceOfChrome(allBrowsers);
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

class Browser implements MultipleAccountContainers{
	
	private static String[] containersPresent = new String[0];

	Browser() {
		
	}
	
	public void whoAmI() {
		System.out.println("I am a browser");
	}
	
	public void addContainer(String container) {
		int lenContainer = Browser.containersPresent.length;
		String[] newContainers = new String[lenContainer+1];
		for(int i = 0;i<lenContainer;i++) {
			newContainers[i] = Browser.containersPresent[i];
		}
		newContainers[lenContainer] = container;
		Browser.containersPresent = newContainers;
	}

	public void leaveContainer(String container) {
		int lenContainer = Browser.containersPresent.length;
		String[] newContainers = new String[lenContainer - 1];
		for(int i = 0,j =0; i<lenContainer;i++) {
			if(!Objects.equals(Browser.containersPresent[i],container)) {
				newContainers[j] = Browser.containersPresent[i];
				j++;
			}
		}
		Browser.containersPresent = newContainers;
	}

	public String[] viewAllContainers() {
		return containersPresent;
	}
	
}

class GoogleChrome extends Browser {
	private boolean isLocationAccessible, isCameraAccessible, isMicrophoneAccessible;
	static final float versionNumber;
	static {
		versionNumber = 1.0f;
	}
	GoogleChrome() {
	}
	
	@Override
	public void whoAmI() {
		System.out.println("I am Google Chrome");
	}
	
	public void setPermissions() {
		isLocationAccessible = false;
		isCameraAccessible = false;
		isMicrophoneAccessible = false;
	}
	
	public void setLocationAccessible(boolean isLocationAccessible) {
		this.isLocationAccessible = isLocationAccessible;
	}

	public void setCameraAccessible(boolean isCameraAccessible) {
		this.isCameraAccessible = isCameraAccessible;
	}

	public void setMicrophoneAccessible(boolean isMicrophoneAccessible) {
		this.isMicrophoneAccessible = isMicrophoneAccessible;
	}

	public void setPermissions(boolean isLocationAccessible, boolean isCameraAccessible, boolean isMicophoneAccessible) {
		this.isLocationAccessible = isLocationAccessible;
		this.isCameraAccessible = isCameraAccessible;
		this.isMicrophoneAccessible = isMicophoneAccessible;
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
}

class Firefox extends Browser {
	
	
	Firefox() {
	}
	
	@Override
	public void whoAmI() {
		System.out.println("I am Firefox");
	}

}

interface MultipleAccountContainers {
	void addContainer(String container);
	void leaveContainer(String container);
}