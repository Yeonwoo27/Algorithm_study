import java.util.Scanner;

public class Main{
	public static StringBuilder sb=new StringBuilder();
	public static int[] num=new int[6];
	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);

		while(true) {
			sb.setLength(0);
			N=sc.nextInt();
			if(N==0) break;
			int[] arr=new int[N];
			boolean[] visited=new boolean[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			dfs(0,0,arr,visited);
			System.out.println(sb);
			
		} 
	}
	public static void dfs(int start,int idx,int[] arr, boolean[] visited) {
		if(idx==6) {
			for(int i=0;i<6;i++) {
				sb.append(num[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				num[idx]=arr[i];
				dfs(i+1,idx+1,arr,visited);
				visited[i]=false;
			}
		}
		
	}

}
