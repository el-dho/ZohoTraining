
public class DemoClass {
	private String name;
	private int ID;
	public boolean present;
	public static String company;
	
	public DemoClass() {
		System.out.println("This is inside the default constructor");
	}
	
	public DemoClass(int num) {
		System.out.println("This is inside the parameterized constructor");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	public static String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		DemoClass.company = company;
	}
	public void disp() {
		System.out.println("This is inside disp method");
	}
	public DemoClass(String name, int iD, boolean present) {
		super();
		this.name = name;
		ID = iD;
		this.present = present;
	}
	
	
}
