import java.util.Scanner;
public class GoogleChrome extends Browser {
	
	Scanner ip = new Scanner(System.in);
	
	private boolean isLocationAccessible;
	private boolean isCameraAccessible;
	private boolean isMicrophoneAccessible;
	
	static final float VERSION_NUMBER;
	
	static {
		VERSION_NUMBER = 1.0f;
	}
	
	GoogleChrome() {
		super();
		System.out.println("This is inside Google Chrome constructor");
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
	
	public void setPermissions(boolean access, Property key) {
		if(key == Property.Location)
			isLocationAccessible = access;
		if(key == Property.Camera)
			isCameraAccessible = access;
		if(key == Property.Microphone)
			isMicrophoneAccessible = access;
	}

	public void setPermissions(boolean isLocationAccessible, boolean isCameraAccessible, boolean isMicophoneAccessible) {
		this.isLocationAccessible = isLocationAccessible;
		this.isCameraAccessible = isCameraAccessible;
		this.isMicrophoneAccessible = isMicophoneAccessible;
	}
	
	public void viewPermissions() {
		System.out.println("Location Accessible : " + isLocationAccessible);
		System.out.println("Camera Accessible : " + isCameraAccessible);
		System.out.println("Microphone Accessible : " + isMicrophoneAccessible);
		System.out.println();
	}
}
