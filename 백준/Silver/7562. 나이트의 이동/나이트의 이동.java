
import java.util.*;
public class Main{
	public static int l,T;
	
	public static int[][] arr;
	public static boolean [][]visited;
	public static int x1,x2,y1,y2;
	public static int[] dx= {-2,-1,1,2,2,1,-1,-2};
	public static int[] dy= {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int t=0;t<T;t++) {
			l=sc.nextInt();
			arr=new int[l][l];
			visited=new boolean[l][l];
			x1=sc.nextInt();
			y1=sc.nextInt();
			x2=sc.nextInt();
			y2=sc.nextInt();
			
			bfs();
			
			System.out.println(arr[x2][y2]);
		}
		
		
		
		
	}
	
	public static void bfs() {
		visited[x1][y1]=true;
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[]{x1,y1});
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int x=temp[0];
			int y=temp[1];
			
			for(int i=0;i<8;i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				
				if(cx<0||cy<0||cx>=l||cy>=l) continue;
				
				if(!visited[cx][cy]) {
					visited[cx][cy]=true;
					arr[cx][cy]=arr[x][y]+1;
					q.add(new int[] {cx,cy});
				}
			}
		}
		
		
	}
}
