import java.util.Scanner;
public class GoogleChrome extends Browser {
	
	Scanner ip = new Scanner(System.in);
	
	private boolean isLocationAccessible, isCameraAccessible, isMicrophoneAccessible;
	
	static final float VERSION_NUMBER;
	
	static {
		VERSION_NUMBER = 1.0f;
	}
	
	GoogleChrome() {
		//Empty Constructor
	}
	
	@Override
	public void whoAmI() {
		System.out.println("I am Google Chrome");
	}
	
	public void setPermissions() {
		setLocationAccessible(false);
		isCameraAccessible = false;
		isMicrophoneAccessible = false;
	}
	
	public void setPermissions(boolean access) {
		System.out.print("1. Set Location Access\n2. Set Camera Access\n3. Set Microphone Access");
		int set = ip.nextInt();
		switch(set) {
			case 1: setLocationAccessible(access);
					break;
			case 2: isCameraAccessible = access;
					break;
			case 3: isMicrophoneAccessible = access;
					break;
			default: System.out.println("Error");
		}
			
	}

	public void setPermissions(boolean isLocationAccessible, boolean isCameraAccessible, boolean isMicophoneAccessible) {
		this.setLocationAccessible(isLocationAccessible);
		this.isCameraAccessible = isCameraAccessible;
		this.isMicrophoneAccessible = isMicophoneAccessible;
	}

	public boolean isLocationAccessible() {
		return isLocationAccessible;
	}

	public void setLocationAccessible(boolean isLocationAccessible) {
		this.isLocationAccessible = isLocationAccessible;
	}
}
