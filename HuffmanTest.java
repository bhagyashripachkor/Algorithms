import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
public class HuffmanTest {
 public static void main(String[] args){
	 HuffmanCode hc = new HuffmanCode();
	 Scanner sc = new Scanner(System.in);
   	 int noOfchar = Integer.parseInt(sc.nextLine());
   	 int x = 0;
   	char[] inputChar = new char[noOfchar];
   	int[] fr = new int[noOfchar];
   	int index = 0;
   	 while(x < noOfchar) {
   		 String s = sc.nextLine();
   		
   		 StringTokenizer st = new StringTokenizer(s," ");
   		 int freq = 0;
   		 while(st.hasMoreElements()){
   			 
   			 String ss = st.nextToken();
   			 if(isInteger(ss)){
   				freq= Integer.parseInt(ss);
   				fr[index] = freq;
   			 }
   			 else{
   				inputChar[index] = ss.charAt(0);
   				
   			 }
   			 
   		 }
   		index++;



   		 x++;
   	 }
   	 
   	 hc.initialize(inputChar,fr);

        
 }
 public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
}
class MinHeap {
  public int size;
  public int[] heap;
  public int[] elements;
  public int position;
  int index = 0;
  public MinHeap(int size) {
      this.size = size;
      heap = new int[size + 1]; 
      position = 0;
  }

  public void insert(int[] array) {
      if (array.length > 0) {
          for (int i = 0; i < array.length; i++) {
              insert(array[i]);
          }
      }
  }

  public void display() {
      for (int i = 1; i < heap.length; i++) {
        if (heap[i] != 0)
          System.out.print(" " + heap[i]);
      }
      System.out.println("");
  }

  public void insert(int x) {
      if (position == 0) { 
        //root
          heap[position + 1] = x; 
          position = 2;
      } else {
        //end
          heap[position++] = x; 
          bubbleUp(); 
      }
  }

  
  public void bubbleUp() {
    //last
      int pos = position - 1; 
      //root >
      while (pos > 0 && heap[pos / 2] > heap[pos]) { 
          int y = heap[pos];
          heap[pos] = heap[pos / 2];
          heap[pos / 2] = y;
          pos = pos / 2; 
      }
  }

  public int extract_min() {
      int min = heap[1]; 
      //root = last
      if (min != 0) {
      heap[1] = heap[position - 1]; 
      heap[position - 1] = 0; 
      position--; 
      heapify(1); 
      }
      return min;
  }
  
  public void heapify(int k) {
      int a = heap[k];
      int smallest = k;
      // check which is smaller child , 2k or 2k+1.
      if (2 * k < position && heap[smallest] > heap[2 * k]) {
          smallest = 2 * k;
      }
      if (leftChild(k) < position && heap[smallest] > heap[leftChild(k)]) {
          smallest = leftChild(k);
      }
      if (smallest != k) { 
          swap(k, smallest);
          heapify(smallest); 
      }

  }
  
public void sort() {
    int temp;
    elements = new int[heap.length];
    for (int i = 0; i < heap.length - 1; i++) {
      if (heap[i] > heap[i+ 1]) {
        temp = heap[i];
        heap[i] = heap[i + 1];
        heap[i + 1] = temp;
      }
    }  
  }
  public int parent(int k) {
    return (k - 1)/2 ;
  }
  
  public int leftChild(int k) {
    return (2 * k + 1);
  }
  
  public int rightChild(int k) {
    return (2 * k + 2);
  }

  public void swap(int a, int b) {
     
      int temp = heap[a];
      heap[a] = heap[b];
      heap[b] = temp;
  }

 
  public void delete(int x) {
      
      int index = 0;
      for (int i = 1; i < heap.length; i++) {
          if (heap[i] == x) {
              index = i;
              break;
          }
      }
      heap[index] = heap[position - 1];
      heap[position - 1] = 0; 
      position--;
      heapify(index);
  }
}
class HuffmanAlgorithm implements Comparable<HuffmanAlgorithm> {
	
    public int frequency=0; 
    
    public HuffmanAlgorithm(int freq) { 
    	this.frequency = freq; 
    	}
    public HuffmanAlgorithm() { 
     
    	}
    
    public int compareTo(HuffmanAlgorithm heap) {
    	int difference = frequency - heap.frequency;
        return difference;
    }
    
    public int getFrequency(){
    	return this.frequency;
    }
    
    public void setFrequency(int fre){
    	this.frequency = fre;
    }
}
 
class Node extends HuffmanAlgorithm {
    public final char value; 
 
    public Node(int freq, char val) {
        super(freq);
        value = val;
    }
    
    public void setValue(char valu){
    	valu = valu;
    }
    
    public char getValue(char valu){
    	return valu;
    }
}
 
class HuffmanNode extends HuffmanAlgorithm {
    public final HuffmanAlgorithm left, right;
 
    public HuffmanNode(HuffmanAlgorithm l, HuffmanAlgorithm r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
    
    public void setLeftChild(Node lc){
    	lc = lc;
    }
    
    public HuffmanNode getLeftChild(){
    	return (HuffmanNode) this.left;
    }
    
    public void setRightChild(Node rc){
    	rc = rc;
    }

    public HuffmanNode getRightChild(){
    	return (HuffmanNode) this.right;
    }
}
 
class HuffmanCode {


	static ArrayList<String> arr = new ArrayList<String>();
	static ArrayList<Integer> btd = new ArrayList<Integer>();
    public static HuffmanAlgorithm createHeap(int[] charInput, char[] inputChar) {
    	
        PriorityQueue<HuffmanAlgorithm> PQ = new PriorityQueue<HuffmanAlgorithm>();

        int index = 0;
        while(index < charInput.length){
     
            if (charInput[index] > 0)
                PQ.offer(new Node(charInput[index], inputChar[index]));
            index++;
        }
 
        int y = 0;
        for(int i = 0; i < charInput.length; i++)
            y = charInput[i];
       
        while (PQ.size() > 1) {

            HuffmanAlgorithm n1 = PQ.poll();
            HuffmanAlgorithm n2 = PQ.poll();
 
    
            PQ.offer(new HuffmanNode(n1, n2));
        }
        return PQ.poll();
    }
    static int total = 0;
    public static void binaryCodeHeap(HuffmanAlgorithm heap, StringBuffer binaryCode) {
 
    	char zero = '0';
    	char one='1';
    	
        if (heap instanceof Node) {
            Node leaf = (Node)heap;

               arr.add(leaf.value+": "+binaryCode);
            
               total = total + (leaf.frequency * binaryCode.length());
               
              
 
        } else if (heap instanceof HuffmanNode) {
        	
            HuffmanNode node = (HuffmanNode)heap;
 
            int x = 0;
            for(int i = 0; i < binaryCode.length(); i++)
                     x = binaryCode.length();
            
            binaryCode.append(zero);
            
            binaryCodeHeap(node.left, binaryCode);
            
            binaryCode.deleteCharAt(binaryCode.length()-1);
 

            binaryCode.append(one);
            
            binaryCodeHeap(node.right, binaryCode);
            
            binaryCode.deleteCharAt(binaryCode.length()-1);
        }
    }
 
    

	private static void displayHeap() {
		// TODO Auto-generated method stub
		
		btd.add(1);
		btd.add(2);
		btd.add(4);
		btd.add(8);
		btd.add(16);
		btd.add(32);
		btd.add(64);
		btd.add(128);
		
		//System.out.println(btd);
		Comparator<String> lengthComparator = new Comparator<String>() { 
		    int dec = 0;
			@Override public int compare(String e1, String e2) { 
				//if(e1.length() != e2.length()){
				if(binarToDecimal(e1) != binarToDecimal(e2)){
					//binarToDecimal(e1);
					//return e1.length() - e2.length();
					return binarToDecimal(e1) - binarToDecimal(e2);
				}
				else if(binarToDecimal(e1) == binarToDecimal(e2))
				   return e1.length() - e2.length();
				else
					return e1.compareTo(e2); 
				}

			private int binarToDecimal(String e1) {
				// TODO Auto-generated method stub
				ArrayList<Integer> d = new ArrayList<Integer>();
				for(int i = 0; i < e1.length(); i ++){
					if(e1.charAt(i) == '0' || e1.charAt(i) == '1')
						if(e1.charAt(i) == '0')
							d.add(0);
						else
							d.add(1);
//					System.out.println(e1.charAt(i));
				}
				//System.out.println("d is"+d);
				Collections.reverse(d);
				dec = 0;
				int ind = 0;
			
				for(Integer item: d){

						dec = dec + (item * btd.get(ind));
					ind++;
					
				}
				//System.out.println("deci is"+ dec);
				return dec;
					
			} 
			}; 
    	
			Collections.sort(arr,lengthComparator);
			for(String s:arr)
	    		System.out.println(s);
	}
    
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    
	    return true;
	}



	public void initialize(char[] inputChar, int[] fr) {
		// TODO Auto-generated method stub
		HuffmanAlgorithm heap = createHeap(fr,inputChar);
		           
	   binaryCodeHeap(heap, new StringBuffer());
		        
	   displayHeap();
		       
	   System.out.println(total);
		
	}
}