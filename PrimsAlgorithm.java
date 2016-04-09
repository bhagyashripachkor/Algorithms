import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PrimsAlgorithm {
 public static String source = "";
 @SuppressWarnings("rawtypes")
public static Hashtable<String,ArrayList> vertex = new Hashtable<String,ArrayList>();
 @SuppressWarnings("rawtypes")
public static Hashtable<String,ArrayList> weights = new Hashtable<String,ArrayList>();
 
 public static Hashtable<String,Integer> distance = new Hashtable<String,Integer>();
 public static Hashtable<String,String> parent = new Hashtable<String,String>();
 
 @SuppressWarnings({ "rawtypes", "unchecked" })
public static List<String> vertexList = new ArrayList();
 
 public void insertIntoVertex(String key, @SuppressWarnings("rawtypes") ArrayList arr){
	 vertex.put(key, arr);
 }
 public void insertIntoWeights(String key, @SuppressWarnings("rawtypes") ArrayList arr){
	 weights.put(key, arr);
 }
 public void insertIntoParent(String key, String value){
	 parent.put(key, value);
 }
 public void insertIntoDistance(String key, int dist){
	 distance.put(key, dist);
 }
 @SuppressWarnings("unchecked")
public List<String> getVertices(String minimumStr){
	 return vertex.get(minimumStr);
 }
 @SuppressWarnings("unchecked")
public List<String> geWeights(String minimumStr){
	 return weights.get(minimumStr);
 }
 public String getFromParent(String key){
	 return parent.get(key);
 }
 public int getDistance(String key){
	 if(distance.containsKey(key))
		 return (distance.get(key));
	 else
		 return 0;
 }
 
 
 @SuppressWarnings({ "unchecked", "rawtypes" })
ArrayList<String> countList = new ArrayList();
 public void finalPath(){
	 System.out.print("(");
	 for(int i = 0; i <vertexList.size(); i++){
		 if(i == vertexList.size()-1){
			 System.out.print(getFromParent(vertexList.get(i)+""));
			 countList.add(getFromParent(vertexList.get(i)+""));
			 
		 }else{
			 System.out.print(getFromParent(vertexList.get(i)+"")+",");
			 countList.add(getFromParent(vertexList.get(i)+""));
		 }
	 }
	 System.out.println(")");
 }
 
 @SuppressWarnings("rawtypes")
public void printDistance(){
	 int count = 0;
	 for(int i = 0; i < countList.size(); i++){
		 @SuppressWarnings("rawtypes")
		ArrayList vertexlist = vertex.get(countList.get(i)+"");
		 ArrayList weightlist = weights.get(countList.get(i)+"");
		 if(vertexlist != null && vertexlist.contains(vertexList.get(i))){
			 int index = vertexlist.indexOf(vertexList.get(i));
			 count = count + Integer.parseInt(weightlist.get(index)+"");
		 }
	 }
	 System.out.println(count);
 }
 
 @SuppressWarnings({ "rawtypes", "unchecked", "resource" })
public static void main(String[] args){
	 ArrayList arr1, arr2 = new ArrayList();
	 Scanner sc = new Scanner(System.in);
	 int num = Integer.parseInt(sc.nextLine());
	 
	 String vertices = sc.nextLine();
	 vertexList  = new ArrayList();
	 StringTokenizer stzr = new StringTokenizer(vertices,"(), ");
	 while(stzr.hasMoreTokens()){
		 vertexList.add(stzr.nextToken());
	 }
	 source = sc.nextLine();
	 	 
	 PrimsAlgorithm  prims = new PrimsAlgorithm();
	 
	 
	 int index = 0, j = 0;
	 while(j < num){
		 String str = sc.nextLine();
		 String[] tokenizedArray =str.split("\\s");
		 arr1 = new ArrayList();
		 arr2 = new ArrayList();
		 int y = 0;

		 while(y < tokenizedArray.length){
			 if(!tokenizedArray[y].equals("0")){
				 arr1.add(vertexList.get(y));
				 arr2.add(tokenizedArray[y]+"");
				 
			 }
		 }
		 prims.insertIntoVertex(vertexList.get(index)+"", arr1);
		 prims.insertIntoWeights(vertexList.get(index)+"", arr2);
		 index++;
		 j++;
	 }
	 List<String> PQ = new ArrayList<String>();
	 PQ.add(source);
	 prims.insertIntoParent(source, source);
	 
	 int j1 = 0;

	 for(int x = 0; x < vertexList.size(); x++)
		 prims.insertIntoDistance(vertexList.get(x)+"", 99999);
	 
	 prims.insertIntoDistance(source, 0);
	 
	 String finalString = "(";
	 int count2 = 0;
	 
	 while(PQ.size() != 0){
		 
		 String minimumStr = "";
		 int min = Integer.MAX_VALUE;
		 
		 for(int m = 0; m < PQ.size(); m++){
			 int currentValue = (Integer)distance.get(PQ.get(m)+"");
			 if(currentValue <min){
				 min = currentValue;
				 minimumStr = "" + PQ.get(m);
				 
			 }
		 }
		 PQ.remove(minimumStr);
		 finalString = finalString + "" + minimumStr+ ",";
		 prims.insertIntoDistance(minimumStr, 0);
		 List<String> vertexPList = new ArrayList();
		 List<String> weightPList = new ArrayList();
		 weightPList = prims.geWeights(minimumStr);
		 vertexPList = prims.getVertices(minimumStr);
		 
		 if(vertexPList != null){
			 int a = 0;
			 while(a < vertexPList.size()) {

				 int uDist = 0, vDist = 0,edgeWt = 0, sum = 0;
				 vDist = (Integer)prims.getDistance(vertexPList.get(a)+"");
				 edgeWt = Integer.parseInt(weightPList.get(a)+"");
				 
				 if(edgeWt < vDist){
					 prims.insertIntoDistance(vertexPList.get(a)+"", edgeWt);
					 prims.insertIntoParent(vertexPList.get(a)+"", minimumStr);
					 if(!PQ.contains((String)vertexPList.get(a))){
						 PQ.add((String)vertexPList.get(a));
					 }
				 }
				 a++;
			 }
		 }
		 
	 }
	 prims.finalPath();
	 String sub = finalString.substring(0,(finalString.length()-1))+")";
	 System.out.println(sub);
	 prims.printDistance();
	 
 }
}
