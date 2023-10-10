import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*5x5가 고정이므로 BFS로 전체를 탐색해도 시간 초과는 날 것 같지 않다.
 * 7칸을 고르는데 S가 최소 4개 이상 있어야한다.
 * 그러므로 BFS를 진행하다가 Y가 4개 이상이 되면 종료
 * 7칸을 모두 골랐을때 Y도 4개 이상이 아니라면 조건을 만족하는 경우이다.
 * 
 */
public class Main {

	public static char[][] arr = new char[5][5];
	public static boolean[][] picked = new boolean[5][5];
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				arr[i][j] = str.charAt(j);

			}
		}
		combination(0, 0, 0);
		System.out.println(ans);
	}

	public static void combination(int start, int cnt, int y_num) {
		if (y_num == 4) {
			return;
		}
		if (cnt == 7) {
			bfs();
			return;
		}

		
		for (int i = start; i < 25; i++) {
			int r = i / 5;
			int c = i % 5;
			
			picked[r][c]=true;
			
			if (arr[r][c] == 'Y') {
				combination(i + 1, cnt + 1, y_num + 1);
			} else {
				combination(i + 1, cnt + 1, y_num);
			}
			
			picked[r][c]=false;
		}
	}
	
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		boolean[][] visited=new boolean[5][5];
		
		loop:
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(picked[i][j]) {
					q.add(new Node(i,j));
					visited[i][j]=true;
					break loop;
				}
			}
		}
		
		int num=1;
		while(!q.isEmpty()) {
			
			Node current=q.poll();
			
			int x=current.x;
			int y=current.y;
			
			for(int i=0;i<4;i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				
				if(cx<0||cy<0||cx>=5||cy>=5) continue;
				if(visited[cx][cy]) continue; 
				
				visited[cx][cy]=true;
				
				if(picked[cx][cy]) { //picked가 true인 곳이 뽑은 위치를 뜻한다.
					num++;
					q.add(new Node(cx,cy));
				}
				
			}
		}
		
		if(num==7) {
			ans++; //num이 7이라는 뜻은 조합으로 뽑은 자리들이 모두 연결되었다는 뜻
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