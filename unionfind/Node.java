import java.util.ArrayList;

public class Node {
	ArrayList<Integer> set;
	
	public Node(ArrayList<Integer> set){
		this.set = set;
	}
	public ArrayList<Integer> getSet(){
		return this.set;
	}
	
	public void setSet(ArrayList<Integer> al){
		this.set = al;
	}
}
