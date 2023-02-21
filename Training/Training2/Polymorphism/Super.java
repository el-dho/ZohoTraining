
public class Super {
	public static void main(String[] args) {
		EmployeeComp emp = new EmployeeComp();
		emp.variableMethod();
		emp.superMethod();
	}
}


class ZohoComp{
	String name = "Zoho";
	ZohoComp(){
		System.out.println("This is inside the parent constructor using super keyword");
	}
	void method(String str) {
		System.out.println("This is inside parent method and output is:" + str);
	}
}

class EmployeeComp extends ZohoComp{
	String name  = "EmployeeComp";
	void variableMethod() {
		System.out.println("This is inside the method of child class");
		System.out.println("Variable value in parent class: " + super.name);
	}
	void superMethod() {
		super.method("This is the super method");
	}
	EmployeeComp(){
		name = "Eldho";
		super();
	}
}
