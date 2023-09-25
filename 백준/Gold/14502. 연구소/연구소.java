
import java.util.*;
import java.io.*;
public class Main {
	
	public static boolean[] visited=new boolean[26];
	public static int[][] map;
	public static int[][] copy_map;
	
	public static int max=0;
	public static int M,N;
	public static int[] dx= {-1,0,0,1};
	public static int[] dy= {0,1,-1,0};
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
	   //Scanner sc=new Scanner(System.in);
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		
		map=new int[N][M];
		copy_map=new int[N][M];
		
		
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
			
		}
		
		
		
		dfs(0);
		
		System.out.print(max);
		
		
	}
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2) {
					q.add(new Node(i,j));
				}
			}
		}
		
		  for (int i = 0; i < N; i++) {
	            copy_map[i] = map[i].clone();
	        }
		
		while(!q.isEmpty()) {
			Node now=q.poll();
			int x=now.x;
			int y=now.y;
			
			for(int k=0;k<4;k++) {
				int cx=x+dx[k];
				int cy=y+dy[k];
				
				if(cx<0||cy<0||cx>=N||cy>=M) continue;
				
				if(copy_map[cx][cy]==0) {
					copy_map[cx][cy]=2;
					q.add(new Node(cx,cy));
				}
				
			}
		}
		checkzero(copy_map);
	}
	public static void checkzero(int[][] copy_map) {
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copy_map[i][j]==0) ans++;
			}
		}
		max=Math.max(max, ans);
	}
	
	public static void dfs(int depth) {
		if(depth==3) {
			bfs();
			return;
		}
		else {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0) {
						map[i][j]=1;
						dfs(depth+1);
						map[i][j]=0;
					}
				}
			}
		}
	}
	
}
