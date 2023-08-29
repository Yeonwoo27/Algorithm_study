
import java.util.Scanner;

/*
 * dp[1]=1
 * dp[2]=dp[1]+dp[0]=2
 * dp[3]=dp[1]+dp[2]+dp[0]=1+2+1=4
 * dp[4]=dp[3]+dp[2]+dp[1]=4+2+1=4
 * dp[5]=
 */
public class Main{

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int[] dp=new int[11];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4;i<11;i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		for(int t=0;t<T;t++) {
			
			int n=sc.nextInt();
			
			System.out.println(dp[n]);
		}
	}

}
