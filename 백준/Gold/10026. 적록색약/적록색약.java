
import java.util.*;
import java.io.*;
public class Main {
	
	public static boolean[][] visited;
	public static char[][] arr;
	public static int N;
	public static String str;
	public static int[] dx= {-1,0,0,1};
	public static int[] dy= {0,1,-1,0};
	
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   Scanner sc=new Scanner(System.in);
		int ans1=0,ans2=0;
		N=sc.nextInt();
		sc.nextLine();
		arr=new char[N+1][N+1];
		visited=new boolean[N+1][N+1];
		
		for(int i=0;i<N;i++) {
			
			str=sc.nextLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					ans1++;
				}
			}
		}
		visited=new boolean[N+1][N+1];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]=='G') arr[i][j]='R';
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					ans2++;
				}
			}
		}
		
		
		System.out.println(ans1+" "+ans2);
		
		
	}
	
	public static void dfs(int x, int y) {
		visited[x][y]=true;
		char check=arr[x][y];
		for(int i=0;i<4;i++) {
			int new_x=x+dx[i];
			int new_y=y+dy[i];
			
			if(new_x<0||new_x>N||new_y<0||new_y>N) {
				continue;
			}
			if(!visited[new_x][new_y]&&arr[new_x][new_y]==check) {
				dfs(new_x,new_y);
			}
		}
		
		
	}
	
}
