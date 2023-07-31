
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
	public static int N;
	
	public static int[][] arr;
	public static boolean [][]visited;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		visited=new boolean[N][N];
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		int num=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&arr[i][j]==1) {
					num++;
					dfs(i,j,num);
				}
				
			}
		}
		int[] n=new int[num];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]>0) {
					n[arr[i][j]-1]++;
				}
				
			}
		}
		Arrays.sort(n);
		System.out.println(num);
		for(int i=0;i<num;i++) System.out.println(n[i]);
		
	}
	
	public static void dfs(int x,int y,int num) {
		visited[x][y]=true;
		arr[x][y]=num;
		for(int i=0;i<4;i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			
			if(cx<0||cy<0||cx>=N||cy>=N) continue;
			
			if(!visited[cx][cy]&&arr[cx][cy]==1) {
				dfs(cx,cy,num);
			}
		}
	}
		
		
	
}
