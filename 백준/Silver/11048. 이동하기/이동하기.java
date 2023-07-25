
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
		
		arr=new int[N+1][M+1];
		dp=new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				dp[i][j]=Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+arr[i][j];
			}
		}
		
		System.out.println(dp[N][M]);
		
	}
}
