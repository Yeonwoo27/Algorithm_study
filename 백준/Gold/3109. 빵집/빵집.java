
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	public static int R,C;
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] dx= {-1,0,1};
	public static int[] dy= {1,1,1};
	public static int ans=0;
	public static boolean isfinished=false;	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new char[R][C];
		visited=new boolean[R][C];
		for(int i=0;i<R;i++) {
			String str=br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		visited=new boolean[R][C];
		for(int i=0;i<R;i++) {
			isfinished=false;
			
			dfs(i,0);
		}

		
		System.out.println(ans);
		
		
	}
	public static void dfs(int x, int y ) {
		if(isfinished) return;
		
		visited[x][y]=true;
		
		if(y==C-1) {
			isfinished=true;
			ans++;
			return;
		}

		for(int i=0;i<3;i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			
			if(cx<0||cx>=R) continue;
			
			if(arr[cx][cy]=='.'&&!visited[cx][cy]&&!isfinished) {
				visited[cx][cy]=true;
				 dfs(cx,cy);
			}
			
			
		}
	}
}
