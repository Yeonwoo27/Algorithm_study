
import java.util.*;
public class Main {
	public static int N,M;
	public static int[][] arr;
	public static int[][] dp;
	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N+1][N+1];
		dp=new int[N+1][N+1];
		
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=sc.nextInt();
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
			}
		}
		int[] sumList=new int[M];
		for(int i=0;i<M;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			sumList[i]=dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
		}
		for(int i=0;i<M;i++) {
			System.out.println(sumList[i]);
		}
		
	}
 	

}
