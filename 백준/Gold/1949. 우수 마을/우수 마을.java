
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static ArrayList<Integer>[] list;
	public static int[][] dp;
	public static int[] citizenNum;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		dp=new int[N+1][2];
		citizenNum=new int[N+1];
	
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			citizenNum[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		cal(1,0);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
	}
	public static void cal(int now,int parent) {
		
		for(int road : list[now]) {
			if(road!=parent) {
				cal(road,now);
				dp[now][0]+=Math.max(dp[road][0], dp[road][1]);
				dp[now][1]+=dp[road][0];
		}
		
		
	}
		dp[now][1]+=citizenNum[now];
	}
}
