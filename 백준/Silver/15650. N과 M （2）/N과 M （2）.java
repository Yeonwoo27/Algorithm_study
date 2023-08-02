import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static int N,M;
	public static int[] num;
	public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		visited=new boolean[N];
		num=new int[M];
		permutation(0,0);
		
		System.out.println(sb);

	}
	public static void permutation(int start,int cnt) {
		if(cnt==M) {
			for(int i=0;i<cnt;i++) {
				sb.append(num[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				num[cnt]=i+1;
				permutation(i+1,cnt+1);
				visited[i]=false;
			}
		}
	}
}
