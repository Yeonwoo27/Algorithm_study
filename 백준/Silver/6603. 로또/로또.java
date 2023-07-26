
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	
	public static int N,M;
	public static int[] arr;
	public static boolean[] visited;
	public static int Max=Integer.MAX_VALUE;
	public static ArrayList<int[]> list=new ArrayList<>();
	
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		
		while(true) {
			list.clear();
			N=sc.nextInt();
			if(N==0) break;
			
			arr=new int[N];
			visited=new boolean[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			
			dfs(0,0);
			for(int i=0;i<list.size();i++) {
				int[] newlist=list.get(i);
				for(int j=0;j<6;j++) {
					System.out.print(newlist[j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		
	
		
	}
	public static void dfs(int start,int cnt) {
		if(cnt==6) {
			int idx=0;
			int[] ans=new int[6];
			for(int i=0;i<N;i++) {
				if(visited[i]) ans[idx++]=arr[i];
			}
			list.add(ans);
			return;
		}
		for(int i=start;i<N;i++) {
			visited[i]=true;
			dfs(i+1,cnt+1);
			visited[i]=false;
		}
	}
	
}
