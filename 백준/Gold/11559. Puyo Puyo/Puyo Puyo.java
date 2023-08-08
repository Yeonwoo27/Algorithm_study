
import java.io.*;
import java.util.*;
public class Main{
	public static int N;
	public static int[] color=new int[5];
	public static char[][] arr=new char[12][6];
	public static boolean[][] visited;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static int num,ans=0;
	public static boolean check;
	public static ArrayList<Node> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		
		for(int i=0;i<12;i++) {
			String str=br.readLine();
			for(int j=0;j<6;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		while(true) {
			check=false;
			visited=new boolean[12][6];
			
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(arr[i][j]>='A'&&arr[i][j]<='Z') {
						list=new ArrayList<>();
						bfs(i,j,arr[i][j]);
						
						if(list.size()>=4) {
							for(int k=0;k<list.size();k++) {
								Node temp=list.get(k);
								int x=temp.x;
								int y=temp.y;
								arr[x][y]='.';
							}
							check=true;
						}
						
					}
					
				}
				
			} // 전체 탐색
			if(!check) break;
			down();
			ans++;
			
		}
		System.out.println(ans);
		
	}

	public static void bfs(int x,int y,char c) {	
		
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(x,y));
		list.add(new Node(x,y));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			Node current=q.poll();
			int cx=current.x;
			int cy=current.y;
			for(int i=0;i<4;i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				
				if(nx<0||ny<0||nx>=12||ny>=6) continue;
				
				if(!visited[nx][ny]&&arr[nx][ny]==c) {
					visited[nx][ny]=true;
					q.add(new Node(nx,ny));
					list.add(new Node(nx,ny));
				
				}
			}
		}
	
		
	}	
	
	public static void down() {
		for(int j=0;j<6;j++) {
			for(int i=11;i>0;i--) {
				if(arr[i][j]=='.') {
					for(int k=i-1;k>=0;k--) {
						if(arr[k][j]!='.') {
							arr[i][j]=arr[k][j];
							arr[k][j]='.';
							break;
						}
					}
				}						
			}
			
		}
	}
	
	public static class Node{
		int x;
		int y;
		public Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
