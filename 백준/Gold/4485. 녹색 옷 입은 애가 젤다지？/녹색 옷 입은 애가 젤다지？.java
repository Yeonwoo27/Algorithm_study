

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	public static int N;
	public static int[][] arr;
	public static int[][] dist;
	public static int[] dx= {-1,0,1,0};
	public static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb=new StringBuilder();
		
		int num=1;
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			if(N==0) break;
			
			
			arr=new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			dijkstra();
			
			sb.append("Problem ");
			sb.append(num);
			sb.append(": ");
			sb.append(dist[N-1][N-1]);
			sb.append("\n");
			num++;
		}
		
		System.out.println(sb);
	}
	public static void dijkstra() {
		dist=new int[N][N];
		boolean[][] visited= new boolean[N][N];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[0][0] = arr[0][0];	
		pq.offer(new Node(0, 0, arr[0][0]));
		
		while(!pq.isEmpty()) {
			Node current=pq.poll();
			int x=current.x;
			int y=current.y;
			int weight=current.weight;
			
			if(visited[x][y]) continue;
			
			visited[x][y]=true;
			if(x==N-1&&y==N-1) return;
			
			for(int i=0;i<4;i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				
				if(cx<0||cy<0||cx>=N||cy>=N) continue;
				
				if(!visited[cx][cy]&&dist[cx][cy]>dist[x][y]+arr[cx][cy]) {
					dist[cx][cy]=dist[x][y]+arr[cx][cy];
					pq.add(new Node(cx,cy,dist[cx][cy]));
				}
					
				
			}
			
		}
	}
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int weight;
		public Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight-o.weight;
		}
		
	}

}
