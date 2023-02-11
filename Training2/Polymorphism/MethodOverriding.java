
public class MethodOverriding {
	public static void main(String[] args) {
		A a = new A();
		a.print();
		a = new B();
		a.print();
		a = new C();
		a.print();
	}
}

class A{
	void print() {
		System.out.println("This is from printMethod of class A");
	}
}

class B extends A{
	void print() {
		System.out.println("This is from printMethod of class B");
	}
}

class C extends A{
	void print() {
		System.out.println("This is from printMethod of class C");
	}
}