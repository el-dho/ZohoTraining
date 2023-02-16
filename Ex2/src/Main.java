public class Main{
	public static void main(String[] args){
		Browser tabOne = new GoogleChrome();
		Browser tabTwo = new Firefox();
		Browser tabThree = new Firefox();
		Browser tabFour = new GoogleChrome();
		Browser tabFive = new GoogleChrome();
		Browser[] allBrowsers = new Browser[5];
		allBrowsers[0] = tabOne;
		allBrowsers[1] = tabTwo;
		allBrowsers[2] = tabThree;
		allBrowsers[3] = tabFour;
		allBrowsers[4] = tabFive;
		int chromeTabs = Browser.instanceOfChrome(allBrowsers);
		System.out.println("No. of Google Chrome tabs: " + chromeTabs);
	}
}

class Browser {
	Browser() {
		
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
}

class GoogleChrome extends Browser {
	private boolean isLocationAccessible, isCameraAccessible, isMicrophoneAccessible;
	static final float versionNumber;
	static {
		versionNumber = 1.0f;
	}
	GoogleChrome() {
		//super();
	}
	
	@Override
	public void whoAmI() {
		System.out.println("I am Google Chrome");
	}
	
	public void setPermissions() {
		
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
}

class Firefox extends Browser {
	Firefox() {
		//super();
	}
	
	@Override
	public void whoAmI() {
		System.out.println("I am Firefox");
	}
}
