
import java.io.*;
import java.util.*;

public class Main {

	public static int M,N,H;
	public static int[][] arr;
	public static int min=Integer.MAX_VALUE;
	public static int ans; // 추가된 가로선
	public static boolean finish=false; // 끝까지 만족을 못시키고 중간에 끝나면 true로 변경됨
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken()); //세로 선의 개수
		M=Integer.parseInt(st.nextToken()); //놓여진 고정 가로 선의 개수
		H=Integer.parseInt(st.nextToken()); //고정 가로선을 놓을 수 있는 임시 가로선의 개수
		arr=new int[H+1][N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=1;	//a높이 b번째 세로선에서 오른쪽으로 이동 가능(1)
			arr[a][b+1]=2;	//a높이 b+1번째 세로선에서  왼쪽으로 이동 가능(2)
		}
		
		//놓는 가로선의 개수를 0개~3개라고 가정하고 시작.
		// dfs함수를 통해 정해진 개수만큼 가로선을 놓고 사다리를 탄다.
		//0부터 시작하므로 사다리타는데 성공한다면 그게 최소값이다.
		for(int i=0;i<=3;i++) {
			ans=i;
			dfs(1,0); //1 높이에서 시작 
			if(finish) break;
		}
		System.out.println(finish?ans:"-1");
		 
		
	}
	public static void dfs(int r,int cnt) {
		if(finish) return; //이미 finish 상태면 return
		
		if(cnt==ans) { 
			if(check()) {
				finish=true;
				return;
			}
			return;
		}
		for(int i=r;i<=H;i++) {
			for(int j=1;j<N;j++) {
				if(arr[i][j]==0&&arr[i][j+1]==0) {
					arr[i][j]=1; //오른쪽에 길 생김
					arr[i][j+1]=2; //왼쪽에 길 생김
					dfs(i,cnt+1); //처음부터 시작하면 안되므로 i부터
					arr[i][j]=0;
					arr[i][j+1]=0;
				}
			}
		}
}
	//아래는 사다리 실행 함수. 1~N번째 세로선에서 모두 성공하면 true 리턴. 그전에 멈추면 false 리턴
	public static boolean check() {
		for(int i=1;i<=N;i++) {
			int r=1,c=i;
			for(int j=1;j<=H;j++) {
				if(arr[r][c]==1) c++; //1을 만나면 오른쪽으로
				else if(arr[r][c]==2) c--; //2를 만나면 왼쪽으로
				r++;					//항상 아래로 이동
			}
			if(c!=i) return false; //출발선인 i와 도착 시 열의 값 c가 같지 않으면 false 리턴
		}
		return true;
	}
	
}
	



