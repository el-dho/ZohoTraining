import java.lang.reflect.*;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, SecurityException {
		//Class<DemoClass> obj = DemoClass.class;
		//Class obj1 = Class.forName("DemoClass");
		DemoClass obj2 = new DemoClass("John", 243, false);
		Class<?> obj = obj2.getClass();
		Field[] objFields = obj.getDeclaredFields();
		for(Field field:objFields) {
			if(field.getName().equals("name")) {
				field.setAccessible(true);
				field.set(obj2, "Lucas");
			}
		}

		
		System.out.println(obj2.getName());
		
		Method [] objMethods = obj.getDeclaredMethods();
		for(Method method : objMethods) {
			if(method.getName().equals("disp")) {
				method.invoke(obj2);
			}
		}
		
		
		System.out.println("SuperClass: " + obj.getSuperclass());
		
		System.out.println("Interfaces: " + obj.getInterfaces());
		
		System.out.println("Public Fields: " + Arrays.toString(obj.getFields()));
		
		System.out.println("All Fields: " + Arrays.toString(obj.getDeclaredFields()));
		
		System.out.println("Modifier: " + Modifier.toString(obj.getModifiers()));
		
		System.out.println("Methods: " + Arrays.toString(obj.getDeclaredMethods()));
		
		System.out.println(Arrays.toString(obj.getConstructors()));
		
		System.out.println(Arrays.toString(obj.getDeclaredConstructors()));
		
		for(Constructor<?> constr : obj.getDeclaredConstructors()) {
			System.out.println(constr.getName() + " " + constr.getParameterCount());
		}
		
		
		
		
	}

}
