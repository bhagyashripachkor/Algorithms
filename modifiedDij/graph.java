import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
	int vertexPosition;
	LinkedList<String> path;
	String name;
	int weight;

	Graph(int weight, int vertexPosition, String name){
		this.path = new LinkedList<String>();
		this.vertexPosition = vertexPosition;
		this.weight = weight;
		this.name = name;
	}
	public int getVertexPosition(){
		return vertexPosition;
	}
	public void setPath(LinkedList<String> path){
		this.path = path;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	public String getName(){
		return this.name;
	}

	public LinkedList<String> getPath(){
		return this.path;
	}

	public int getWeight(){
		return this.weight;
	}

	public String toString(){
		ListIterator<String> pathItr = this.path.listIterator();
		String str = pathItr.next();
		while (pathItr.hasNext()) {
			str = str + "->" + pathItr.next();
		}
		str = str + ":" + this.weight;
		return str;
	}
}
