
import java.util.Scanner;

/*
 * n=2이면 1x2 타일 2개로 만들거나 n=1일때 경우에 2x1타일 채우기
 * n이 k면 k-2번째까지의 경우의 수 + k-1번째 경우의 수
 */
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int[] dp=new int[1001];
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%10007;
		}
		
		System.out.println(dp[N]);
	}

}
