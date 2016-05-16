import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
public class ArrayTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		ArrayList<Integer> a = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(input,",");
		int index = 0;
		while(st.hasMoreTokens()){
			a.add(Integer.parseInt(st.nextToken()));
			index++;
		}
		
	
		
		int[] array = new int[index];
		int y = 0;
		for(Integer j : a ){
	
			array[y] = j;
			y++;
		}
		

		subset(a);
	}

	private static void subset(ArrayList<Integer> a) {
		// TODO Auto-generated method stub
		ArrayList<String> ele = new ArrayList<String>();
		int min = Integer.MIN_VALUE;
		
		ele.add(min+"");
		ele.add("Null");
		

		for(int k = 0; k < a.size(); k++) {
			int i = k;
			while(i < a.size()) {
				int count = 0;
				String str = "";
				int j = k;
				while(j <= i){
					if (!str.equals("0,")){
						count += a.get(j);
						str = str+a.get(j)+",";
					}
					j++;
				}
				if (count >= Integer.parseInt(ele.get(0))) {
					ele.set(0, count+"");
					ele.set(1, str);
				}
				i++;
			} 
		
		}
		if (Integer.parseInt(ele.get(0)) < 0) {
			System.out.println("0");
			System.out.println("Maximum sum is less than 0.");
		}else {
			System.out.println(ele.get(0));
			int first = ele.get(1).length()-2;
			int second = ele.get(1).length()-1;
			String s = ele.get(1).substring(first,second);
			if (s.equals("0")) {
				int x = ele.get(1).length()-3;
				System.out.println(ele.get(1).substring(0,x));
			} else {
				int x = ele.get(1).length()-1;
				System.out.println(ele.get(1).substring(0,x));
			}
		}
	}
}
