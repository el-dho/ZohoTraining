import java.util.Objects;

public class Firefox extends Browser implements MultipleAccountContainers {
	
	private String[] containersPresent = new String[0];
	
	Firefox() {
		super();
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
			if(containersPresent[i]!=container) {
				newContainers[i] = containersPresent[i];
			}
			else {
				System.out.println("Error: Container Already Present");
			}
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
			else {
				System.out.println("Error: Container " + container + " not found");
			}
		}
		containersPresent = newContainers;
	}
	
	@Override
	public String[] viewAllContainers() {
		return containersPresent;
	}
}
