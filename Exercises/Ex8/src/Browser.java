import java.io.*;
import java.util.*;

public class Browser {
	private List<String> history = new ArrayList<>();

	public List<String> getHistory() {
		return history;
	}

	public void setHistory(List<String> history) {
		this.history = history;
	}

	public void visit(String url) {
		history.add(url);
	}
	
	public void createFile(String fileLocation) {
		try {
			FileWriter writer = new FileWriter(fileLocation);
			for(String url : history) {
				writer.write(url+"\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}
