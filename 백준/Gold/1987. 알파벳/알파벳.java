
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int R,C;
	public static char[][] arr;
	public static boolean[] alpha=new boolean[26]; //알파벳 방문배열
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new char[R][C];
		
		for(int i=0;i<R;i++) {
			String str=br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		alpha[arr[0][0]-'A']=true; //(0,0)에 있는 알파벳을 먼저 방문배열에 넣어둔다.
		dfs(0,0,1);
		
		System.out.println(max);
	}
	public static void dfs(int x, int y, int cnt) { //dfs함수 실행

		for(int i=0;i<4;i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			
			if(cx<0||cy<0||cx>=R||cy>=C) continue;
			
			if(!alpha[arr[cx][cy]-'A']) { //다음칸에 있는 알파벳이 방문한적 없는 알파벳이면 실행
				alpha[arr[cx][cy]-'A']=true; //방문배열에 넣고 dfs실행
				dfs(cx,cy,cnt+1);
				alpha[arr[cx][cy]-'A']=false;
			}
		}
		max=Math.max(max, cnt); //최대로 탐색한 후 max값과 비교해서 더 큰값을 넣는다.
	}

}
