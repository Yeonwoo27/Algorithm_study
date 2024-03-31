
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static PriorityQueue<Node> pq=new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb=new StringBuilder();
		
		int num=1;
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			if(N==0) break;
			
			arr=new int[N][N];
			visited=new boolean[N][N];
			int min=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			pq.add(new Node(0,0,arr[0][0]));
			
			while(!pq.isEmpty()) {
				Node current=pq.poll();
				int x=current.x;
				int y=current.y;
				int weight=current.weight;
				
				
				for(int i=0;i<4;i++) {
					int cx=x+dx[i];
					int cy=y+dy[i];
					
					if(cx==N-1&&cy==N-1) {
						min=Math.min(min, weight+arr[N-1][N-1]);
					}
					
					if(cx<0||cy<0||cx>=N||cy>=N) continue;
					if(visited[cx][cy]) continue;
				
					visited[cx][cy]=true;
					pq.add(new Node(cx,cy,weight+arr[cx][cy]));
					
				}
				
			}
			sb.append("Problem ");
			sb.append(num);
			sb.append(": ");
			sb.append(min);
			sb.append("\n");
			num++;
		}
		
		System.out.println(sb);
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
