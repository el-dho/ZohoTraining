
public class InstanceOf {
	public static void main(String[] args) {
		Fruits f = new Orange();
		Orange.method(f);
	}
}

class Fruits{
	
}

class Orange extends Fruits{
	static void method(Fruits f) {
		if(f instanceof Orange) {
			Orange o = (Orange)f;
			System.out.println("Downcasting done");
		}
	}
}