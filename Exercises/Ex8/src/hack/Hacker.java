package hack;
import java.io.*;
import java.util.*;

public class Hacker {
	
	private ArrayList<String> randomHistory = new ArrayList<>(Arrays.asList("www.xyz.com","www.hacked.com","www.aprilfools.com"));
	private ArrayList<String> receivedHistory = new ArrayList<>();
	private ArrayList<String> modifiedHistory = new ArrayList<>();
	
	public void readFile(String fileLocation) {
		try {
			FileReader reader = new FileReader(fileLocation);
			BufferedReader bReader = new BufferedReader(reader);
			while(bReader.ready()) {
				String url = bReader.readLine();
				receivedHistory.add(url);
			}
			bReader.close();
			reader.close();
			
		}
		catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public List<String> getModifiedHistory(){
		modifiedHistory.clear();
		modifiedHistory.addAll(receivedHistory);
		modifiedHistory.addAll(randomHistory);
		return modifiedHistory;
	}
}
