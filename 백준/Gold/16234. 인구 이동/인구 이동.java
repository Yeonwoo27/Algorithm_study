import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N,L,R;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static boolean movecheck;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		arr= new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int ans=0;
		
		while(true) {
			visited=new boolean[N][N];
			movecheck=false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			
			if(!movecheck) break;
			ans++;
		}
		
		System.out.println(ans);
		
		
		
	}
	
	public static void bfs(int x, int y) {
		ArrayList<Node> moveCountry=new ArrayList<>(); //인구 이동이 발생하는 나라들
		Queue<Node> q=new LinkedList<>();
		int sum=0; //인구 이동이 발생하는 나라들의 인구수 총합
		
		q.add(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node current=q.poll();
			int x1=current.x;
			int y1=current.y;
			
			for(int i=0;i<4;i++) {
				int cx=x1+dx[i];
				int cy=y1+dy[i];
				
				if(cx<0||cy<0||cx>=N||cy>=N) continue;
				if(visited[cx][cy]) continue;
				
				int gap=Math.abs(arr[x1][y1]-arr[cx][cy]); //두 나라의 인구수 차이 
				if(gap>=L&&gap<=R) { //인구수 차이가 범위 내에 있다면
					movecheck=true;
					sum+=arr[cx][cy];
					moveCountry.add(new Node(cx,cy));
					q.add(new Node(cx,cy));
					visited[cx][cy]=true;
				}
			}
			
		}
		visited[x][y]=true;
		if(moveCountry.size()>0) {
			sum=sum/moveCountry.size();
			for(int i=0;i<moveCountry.size();i++) {
				int r=moveCountry.get(i).x;
				int c=moveCountry.get(i).y;
				
				arr[r][c]=sum;
			}
		}
		
		
	}

	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}