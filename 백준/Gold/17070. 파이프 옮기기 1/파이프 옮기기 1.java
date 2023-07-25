
import java.util.*;

public class Main {
	
	
	public static int N;
	public static int[] dx= {0,1,1};	//가로, 대각, 세로
	public static int[] dy= {1,1,0};
	public static int[][] arr;
	public static int ans=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();	
		
		arr=new int[N+2][N+2];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		dfs(1,2,0);
		System.out.println(ans);
		
	}
	public static void dfs(int x, int y,int dir) { // dir==0 이면  가로, dir==1 이면  대각, dir==2 이면  세로
		if(x==N&&y==N) {
			ans++;
			return;
		}
		if(dir==0) {    //가로 상태라면 그다음은 가로 or 대각
			if(y+1<=N&&arr[x+dx[0]][y+dy[0]]!=1) {
				dfs(x+dx[0],y+dy[0],0);
			}
			if(x+1<=N&&y+1<=N&&arr[x+dx[0]][y+dy[0]]!=1&&arr[x+dx[1]][y+dy[1]]!=1&&arr[x+dx[2]][y+dy[2]]!=1) {
				
				dfs(x+dx[1],y+dy[1],1);
				
			}
		}
		else if(dir==1) {    //대각 상태라면 그다음은 가로 or 대각 or 세로
			if(y+1<=N&&arr[x+dx[0]][y+dy[0]]!=1) {
				dfs(x+dx[0],y+dy[0],0);
			}
			if(x+1<=N&&y+1<=N&&arr[x+dx[0]][y+dy[0]]!=1&&arr[x+dx[1]][y+dy[1]]!=1&&arr[x+dx[2]][y+dy[2]]!=1) {
				
				dfs(x+dx[1],y+dy[1],1);
				
			}
			if(x+1<=N&&arr[x+dx[2]][y+dy[2]]!=1) {
				dfs(x+dx[2],y+dy[2],2);
			}
		}
		else if(dir==2) {    //세로 상태라면 그다음은 대각 or 세로
			if(x+1<=N&&arr[x+dx[2]][y+dy[2]]!=1) {
				dfs(x+dx[2],y+dy[2],2);
			}
			if(x+1<=N&&y+1<=N&&arr[x+dx[0]][y+dy[0]]!=1&&arr[x+dx[1]][y+dy[1]]!=1&&arr[x+dx[2]][y+dy[2]]!=1) {
				
				dfs(x+dx[1],y+dy[1],1);
				
			}
		}
		
	}
}
