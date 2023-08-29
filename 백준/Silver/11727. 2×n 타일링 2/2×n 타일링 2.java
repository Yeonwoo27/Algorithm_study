
import java.util.Scanner;

/*
 * 앞의 경우의 수에서 1x2블럭 2개로 2칸을 채우는걸 2x2로도 가능
 * 즉, n이 k번째일때 k-1번째까지의 경우의 수 + k-2번째 까지의 경우의 수 *2
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int[] dp=new int[1001];
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
		}
		
		System.out.println(dp[N]);

	}

}
