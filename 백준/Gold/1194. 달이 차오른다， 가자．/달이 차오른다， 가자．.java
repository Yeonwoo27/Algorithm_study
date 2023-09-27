

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 달이 차오르면 다짐을 포기하는 하남자 민식이
 * 새벽 네시반에 일어나 달을 보았다.
 * 달은 내일이면 다 차오른다. 그전에 탈출하자!
 * 미로는 NxM의 크기의 직사각형
 * 빈칸은 . / 벽은 # / 열쇠는 소문자 a~f / 문은 대문자 A~F / 민식이의 현재 위치 0 / 출구는 1
 * 이동 횟수의 최솟값을 구해야 하므로 BFS? 중복 방문도 가능
 * 근데 BFS는 동시에 진행이 되는데 이 미로는 열쇠를 줍는 순간 방문 배열을 초기화 시켜줘야하므로 동시에 진행하면 문제 발생할듯
 * 그냥 DFS로 해서 최단거리를 구하는 식으로 해야할 것 같다. => 틀렸다..
 * 동시에 진행을 위해서 각 열쇠 보유 상황에 따른 방문 배열을 따로 만들면 된다. => 비트마스킹
 */

public class Main {
	public static int N,M;
	public static char[][] maze;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static boolean[][][] visited;
	public static int keys=0; // 열쇠 a~f를 가지고 있는지 저장할 비트마스킹 숫자
	public static int[] start=new int[2]; //민식이가 출발하는 지점
	public static Queue<Node> q=new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		maze=new char[N][M];
		visited=new boolean[N][M][64];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				maze[i][j]=str.charAt(j);
				if(maze[i][j]=='0') {
					q.add(new Node(i,j,0,0));
					visited[i][j][0]=true;
				}
			}
		}
		
		bfs();
		
		//한 번도 도착 지점에 도착한 적이 없다면 실행된다.
		System.out.println(-1);
		
		
		
	}
	public static void bfs() {
		
	
		
		while(!q.isEmpty()) {
			Node current=q.poll();
			int x=current.x;
			int y=current.y;
			int move=current.move;
			int keys=current.keys;
			
			
			for(int i=0;i<4;i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				
				if(cx<0||cy<0||cx>=N||cy>=M) continue; //범위를 벗어나거나
				if(maze[cx][cy]=='#') continue; //벽을 만나거나
				if(visited[cx][cy][keys]) continue; //방문한 적이 있으면 continue
				
				if(maze[cx][cy]=='1') { //도착을 한다면 
					System.out.println(move+1);
					System.exit(0);
				}
				
				
				if(maze[cx][cy]>=65&&maze[cx][cy]<=70) { //'A'~'F'사이의 값이라면
					int door=1<<(maze[cx][cy]-65);
					if((keys&door)==(int)Math.pow(2, maze[cx][cy]-65)) { //해당 알파벳에 대응하는 열쇠가 존재한다면 AND연산으로 0이 아닌 값이 나올 것이다.
						visited[cx][cy][keys]=true;
							q.add(new Node(cx,cy,move+1,keys));
						
					}										
				}
				
				else if(maze[cx][cy]>=97&&maze[cx][cy]<=102) { //'a'~'f'사이의 값이라면
					int next_keys=keys|(1<<(maze[cx][cy]-97)); //해당 알파벳에 해당하는 비트값 1로 바꿔준다.
					
					visited[cx][cy][next_keys]=true;
						q.add(new Node(cx,cy,move+1,next_keys));
					
				}
				else {
                    visited[cx][cy][keys] = true;
                    q.offer(new Node(cx, cy, move + 1, keys));
                }
			}
			
		}
		
		
	}
	

	public static class Node{
		int x;
		int y;
		int move;
		int keys;
		public Node(int x, int y, int move, int keys) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
			this.keys = keys;
		}
		
	}
}
