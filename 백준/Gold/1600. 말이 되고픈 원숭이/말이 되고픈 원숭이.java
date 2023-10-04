

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  K : 말의 움직임으로 이동할 수 있는 횟수
 *  격자판은 arr[H][W]
 *  최단거리 구하기니깐 BFS로 해야할 것 같다.
 *  K와 현재까지 이동한 거리를 포함하는 Node를 활용해야 할 것 같다.
 *  말의 움직임을 가지는 방향벡터도 선언해야 할듯 
 */
public class Main {
	public static int[][] arr;
	public static int K,W,H;
	public static boolean[][][] visited;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static int[] hx= {-1,-2,-2,-1,1,2,2,1};
	public static int[] hy= {-2,-1,1,2,2,1,-1,-2};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		K=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		arr=new int[H][W];
		visited=new boolean[K+1][H][W];
		for(int i=0;i<H;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(-1);
	}
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(0,0,K,0));
		visited[K][0][0]=true;
		while(!q.isEmpty()) {
			Node current=q.poll();
			int x=current.x;
			int y=current.y;
			int k=current.k;
			int m=current.m;
			
			if(x==H-1 && y==W-1) { //도착점에 도달했으면 결과 출력 및 종료
				System.out.println(m);
				System.exit(0);
			}
			for(int i=0;i<4;i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				
				if(cx<0||cy<0||cx>=H||cy>=W) continue;
				if(arr[cx][cy]==1) continue;
				if(visited[k][cx][cy]) continue;
				visited[k][cx][cy]=true;
				q.add(new Node(cx,cy,k,m+1));
				
			}
			if(k>0) {
				for(int i=0;i<8;i++) {
					
					int cx=x+hx[i];
					int cy=y+hy[i];
					
					if(cx<0||cy<0||cx>=H||cy>=W) continue;
					if(arr[cx][cy]==1) continue;
					if(visited[k-1][cx][cy]) continue;
					visited[k-1][cx][cy]=true;
					q.add(new Node(cx,cy,k-1,m+1));
					
				}
			}
			
		}
	}
	
	public static class Node{
		int x;
		int y;
		int k;
		int m;
		public Node(int x, int y, int k, int m) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.m = m;
		}
		
	}
}
