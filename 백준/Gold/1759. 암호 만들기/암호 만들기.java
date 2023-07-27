
import java.io.*;
import java.util.*;
public class Main {
	
	
	public static int L,C;
	public static String[] alpha;
	public static boolean[] visited;
	public static List<String> list=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		
		L=sc.nextInt();
		C=sc.nextInt();
		alpha=new String[C];
		visited=new boolean[C];
		for(int i=0;i<C;i++) {
			
			alpha[i]=sc.next();
		}
		
		Arrays.sort(alpha);
		dfs(0,0,"");
		
		for(String s : list) {
			System.out.println(s);
		}
		
	}
	public static void dfs(int start,int cnt,String str) {
		if(cnt==L) {
			if(check(str)) {
				list.add(str);
				return;
			}
		}
		for(int i=start;i<C;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i+1,cnt+1,str+alpha[i]);
				visited[i]=false;
			}
			
		}
		
	}
	public static boolean check(String st) {
		int ja=0;
		int mo=0;
		for(int i=0;i<st.length();i++) {
			char c=st.charAt(i);
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') mo++;
			else ja++;	
		}
		if(mo>=1&&ja>=2) return true;
		else return false;
	}
}
