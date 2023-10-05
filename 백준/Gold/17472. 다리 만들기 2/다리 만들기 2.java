

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static int[] parents;
	public static int result=0;
	public static int bridge_count=0;
	public static PriorityQueue<Pair> pq=new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		visited=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int island=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					island++;
					bfs(i,j,island);
					
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0) {
					makebridge(i,j,arr[i][j]);
				}
			}
		}
		
		parents=new int[island+1];
		for(int i=0;i<parents.length;i++) {
			parents[i]=i;
		}
		
		int size=pq.size();
		for(int i=0;i<size;i++) {
			Pair tmp=pq.poll();
			int a=find(tmp.s);
			int b=find(tmp.e);
			
			if(a==b) continue;
			
			union(tmp.s,tmp.e);
			result+=tmp.v;
			bridge_count++;
		}
		
		if(result==0||bridge_count!=island-1) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		
		
		
		

	}
	public static void bfs(int x, int y,int num){
		Queue<Node> q=new LinkedList<>(); 
		q.add(new Node(x,y));
		arr[x][y]=num;
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			Node current=q.poll();
			int nx=current.x;
			int ny=current.y;
			
			for(int i=0;i<4;i++) {
				int cx=nx+dx[i];
				int cy=ny+dy[i];
				
				if(cx<0||cy<0||cx>=N||cy>=M) continue;
				if(arr[cx][cy]==0) continue;
				if(visited[cx][cy]) continue;
				
				visited[cx][cy]=true;
				arr[cx][cy]=num;
				q.add(new Node(cx,cy));
	
			}
			
		}
		
	}
	public static void makebridge(int x,int y, int num ) {
		
		int length=0;
		int cx=x;
		int cy=y;
		for(int i=0;i<4;i++) {
			while(true) {
				cx=cx+dx[i];
				cy=cy+dy[i];
				if(cx<0||cy<0||cx>=N||cy>=M) {
					length=0;
					cx=x;
					cy=y;
					break;
				}
				
				if(arr[cx][cy]==num) {
					length=0;
					cx=x;
					cy=y;
					break;
				}
				else if(arr[cx][cy]==0) {
					length++;
				}
				else {
					if(length>1) {
						pq.add(new Pair(num,arr[cx][cy],length));
					}
					length=0;
					cx=x;
					cy=y;
					break;
				}
				
				
			}
			
			
		}
	}
	public static int find(int a) {
		if(a==parents[a]) return a;
		parents[a]=find(parents[a]);
		return parents[a];
	}
	public static void union(int s, int e) {
		int aRoot=find(s);
		int bRoot=find(e);
		
		if(aRoot!=bRoot) {
			parents[aRoot]=e;
		}else {
			return;
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
	public static class Pair implements Comparable<Pair>{
		int s;
		int e;
		int v;
		
		
		public Pair(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}


		@Override
		public int compareTo(Pair o) {
			return v-o.v;
		}
		
		
	}
}
