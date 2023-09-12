

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] arr = new int[1001][3];
		int[][] dp ;
		int min = 1000001;

		int N = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
			dp=new int[1001][3];
			dp[2][0]=Math.min(arr[1][1], arr[1][2])+arr[2][0];
			dp[2][1]=arr[1][2]+arr[2][1];
			dp[2][2]=arr[1][1]+arr[2][2];
			for(int j=3;j<N;j++) {
				dp[j][0]=Math.min(dp[j-1][1], dp[j-1][2])+arr[j][0];
				dp[j][1]=Math.min(dp[j-1][0], dp[j-1][2])+arr[j][1];
				dp[j][2]=Math.min(dp[j-1][0], dp[j-1][1])+arr[j][2];
			}
			
			min=Math.min(dp[N-1][1]+arr[N][0], dp[N-1][2]+arr[N][0]);
			
			dp=new int[1001][3];
			dp[2][0]=arr[1][2]+arr[2][0];
			dp[2][1]=Math.min(arr[1][0], arr[1][2])+arr[2][1];
			dp[2][2]=arr[1][0]+arr[2][2];
			for(int j=3;j<N;j++) {
				dp[j][0]=Math.min(dp[j-1][1], dp[j-1][2])+arr[j][0];
				dp[j][1]=Math.min(dp[j-1][0], dp[j-1][2])+arr[j][1];
				dp[j][2]=Math.min(dp[j-1][0], dp[j-1][1])+arr[j][2];
			}
			min=Math.min(min, Math.min(dp[N-1][0]+arr[N][1], dp[N-1][2]+arr[N][1]));
			
			dp=new int[1001][3];
			dp[2][0]=arr[1][1]+arr[2][0];
			dp[2][1]=arr[1][0]+arr[2][1];
			dp[2][2]=Math.min(arr[1][0], arr[1][1])+arr[2][2];
			for(int j=3;j<N;j++) {
				dp[j][0]=Math.min(dp[j-1][1], dp[j-1][2])+arr[j][0];
				dp[j][1]=Math.min(dp[j-1][0], dp[j-1][2])+arr[j][1];
				dp[j][2]=Math.min(dp[j-1][0], dp[j-1][1])+arr[j][2];
			}
			min=Math.min(min, Math.min(dp[N-1][0]+arr[N][2], dp[N-1][1]+arr[N][2]));
		
		System.out.println(min);
	}

}
