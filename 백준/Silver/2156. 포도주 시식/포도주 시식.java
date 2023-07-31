
import java.util.*;
import java.io.*;

public class Main {

		public static int[] arr;
		
		public static boolean[][] visited;
		public static int[] dx= {0,1,-1,0};
		public static int[] dy= {1,0,0,-1};
		public static int[] ddx= {1,1,-1,-1};
		public static int[] ddy= {1,-1,1,-1};
		
		
		public static int N;
		public static int max=0;
		
		
		public static void dfs(int x, int y,int index,int height) {
				
			
		}
		
		public static void main(String[] arg) throws IOException{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//StringTokenizer st= new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(br.readLine());
			
			arr=new int[N+1];
			int[] dp=new int[N+1];
			
			for(int i=1;i<=N;i++) {
				arr[i]=Integer.parseInt(br.readLine());
			}
			
			dp[1]=arr[1];
			
			if(N>1) {
				dp[2]=arr[1]+arr[2];
			}
			
			for(int i=3;i<=N;i++) {
				dp[i]=Math.max(Math.max(dp[i-1], dp[i-2]+arr[i]),dp[i-3]+arr[i-1]+arr[i] );
			}
			
			System.out.println(dp[N]);
		}
		
	
		
		
		
	

}
