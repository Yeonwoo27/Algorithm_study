
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static int[][] arr;
	public static int[][] copy_arr;
	public static int[] order;
	
	public static int[] dx= {-1,0,1,0}; //상 우 하 좌
	public static int[] dy= {0,1,0,-1};
	public static ArrayList<int[]> list=new ArrayList<>();
	
	public static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0&&arr[i][j]!=6) list.add(new int[] {i,j,arr[i][j]});
			}
		}
		order=new int[list.size()];
		
		permutation(0,list.size());
		
		System.out.println(ans);
	}
	public static void permutation(int cnt,int length) {
		if(cnt==length) {
			copy_arr=new int[N][M];
			for(int i=0;i<N;i++) { //배열 복사
				System.arraycopy(arr[i],0, copy_arr[i], 0, arr[i].length);
			}
			
			for(int i=0; i<list.size();i++) { //cctv번호와 방향 설정
				direction(list.get(i),order[i]); 
			}
			blind_check(); //사각 지대 탐색
			return;
		}
		for(int i=0;i<4;i++) { //중복순열. cctv끼리 같은 방향을 가질 수 있으므로
			order[cnt]=i;
			permutation(cnt+1,length);
		}
	}
	public static void direction(int[] cctv,int d) { //cctv가 번호에 따라 작동하는 함수
		
		int cctv_num=cctv[2];
		
		switch (cctv_num) {
		case 1:
			if(d==0) check(cctv,0);
			else if(d==1) check(cctv,1);
			else if(d==2) check(cctv,2);
			else if(d==3) check(cctv,3);
			break;
		case 2:
			if(d==0||d==2) {
				check(cctv,0);
				check(cctv,2);
			}
			if(d==1||d==3) {
				check(cctv,1);
				check(cctv,3);
			}
			break;
		case 3:
			
			if(d==0) {
				check(cctv,0);
				check(cctv,1);
			}
			else if(d==1) {
				check(cctv,1);
				check(cctv,2);
			}
			else if(d==2) {
				check(cctv,2);
				check(cctv,3);
			}
			else if(d==3) {
				check(cctv,0);
				check(cctv,3);
			}
			
			break;
		case 4:
			
			if(d==0) {
				check(cctv,0);
				check(cctv,1);
				check(cctv,3);
			}
			else if(d==1) {
				check(cctv,0);
				check(cctv,1);
				check(cctv,2);
			}
			else if(d==2) {
				check(cctv,1);
				check(cctv,2);
				check(cctv,3);
			}
			else if(d==3) {
				check(cctv,0);
				check(cctv,2);
				check(cctv,3);
			}
			break;
		case 5:
			check(cctv,0);
			check(cctv,1);
			check(cctv,2);
			check(cctv,3);
			break;
		default:
			break;
		}
		
	}
	public static void check(int[]cctv, int dir) { //bfs로 탐색
		Queue<int[]> q=new LinkedList<>();
		
		
		q.add(cctv);
		
		
		while(!q.isEmpty()) {
			int[] current=q.poll();
			int cx=current[0]+dx[dir];
			int cy=current[1]+dy[dir];
			
			if(cx<0||cy<0||cx>=N||cy>=M||copy_arr[cx][cy]==6) break;
			
			if(copy_arr[cx][cy]==0) {
				copy_arr[cx][cy]=-1; //감시할 수 있는 곳에 -1 대입하고 큐에 넣고
				q.add(new int[] {cx,cy});
			}
			else {
				q.add(new int[] {cx,cy}); //이미 감시된곳이면 그냥 바로 큐에 넣기
			}
		}
		
	}
	public static void blind_check() {
		int blind_num=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copy_arr[i][j]==0) blind_num++;
			}
		}
		ans=Math.min(ans, blind_num);
	}

}
