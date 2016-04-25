import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BellmanFordIteration {
	static int[] distance;
	static String[] vertexlist;
	 static int[][] array;
	 static int[] parent;
	 static int noOfVertices;
	 static int infinity = 9999;
	 static int sr=0;
	 static Hashtable<String,String> prnt = new Hashtable<String,String>();
	public static void main(String[] args){
		 Scanner sc = new Scanner(System.in);
		 final int maxdistance= infinity;
		 
		
		 noOfVertices = Integer.parseInt(sc.nextLine());
		 String vertices = sc.nextLine();
		 String sourceVertex = sc.nextLine();
		
		 int src = 0;

		 String input3="",input4="";
		 int index = 0,k,count = 0;
		 
	
		vertexlist = new String[noOfVertices];
		 array = new int[noOfVertices][noOfVertices];
		 
		 
		 
		 
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
		   StringTokenizer s = new StringTokenizer(vertices,"(,)");
		   int z = 0;
		   while(s.hasMoreTokens()){
			   vertexlist[z] = s.nextToken();
			   z++;
		   }

		   for(int i =0; i < noOfVertices; i++){
			   for(int j = 0; j< noOfVertices; j++){
				   if(array[i][j] == 0)
					   array[i][j] = infinity;
			   }
		   }
		   
		   distance = new int[noOfVertices];
		   for(int i = 0; i < distance.length; i++)
			   distance[i] = infinity;
		   
		   parent = new int[noOfVertices];
		   for(int i = 0; i < parent.length; i++)
			   parent[i] = 0;
		   
		   for(int i = 0; i < vertexlist.length; i++){
				if(vertexlist.equals(sourceVertex)){
					src = i;
					break;
				}
			}
		   prnt.put(sourceVertex, sourceVertex);
		   findMinmumPath(array,sr);
		   //printPath(sr);
		    

	 }
	private static void printPath(int sr) {
		// TODO Auto-generated method stub

		String s="";
		String start = vertexlist[sr];
		s = start + "->";
		
		for(int vertex = 0; vertex < noOfVertices; vertex++){
			if(vertexlist[vertex].contains(start)){
				System.out.println(s + start +":"+ distance[vertex]);
			}else{
				String st1=vertexlist[vertex],st2=vertexlist[vertex];

				while(!prnt.get(st1).contains(start)){
					st1 = prnt.get(st1);
					st2 = st1 + "->" + st2; 
					
				}
				System.out.println(s + st2 + ":" + distance[vertex]);
			}
		}
		
	}
	private static void findMinmumPath(int[][] array, int sourceVertex) {
		ArrayList<Integer> iteration = new ArrayList<Integer>(noOfVertices);
		int itr = 0;
		// TODO Auto-generated method stub
		distance[sourceVertex] = 0;
		int ver = 0;
		for(int vertex = 0; vertex < noOfVertices - 1; vertex++) {

			ver++;
			for(int source = 0; source < noOfVertices; source++){
				
				for(int destination = 0; destination < noOfVertices; destination++) {
					if(array[source][destination] != 9999) {
						if (distance[destination] > distance[source] + array[source][destination] ){

									iteration.add(vertex);

							
							
							distance[destination] = distance[source] + array[source][destination];

							prnt.put( vertexlist[destination],vertexlist[source]);
							
						}
					}
					
					//relaxation(array[source][destination],source,destination);
				}
				
			}
			if(vertex > 0 && !iteration.contains(vertex)){
				break;
			}
		
		}

		int pos = 0;
		for(int i = 0; i < distance.length; i++){
			if(distance[i] == infinity){
				pos = i;
				prnt.put( vertexlist[pos],vertexlist[0]);
			}
		}
		
		int flag = 0;
		for(int source = 0; source < noOfVertices; source++) {
			for(int destination = 0; destination < noOfVertices; destination++){
				if(array[source][destination] != infinity){
				if (distance[destination] > distance[source]+ array[source][destination]){

					flag = 1;
					break;
//					infect(destination);
				}
				}
			}
		}
		if(flag == 1){
			//printPath(sr);
			System.out.println("The graph has negative cycles.");
			System.out.println("9999");
		}
		else{
			printPath(sr);
			System.out.println(ver);
		}
		
	  	
	}
	private static void infect(int destination) {
		// TODO Auto-generated method stub
		if(distance[destination] > infinity){
			distance[destination] = infinity;
			int x = destination;
				for(int j = 0; j < noOfVertices; j++){
					if(array[x][j] != infinity){
						infect(j);
					}
				
			}
		}
	}
	private static void relaxation(int cost, int source, int destination) {
		// TODO Auto-generated method stub
//		if(array[source][destination] != 0) {
//			if (distance[destination] > distance[source] + array[source][destination]){
//				distance[destination] = distance[source] + array[source][destination];
//
//				prnt.put( vertexlist[destination],vertexlist[source]);
//			}
//		}
		
	}

	
}
