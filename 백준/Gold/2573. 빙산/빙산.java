
import java.util.*;
public class Main {
	public static int N,M;
	public static int[][] arr;
	public static int[][] visited;
	public static int[][] melt;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N][M];
		visited=new int[N][M];
		melt=new int[N][M];
		int year=0;
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		while(true) {
			int count=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]!=0&&visited[i][j]==0) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			if(count==0) {
				System.out.println(0);
				break;
			}
			if(count>=2) {
				System.out.println(year);
				break;
			}
			bfs();
			year++;
		}
		
	}
 	public static void dfs(int x, int y) {
 		visited[x][y]=1;
 		
 		for(int i=0;i<4;i++) {
 			int cx=x+dx[i];
 			int cy=y+dy[i];
 			
 			if(cx<0||cy<0||cx>=N||cy>=M) continue;
 			if(arr[cx][cy]==0) {
 				melt[x][y]++;
 			}
 			if(arr[cx][cy]!=0&&visited[cx][cy]==0) {
 				dfs(cx,cy);
 			}
 				
 			
 		}
 	}
 	public static void bfs() {
 		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0) {
					if(arr[i][j]-melt[i][j]<0) {
						arr[i][j]=0;
					}
					else {
						arr[i][j]=arr[i][j]-melt[i][j];
					}
					visited[i][j]=0;
					melt[i][j]=0;
				}
				
			}
		}
 		
 		
 	}

}
