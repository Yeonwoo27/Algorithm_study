
import java.io.*;
import java.util.*;
public class Main {
	public static int N,M;
	public static int[][] arr;
	public static boolean[][] visited;
	
	public static int[] dx= {-1,0,1,0};
	public static int[] dy=	{0,1,0,-1};
	public static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		visited=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited[i][j]=true;
				dfs(i,j,1,arr[i][j]);
				sum(i,j);
				visited[i][j]=false;
			}
		}
		
		System.out.println(max);
		
		
		
	}
	public static void dfs(int x, int y,int cnt,int sum) {
		//4칸 짜리 테트로미노를 놓을 때 마다 종이전체를 탐색한다.
		
		if(cnt==4) {					
			max=Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			
			if(cx<0||cy<0||cx>=N||cy>=M) continue;
			
			if(!visited[cx][cy]) {
				visited[cx][cy]=true;
				dfs(cx,cy,cnt+1,sum+arr[cx][cy]);
				visited[cx][cy]=false;
			}
		}
		
		
	}
	public static void sum(int x, int y) {
		for(int k=0;k<4;k++) {
			int sum=arr[x][y];
			for(int i=0;i<4;i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				
				if(cx<0||cy<0||cx>=N||cy>=M) continue;
				
				if(i!=k) {
					sum+=arr[cx][cy];
				}
			}
			max=Math.max(max, sum);
		}
		
		
	}
	
}
