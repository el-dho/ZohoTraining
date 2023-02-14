
public class Final {
	public static void main(String[] args) {
		Perimeter obj = new Perimeter();
		obj.perimeter(2);
	}
}

class Perimeter{
	static final double pi = 3.14;
	void perimeter(int r) {
		pi = 3.1415;
		System.out.println("The perimeter is: " + 2*pi*r );
	}
}