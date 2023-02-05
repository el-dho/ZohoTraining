
public class Dog {
	String Name;
	int Age;
	int Price;
	
	
	Dog() {
		
	}
	
	Dog(String Name, int Age, int Price) {
		this.Name = Name;
		this.Age = Age;
		this.Price = Price;
	}
	
	public void printdetails() {
		System.out.println(Name);
		System.out.println(Age);
		System.out.println(Price);
	}
	
	public static void main(String[] args) {
		Dog D1 = new Dog();
		Dog D2 = new Dog("Sugu",12,200);
		Dog D3 = new Dog("Ramesh",5,100);
		D1.printdetails();
		D2.printdetails();
		D3.printdetails();
	}
	
	
}
