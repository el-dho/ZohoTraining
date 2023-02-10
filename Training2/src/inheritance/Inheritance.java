package inheritance;

public class Inheritance {
	public static void main(String[] args) {
		Employee emp = new Employee();
		System.out.println("Company Name: " + emp.companyName + "\nEmployee ID: " + emp.employeeID);
		Developer dev = new Developer();
		System.out.println("\nCompany Name: " + dev.companyName + "\nEmployee ID: " + dev.employeeID + "\nLanguage: " + dev.language);
		Product prod = new Product();
		System.out.print("\nCompany Name: " + prod.companyName + "\nProduct Name: " + prod.productName);
	}
}

class Zoho{									//parent clas
	String companyName = "Zoho";
}

class Employee extends Zoho{				//child class (Zoho -> Employee)
	String employeeID = "ZT"; 
}

class Product extends Zoho{					//child class (Zoho -> Product)
	String productName = "Desk";
}

class Developer extends Employee{			//child class (Zoho -> Employee -> Developer)
	String language = "Java";
}