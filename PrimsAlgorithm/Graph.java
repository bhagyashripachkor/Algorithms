import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
	String data;
	int rank;
	Graph parent;
	
	public Graph(String data, int rank, int parent){
		this.data = data;
		this.rank = rank;
		this.parent = new Graph();
	}
	
	public void setData(String data){
		this.data = data;
	
	}
	
	public String getData(){
		return this.data;
	}
	
	public void setRank(int rank){
		this.rank = rank;
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public void setParent(Graph.parent){
		this.parent = parent;
	}
	
	public Graph getParent(){
		return this.parent;
	}
}
