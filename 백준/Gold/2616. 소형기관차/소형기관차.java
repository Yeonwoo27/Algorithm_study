
import java.io.*;
import java.util.*;
public class Main {
	
	public static int N,M;
	public static int[] train;
	public static int[] sum;	// i번 까지의 손님 수의 저장
	public static int[][] dp; // 기관차 i대로 j칸의 객차를 끌 수 있는 경우
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		train=new int[N+1];
		sum=new int[N+1];
		dp=new int[4][N+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			train[i]=Integer.parseInt(st.nextToken());
			sum[i]=sum[i-1]+train[i];
		}
		
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		for(int i=1;i<4;i++) {
			for(int j=i*M;j<=N;j++) {
				dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j-M]+(sum[j]-sum[j-M]));//점화식
			}
		}
		System.out.println(dp[3][N]);
		
	}
	
	
	
	
}
