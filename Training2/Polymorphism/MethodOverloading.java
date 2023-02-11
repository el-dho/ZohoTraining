
public class MethodOverloading {
	public static void main(String[] args) {
		Company obj = new Company();
		obj.print(2);
		obj.print();
		obj.print("Roshan",5);
	}
}


class Company{
	void print() {
		System.out.println("This is a method with no parameters");
	}
	void print(int number) {
		System.out.println("This is a method with the parameter:" + number);
	}
	void print(String name, int number) {
		System.out.println("This is a method with the parameters:" + name + " " + number);
	}
}