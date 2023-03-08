
public class BrowserHistory {
	
	private String[] history = new String[0];
	private int position;
	
	public BrowserHistory() {
	} //empty constructor
	
	public BrowserHistory(String homepage) {
		position = -1;
		visit(homepage);
	}

	public void visit(String url) {
		try {
			boolean urlValid = url.contains(".org") || url.contains(".in") || url.contains(".com");
			if(!urlValid) {
				throw new InvalidURLException();
			}
			position++;
			history = addSpace(history);
			history[position] = url;
		}
		catch (InvalidURLException e) {
			System.out.println(e);
		}
	}
	
	public String back(int steps) throws Exception {
		try {
			if(steps>position) {
				throw new NoHistoryFoundException();
			}
			position -= steps;
			return history[position];
		}
		catch (NoHistoryFoundException | ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			throw e;
		}
	}
	
	public String forward(int steps) throws Exception {
		try {
			if(steps>history.length-1-position) {
				throw new NoHistoryFoundException();
			}
			position += steps;
			return history [position];
		}
		catch (NoHistoryFoundException | ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			throw e;
		}
	}
	
	public String get (int position) throws Exception {
		try {
			if(position<0) {
				throw new InvalidPositionException();
			}
			if(position>history.length) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return history[position];
			}
		catch (InvalidPositionException e) {
			System.out.println(e);
			throw e;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + "Invalid Position");
			throw e;
		}
		
	}
	
	public String[] addSpace(String[] history) {
		String[] temp = new String[history.length+1];
		System.arraycopy(history, 0, temp, 0, history.length);
		return temp;
	}
}
