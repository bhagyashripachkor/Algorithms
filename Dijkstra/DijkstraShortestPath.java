import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DijkstraShortestPath {
	int[][] array;
	int noOfVertices;
	int source;
	int destination;
	static String sourceVertex;
	static String destinationVertex;
	Graph path[];
	String[] vertices;
	
	
	DijkstraShortestPath(int[][] array, int noOfVertices, String sourceVertex,String destinationVertex,String str){
		this.array = array;
		this.noOfVertices = noOfVertices;
		path = new Graph[noOfVertices];
		this.vertices = new String[noOfVertices];
		
		StringTokenizer st = new StringTokenizer(str,"(,)");
		int index = 0;
		while(st.hasMoreTokens()){
			vertices[index] = st.nextToken();
			if(vertices[index].equalsIgnoreCase(sourceVertex))
				this.source = index;
			if(vertices[index].equalsIgnoreCase(destinationVertex))
				this.destination = index;
			index++;
		}
//		
//		for(int i = 0; i < vertices.length; i++)
//			System.out.println(vertices[i]);
		for (int i = 0; i < noOfVertices; i++) {
        	path[i] = new Graph(9999, i);
            path[i].getPath().add(sourceVertex);
        }
	}
	
	public static void main(String[] args){
		 Scanner sc = new Scanner(System.in);
		 int noOfVertices = Integer.parseInt(sc.nextLine());
		 String str = sc.nextLine();
		 //String sourceVertex = sc.nextLine();
		 String[] sd = sc.nextLine().split(",");
		 sourceVertex = sd[0];
		 destinationVertex = sd[1];
		 //System.out.println(sourceVertex + "---" + destinationVertex );
		 
		 int src = 0;

		 
		 String input3="",input4="";
		 int index = 0,k,count = 0;
		 
		 int[][] array = new int[noOfVertices][noOfVertices];
		    while (count != noOfVertices) {
		      input3 = sc.nextLine();
		      StringTokenizer tokens = new StringTokenizer(input3,",");
		      k = 0;
		      while (tokens.hasMoreTokens()) {
		        input4 = tokens.nextToken();
		        array[index][k] = Integer.parseInt(input4);
		        k++;
		      }
		      index++;
		      count++;
		     } 
		    DijkstraShortestPath dsp = new DijkstraShortestPath(array,noOfVertices,sourceVertex,destinationVertex,str);
		    dsp.findMinimumPath();

	 }

	private void findMinimumPath() {
		// TODO Auto-generated method stub
		//set the parent of inital to 0
		path[source].setWeight(0);
		PriorityQueue<Graph> PQ = new PriorityQueue<Graph>(noOfVertices,pathCheck);
		PQ.add(path[source]);
		while(!PQ.isEmpty()){
			Graph current = PQ.poll();
			LinkedList<String> li = current.getPath();
			int wt = current.getWeight();
			int pos = current.getVertexPosition();
			int x = 0;
			while(x < noOfVertices){
				int currentWeight = array[pos][x];
				if(currentWeight != 0){
					if(wt + currentWeight < path[x].getWeight()){
						LinkedList<String> newPath = new LinkedList<String>(li);
						path[x] = new Graph(wt+array[pos][x],x);
						path[x].setPath(newPath);
						path[x].getPath().add(vertices[x]);
						if(!PQ.contains(path[x])){
							PQ.add(path[x]);
						}
						
					}
				}
				x++;
			}
			
		}
		this.path();
	}

	private void path() {
		// TODO Auto-generated method stub

		int i = 0;
		while(i < noOfVertices){
			
			  if(path[i].getPath().contains(destinationVertex)) {
				  int m = i;
				  System.out.println(path[m].getPath() + ":" + path[m].getWeight());
				  String k =  path[m].getPath().removeLast();
				  while(m >= 1){
					 String d =path[m].getPath().removeLast();
//					 System.out.println(k + "k is");
//					 System.out.println(path[m-1].getPath().getLast() + "last is");
					 if(path[m].getPath().removeLast().equals(path[m-1].getPath().getLast()))
	
			    	    System.out.println(path[m-1].getPath() + ":" + path[m-1].getWeight());
			    	 m--;
				  }
//				System.out.println(vertices[source] + "->" + vertices[i] + ":" + path[i].getWeight());

			}
		i++;
		}

	}

	public static Comparator<Graph> pathCheck = new Comparator<Graph>(){
        public int compare(Graph g1, Graph g2) {
            if(g1.getWeight() != g2.getWeight())
                return g1.getWeight() - g2.getWeight();
            else 
                return g1.getVertexPosition() - g2.getVertexPosition();
        }
};
}

