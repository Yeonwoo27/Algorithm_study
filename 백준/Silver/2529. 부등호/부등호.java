
import java.io.*;
import java.util.*;
import java.util.*;
public class Main {
	
	
	public static int K;
	public static String[] signs;
	public static boolean[] visited=new boolean[10];
	public static List<String> numbers=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		
		K=sc.nextInt();
		signs=new String[K];
		for(int i=0;i<K;i++) {
			
			signs[i]=sc.next();
		}
		
		for(int i=0;i<=9;i++) {
			visited[i]=true;
			dfs(i,0,i+"");
		}
		System.out.println(numbers.get(numbers.size()-1));
		System.out.println(numbers.get(0));
	}
	public static void dfs(int number, int number_idx, String str) {
		if(number_idx==K) {
			numbers.add(str);
		}
		else {
			for(int i=0;i<=9;i++) {
				if(!visited[i]) {
					if(signs[number_idx].equals(">")) {
						if(number<=i) continue;
					}
					else{
						if(number>=i) continue;
					}
					visited[i]=true;
					dfs(i,number_idx+1,str+i);
				}
			}
		}
		visited[number]=false;
		
	}
	
	
	
}
