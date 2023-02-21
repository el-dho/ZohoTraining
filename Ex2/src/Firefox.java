import java.util.Objects;

public class Firefox extends Browser implements MultipleAccountContainers {
	
	private String[] containersPresent = new String[0];
	
	Firefox() {
		//Empty Constructor
	}
	
	@Override
	public void whoAmI() {
		System.out.println("I am Firefox");
	}

	@Override
	public void addContainer(String container) {
		int lenContainer = containersPresent.length;
		String[] newContainers = new String[lenContainer+1];
		for(int i = 0;i<lenContainer;i++) {
			newContainers[i] = containersPresent[i];
		}
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
	
	public String[] viewAllContainers() {
		return containersPresent;
	}
}
