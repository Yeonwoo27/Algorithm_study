
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	public static int N;
	public static ArrayList<Integer>[] list;
	public static int[][] dp;
	public static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		
		N=Integer.parseInt(st.nextToken());
		dp=new int[N+1][2];
		list=new ArrayList[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		dp(1);
		
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	public static void dp(int x) {
		visited[x]=true;
		
		for(int num : list[x]) {
			if(!visited[num]) {
				dp(num);
				
				dp[x][0]+=dp[num][1];
				dp[x][1]+=Math.min(dp[num][0], dp[num][1]);
			}
		}
		
		dp[x][1]++;
		
	}

}
