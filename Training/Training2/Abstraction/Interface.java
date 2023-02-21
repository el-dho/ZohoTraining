
public class Interface {
	public static void main(String[] args) {
		CompanyXYZ comp;
		comp = new Nike();
		comp.getName();
		comp = new Puma();
		comp.getName();
		comp = new CompanyXYZ();
	}
}

interface CompanyXYZ{
	void getName();
	}

class Nike implements CompanyXYZ{
	public void getName() {
		System.out.println("This class is Nike");
	}
}

class Puma implements CompanyXYZ{
	public void getName() {
		System.out.println("This class is Puma");
	}
}