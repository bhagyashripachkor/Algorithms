import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DijkstraShortestPathPQ {
	public static void main(String[] args){
		 Scanner sc = new Scanner(System.in);
		 int noOfVertices = Integer.parseInt(sc.nextLine());
		 String sourceVertex = sc.nextLine();
		 String str = sc.nextLine();
		 StringTokenizer st = new StringTokenizer(str,"(,)");
		 ArrayList<String> vertices = new  ArrayList<String>();
		 while(st.hasMoreTokens()){
			 vertices.add(st.nextToken());
		 }

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
		    

	 }
}
