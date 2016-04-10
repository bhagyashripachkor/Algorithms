package abc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UnionFind {

	LinkedHashMap<Integer, Node> ht;

	public UnionFind(LinkedHashMap<Integer, Node> ht){
		this.ht = ht;
	}

	public void Union(int source, int destination) {
		// TODO Auto-generated method stub
		int flag = 0;
	ArrayList<Integer> temp;
	Node n;
	for (Map.Entry<Integer,Node> entry : ht.entrySet())  {
	  
		if(entry.getKey()==source){
			int k = entry.getKey();
			if(!entry.getValue().getSet().contains(destination)){
				
				temp = new	ArrayList<Integer>();
				temp = entry.getValue().getSet();
				temp.add(destination);
				
				n = new Node(temp);
				ht.put(k, n);
				for (Map.Entry<Integer,Node> rest : ht.entrySet()) {
					if(rest.getKey()==destination){
						int d = rest.getKey();
						ht.put(d, n);
						
					}
				}
				
			}else{
				flag = 1;
				System.out.println("There is a Cycle");
			}
		}
	}
	if(flag == 0)
		print(ht);

	}


	private void print(LinkedHashMap<Integer, Node> ht2) {
		// TODO Auto-generated method stub

		ArrayList<String> sl = new ArrayList<String>();
		Set set = ht.entrySet();
	       // Get an iterator
	       Iterator i = set.iterator();

	       // Display elements
	       while(i.hasNext()) {
	    	   Map.Entry<Integer,Node> me = (Map.Entry)i.next();

	         if(!sl.contains(me.getValue().getSet().toString())){

	        	 sl.add(me.getValue().getSet().toString());
	         }
	      }

	       ArrayList<String> s2 = new ArrayList<String>();
	       int count = 0;
	       for(String p : sl){
	         String s1 = p.replace("[", "(").trim();
	         String s11 = s1.replace("]", ")").trim();
	         String s12 = s11.replace(" ", "").trim();
	     
	         if(count == 0){
	         System.out.print(s12);
	         count++;
	         }else
	        	 System.out.print(","+s12);
	       }
	       System.out.println();
		
	}

	public void check(int source, int destination) {
		// TODO Auto-generated method stub
		int flag = 0;
		for (Map.Entry<Integer,Node> entry : ht.entrySet()){
			if(entry.getKey()==source){
				if(entry.getValue().getSet().contains(destination)){
					flag = 1;
					break;
				}
			}
		}
		if(flag == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}

}
