import java.util.*;
public class BrowserHistory1 {
	
	List<String>urlArrayList = new ArrayList<>();
	List<String>urlLinkedList = new LinkedList<>();
	List<String>urlVector = new Vector<>();
	
	Set<String>urlHashSet = new HashSet<>();
	Set<String>urlLinkedHashSet = new LinkedHashSet<>();
	Set<String>urlTreeSet = new TreeSet<>();
	
	List<String> temp;
	public void visit(String url) {
		urlArrayList.add(url);
		urlLinkedList.add(url);
		urlVector.add(url);
		
		urlHashSet.add(url);
		urlLinkedHashSet.add(url);
		urlTreeSet.add(url);
		
	}
	
	public void sort() {
		List<String> sortedArrayList = new ArrayList<>(urlArrayList);
		Collections.sort(sortedArrayList);
		System.out.println("Sorted Array List: " + sortedArrayList);
		List<String> sortedLinkedList = new LinkedList<>(urlLinkedList);
		Collections.sort(sortedLinkedList);
		System.out.println("Sorted Linked List: " + sortedLinkedList);
		List<String> sortedVector = new Vector<>(urlVector);
		Collections.sort(sortedVector);
		System.out.println("Sorted Vector: " + urlVector);
		//Set unable to sort as it is but can be sorted by converting to Lists or TreeSet
		Set<String> sortedHashSet = new TreeSet<>(urlHashSet);
		System.out.println("Sorted Hash Set: " + sortedHashSet);
		Set<String> sortedLinkedHashSet= new TreeSet<>(urlLinkedHashSet);
		System.out.println("Sorted Linked Hash Set: " + sortedLinkedHashSet);
		//TreeSet already sorted
		System.out.println("Sorted Tree Set: " + urlTreeSet);
	}
	
	public void deleteHistory(int index) {
		urlArrayList.remove(index);
		urlLinkedList.remove(index);
		urlVector.remove(index);
		
		temp = new ArrayList<>(urlHashSet);
		urlHashSet.remove(temp.get(index));
		temp = new ArrayList<>(urlLinkedHashSet);
		urlLinkedHashSet.remove(temp.get(index));
		temp = new ArrayList<>(urlTreeSet);
		urlTreeSet.remove(temp.get(index));
		
	}
	
	public void deleteHistory(String url) {
		urlArrayList.remove(url);
		urlLinkedList.remove(url);
		urlVector.remove(url);
		
		urlHashSet.remove(url);
		urlLinkedHashSet.remove(url);
		urlTreeSet.remove(url);
	}
	
	public void fetchHistory() {
		System.out.println("Array List: " + urlArrayList);
		System.out.println("Linked List: " + urlLinkedList);
		System.out.println("Vector List: " + urlVector);
		
		System.out.println("Hash Set: " + urlHashSet);
		System.out.println("Linked Hash Set: " + urlLinkedHashSet);
		System.out.println("Tree Set: " + urlTreeSet);
	}
	
	public void search(String extension) {
		
		System.out.println("Array List Search:");
		for(String url: urlArrayList) {
			if(url.contains(extension)) {
				System.out.println(url);
			}
		}
		
		System.out.println("Linked List Search:");
		for(String url : urlLinkedList) {
			if(url.contains(extension)) {
				System.out.println(url);
			}
		}
		
		System.out.println("Vector Search:");
		for(String url : urlVector) {
			if(url.contains(extension)) {
				System.out.println(url);
			}
		}
		
		
		System.out.println("Hash Set Search:");
		for(String url : urlHashSet) {
			if(url.contains(extension)) {
				System.out.println(url);
			}
		}
		
		System.out.println("Linked Hash Set Search:");
		for(String url : urlLinkedHashSet) {
			if(url.contains(extension)) {
				System.out.println(url);
			}
		}
		
		System.out.println("Tree Set Search:");
		for(String url : urlTreeSet) {
			if(url.contains(extension)) {
				System.out.println(url);
			}
		}
	}
	
	public void size() {
		System.out.println("Array List Size: " + urlArrayList.size());
		System.out.println("Linked List Size: " + urlLinkedList.size());
		System.out.println("Vector Size: " + urlVector.size());
		

		System.out.println("Hash Set Size: " + urlHashSet.size());
		System.out.println("Linked Hash Set Size: " + urlLinkedHashSet.size());
		System.out.println("Tree Set Size: " + urlTreeSet.size());
	}
	
	public void updateHistory(int index, String newUrl) {
		urlArrayList.set(index, newUrl);
		urlLinkedList.set(index, newUrl);
		urlVector.set(index, newUrl);
		
		temp = new ArrayList<>(urlHashSet);
		temp.set(index, newUrl);
		urlHashSet = new HashSet<>(temp);
		
		temp = new ArrayList<>(urlLinkedHashSet);
		temp.set(index, newUrl);
		urlLinkedHashSet = new HashSet<>(temp);
		
		temp = new ArrayList<>(urlTreeSet);
		temp.set(index, newUrl);
		urlTreeSet = new HashSet<>(temp);
	}
}
