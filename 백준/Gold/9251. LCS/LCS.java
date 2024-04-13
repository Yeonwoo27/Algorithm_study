
import java.util.*;
import java.io.*;

public class Main {

		public static int[][] arr;
		
		public static boolean[][] visited;
		public static int[] dx= {0,1,-1,0};
		public static int[] dy= {1,0,0,-1};
		public static int[] ddx= {1,1,-1,-1};
		public static int[] ddy= {1,-1,1,-1};
		
		
		public static String N,K;
		public static int max=0;
		
		
		public static void dfs(int x, int y,int index,int height) {
				
			
		}
		
		public static void main(String[] arg) throws IOException{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//StringTokenizer st= new StringTokenizer(br.readLine());
			
			N=br.readLine();
			K=br.readLine();
			
			char[] R=N.toCharArray();
			char[] C=K.toCharArray();
			int[][] dp=new int[R.length+1][C.length+1];
			
			
			for(int i=1;i<=R.length;i++) {
				for(int j=1;j<=C.length;j++) {
					if(R[i-1]==C[j-1]) {
						dp[i][j]=dp[i-1][j-1]+1;
					}
					else {
						dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			System.out.println(dp[R.length][C.length]);
		}
		
	
		
		
		
	

}
