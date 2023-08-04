

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N,S;
	public static int[] arr;
	public static boolean[] visited;
	public static int ans=0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		arr=new int[N];
		visited=new boolean[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs();
		
		System.out.println(ans);
		
	}
	public static void dfs() {
		
		for(int i=0;i<(1<<N);i++) {
			int sum=0;
			int num=0;
			for(int j=0;j<N;j++) {
				if((i&(1<<j))!=0) {
					sum+=arr[j];
					num++;
				}
			}
			if(sum==S&&num!=0) ans++;
		}
			
		
	}

}
