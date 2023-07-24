
import java.util.*;
public class Main {
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static int T,M,N,K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		int[] testList=new int[T];
		for(int t=0;t<T;t++) {
			int result=0;
			M=sc.nextInt();
			N=sc.nextInt();
			K=sc.nextInt();
			arr=new int[N][M];
			visited=new boolean[N][M];
			for(int i=0;i<K;i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				arr[y][x]=1;
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]==1&&!visited[i][j]) {
						dfs(i,j);
						result++;
					}
				}
			}
			testList[t]=result;
		}
		for(int i=0;i<testList.length;i++) {
			System.out.println(testList[i]);
		}
	}
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cy<0||cx>=N||cy>=M) continue;
			
			if(arr[cx][cy]==1&&!visited[cx][cy]) {
				dfs(cx,cy);
			}
		}
	}

}
