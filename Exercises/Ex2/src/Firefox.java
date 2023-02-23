import java.util.*;

public class Firefox extends Browser implements MultipleAccountContainers {
	
	private String[] containersPresent = new String[0];
	
	Firefox() {
		super();
	}
	
	@Override
	public void whoAmI() {
		System.out.println("I am Firefox");
	}

	@Override
	public void addContainer(String container) {
		int lenContainer = containersPresent.length;
		String[] newContainers = new String[lenContainer+1];
		System.arraycopy(containersPresent, 0, newContainers, 0, lenContainer);
		newContainers[lenContainer] = container;
		containersPresent = newContainers;
		
	}

	@Override
	public void leaveContainer(String container) {
		int lenContainer = containersPresent.length;
		String[] newContainers = new String[lenContainer - 1];
		for(int i = 0,j =0; i<lenContainer;i++) {
			if(!Objects.equals(containersPresent[i],container)) {
				newContainers[j] = containersPresent[i];
				j++;
			}
		}
		containersPresent = newContainers;
	}
	
	@Override
	public String[] viewAllContainers() {
		return containersPresent;
	}
}
