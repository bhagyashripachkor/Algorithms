package abc;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UnionFindTest {
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int V = Integer.parseInt(sc.nextLine());

	LinkedHashMap<Integer, Node> ht =new LinkedHashMap<Integer, Node>();
	ArrayList<Integer> set ;
	Node n;
	for(int i = 1; i <= V; i++){
		set = new ArrayList<Integer>();
        set.add(i);
		 n = new Node(set);
		 n.setSet(set);
		ht.put(i, n);		
	}

	int i = 0;
	String op1 = "union";
	String op2 = "check";
	UnionFind uf = new UnionFind(ht);
	while(true) {
	    String nextLine = sc.nextLine();
	    if ( nextLine.equalsIgnoreCase("end") || nextLine.equals("")) {
	       break;
	    }
	    else{
	    	if(nextLine.contains("Union")){
	    		int len = nextLine.length();
	    		int lenOfOP1 = op1.length();
	    		String str = nextLine.substring(lenOfOP1, len);

	    		StringTokenizer st = new StringTokenizer(str,"()");
	    		while(st.hasMoreTokens()){
	    			String s = st.nextToken();

	    			String[] data = s.split(",");
	    			int source = Integer.parseInt(data[0]);
	    			int destination = Integer.parseInt(data[1]);
	    			uf.Union(source, destination);

	    		}
	    	}else if(nextLine.contains("Check")){
	    		int len = nextLine.length();
	    		int lenOfOP2 = op1.length();
	    		String str = nextLine.substring(lenOfOP2,len );

	    		StringTokenizer st = new StringTokenizer(str,"()");
	    		while(st.hasMoreTokens()){
	    			String s = st.nextToken();

	    			String[] data = s.split(",");
	    			int source = Integer.parseInt(data[0]);
	    			int destination = Integer.parseInt(data[1]);
	    			uf.check(source, destination);
	    		
	    		}
	    	}
	    }
	}
}
}
