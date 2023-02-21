
public class Abstract {
	public static void main(String[] args) {
		Comp obj = new CompA();
		obj.printMethod();
		obj = new CompB();
		obj.printMethod();
		Comp obj1 = new Comp();
	}
}

abstract class Comp{
	abstract void printMethod();
}

class CompA extends Comp{
	void printMethod() {
		System.out.println("This is Company A");
	}
}

class CompB extends Comp{
	void printMethod() {
		System.out.println("This is Company B");
	}
}