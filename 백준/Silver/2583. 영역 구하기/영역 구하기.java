

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static int M,N,K;
	public static boolean[][] visited;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
	public static ArrayList<Integer> list=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		visited=new boolean[N][M];
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			for(int x=x1;x<x2;x++) {
				for(int y=y1;y<y2;y++) {
					visited[x][y]=true;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]) {
					bfs(i,j);
				}
			}
			
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int n : list) {
			System.out.print(n+" ");
		}
		
		
	}
	public static void bfs(int x, int y) {
		visited[x][y]=true;
		Queue<int[]> q=new LinkedList<int[]>();
		q.add(new int[] {x,y});
		int sum=0;
		
		while(!q.isEmpty()) {
			sum++;
			int[] current=q.poll();
			int nx=current[0];
			int ny=current[1];
			
			for(int i=0;i<4;i++) {
				int cx=nx+dx[i];
				int cy=ny+dy[i];
				
				if(cx<0||cy<0||cx>=N||cy>=M) continue;
				
				if(!visited[cx][cy]) {
					q.add(new int[] {cx,cy});
					visited[cx][cy]=true;
					
				}
			}
		}
		
		list.add(sum);
	}
	
}
	



