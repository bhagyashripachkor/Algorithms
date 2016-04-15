

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;



public class KruskalAlgorithm {
    private static Map<Character, Character> PARENT;
    private static Map<Character, Integer> rank;
    
    static class Edge implements Comparable<Edge>{
        char source, destination;
        int weight;
        Edge(char source, char destintion, int weight){
            this.source = source;
            this.destination = destintion;
            this.weight = weight; 
        }  

        @Override
        public int compareTo(Edge e) {

        	if(weight != e.weight)
        		return this.weight- e.weight;
        	else if(source != e.source)
        		if(e.source < source) {
        			return -1;
        		}else
        			return 1;

        	else if(e.destination < destination) {
        			return -1;
        		}else if(e.destination > destination)
        			return 1;
        		else return 0;
        	
        } 
        @Override
        public String toString(){
        	
            return "("+source+","+destination+")";
        }

    }
    

    public static void createHolders(char[] vertexArray){ 
        PARENT = new HashMap<>();
        rank = new HashMap<>();
        for(char x:vertexArray){
            PARENT.put(x, x);
            rank.put(x, 1);
        } 
    }
    
    public static char findSet(char item){
        char parent = PARENT.get(item); 
        if(parent==item)
        	return item;
        else 
        	return findSet(parent);
    }
    
    public static void union(char firstSet, char secondSet){
        char parentFirst, parentSecond;
        while((parentFirst = PARENT.get(firstSet))!=firstSet){
        	firstSet = parentFirst;
        	}
        while((parentSecond = PARENT.get(secondSet))!=secondSet){
        	secondSet = parentSecond;
        	}
        
        int rankFirst = rank.get(firstSet), rankSecond = rank.get(secondSet);
        if(rankFirst>rankSecond){
            PARENT.put(secondSet, firstSet);  
            calculateRank(secondSet);
        }else if(rankSecond>rankFirst){
            PARENT.put(firstSet, secondSet);  
            calculateRank(firstSet);
        }else{
            PARENT.put(secondSet, firstSet); 
            calculateRank(secondSet);
        }
    }
    
    public static void calculateRank(char current){
        int currentRank = rank.get(current);
        char currentsParent = PARENT.get(current);
        int parentRank = rank.get(currentsParent);
        if(!(currentRank<parentRank || currentsParent == current)){ 
            rank.put(currentsParent, currentRank+1);
            calculateRank(currentsParent);
        }
    } 
    
    public static void main(String[] args){
       
    	
    	Scanner sc = new Scanner(System.in);
		int noOfVertices = Integer.parseInt(sc.nextLine());
		
		String input1 = sc.nextLine();
		char[] listOfVertex = new char[noOfVertices];
		
		StringTokenizer token1 = new StringTokenizer(input1,"(,)");
		int index = 0;
		String s = "";
		while(token1.hasMoreTokens()){

			s = s + token1.nextToken();

			index++;
		}

		for(int i = 0; i < s.length(); i++)
			listOfVertex[i] = s.charAt(i);

	
		int[][] matrix = new int[noOfVertices][noOfVertices];
		int index1 =0;
		while(index1 < noOfVertices ) {
			String input2 = sc.nextLine();
	
			StringTokenizer token2 = new StringTokenizer(input2," ");
			while(token2.hasMoreTokens()){
		
				for(int j = 0; j < noOfVertices; j++){
					matrix[index1][j] = Integer.parseInt(token2.nextToken());
				}
			}
			index1++;
		}
		
		int countOfEdges = 0;
		for(int i = 0; i < noOfVertices; i++){
			for(int j = i; j< noOfVertices; j++){
				if(matrix[i][j] != 0){
					countOfEdges++;
				}
			}
			
		}
		int index2 = 0; 
		Edge[] edges = new Edge[countOfEdges];        
		for(int i = 0; i < noOfVertices; i++){
			for(int j = i; j< noOfVertices; j++){
				if(matrix[i][j] != 0){
					edges[index2] = new Edge(listOfVertex[i],listOfVertex[j],matrix[i][j]);
					index2++;
					
				}
			}
			
		}

        KruskalAlgorithm(listOfVertex, edges);
    }
    
  
    public static ArrayList<Edge> KruskalAlgorithm(char[] vertices, Edge[] edges){  
        
    	int finalcost = 0;
            ArrayList<Edge> tree = new ArrayList<>();
      

            createHolders(vertices);
             
     
            Arrays.sort(edges);
            
      
            for(Edge Edge:edges){
          
                if(findSet(Edge.source)!=findSet(Edge.destination)){
                 
                    tree.add(Edge);
                    finalcost = finalcost + Edge.weight;
                
                    union(Edge.source, Edge.destination);
                }
            }             
           
            ArrayList<Edge> treenew = new ArrayList<>();
          
            ArrayList<Character> src = new ArrayList<Character>();
            ArrayList<Character> dest = new ArrayList<Character>();
            ListIterator<Edge> pathItr = tree.listIterator();
    		while(pathItr.hasNext()){
 
    			char a = pathItr.next().source;
    			dest.add(a);
    
    			
    		}
    		ListIterator<Edge> pathItr2 = tree.listIterator();
    		while(pathItr2.hasNext()){

    			char b = pathItr2.next().destination;
    			src.add(b);
    	
    			
    		}
  
   		
    		for(int i = 0,j=0; i < src.size() && j< dest.size(); i++,j++){
    			char s = src.get(i);
    			char d = dest.get(j);
//    			System.out.println("("+s+","+d+")");
    		}
            //ListIterator<Edge> pathItr = tree.listIterator();
    		while(pathItr.hasNext()){
    			System.out.println(pathItr.next());
    		}
            System.out.println(finalcost);
            return tree;
    }
}
