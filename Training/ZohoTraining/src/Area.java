import java.util.*;
public class Area{
	static double area;
	
	Area(double radius){
		this.area = 3.14 * radius * radius;
	}
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		double radius,radius2;
		System.out.print("Enter radius: ");
		radius = ip.nextDouble();
		Area obj1 = new Area(radius);
		System.out.println("The Area of obj1: " + obj1.area);
		System.out.print("Enter radius2: ");
		radius2 = ip.nextDouble();
		Area obj2 = new Area(radius2);
		System.out.println("The Area of obj2: " + obj2.area);

		System.out.println("The Area of obj1: " + obj1.area);
	}
}
