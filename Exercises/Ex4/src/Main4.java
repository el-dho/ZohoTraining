import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		String[] output = new String[0];
		Scanner sc = new Scanner(System.in);
		while(true) {
			String input = sc.next();
			if(input.equals("exit"))
				break;
			else if (output.length==0)
				output = addUrl(input,output);
			else {
				for(int i = 0; i<output.length;i++) {
					if(output[i].contains(input)) {
						String[] urlElements = output[i].split(" ## ");
						if(urlElements[0].equals(input)) {
							int num = Integer.parseInt(urlElements[1]);
							output[i] = urlElements[0] + " ## " + (++num);
							break;
						}
						else if(i==output.length-1) {
							output = addUrl(input,output);
							break;
						}
					}
					else if(i==output.length-1){
						output = addUrl(input,output);
						break;
					}
				}
			}
			for(String url : output)
				System.out.println(url);
		}
		
	}
				
	static String[] addUrl(String url, String[] urlArray) {
		String[] temp = new String[urlArray.length+1];
		temp[urlArray.length] = url + " ## " + 1;
		System.arraycopy(urlArray, 0, temp, 0, urlArray.length);
		return temp;
	}
}


//output = <www.google.com ## 2,www.facebook.com ## 3>