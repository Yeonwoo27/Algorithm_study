package recursive;

import java.util.ArrayList;
import java.util.Scanner;
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Solution_1247_최적경로_정연우2 {
	public static int N;
	public static int d;
	public static Point[] client;
	public static Point[] list;
	public static boolean[] visited;
	public static Point home;
	public static Point office;
	public static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		visited=new boolean[N+1];
		client=new Point[N];
		list=new Point[N];
		
		int x,y;
		x=sc.nextInt();
		y=sc.nextInt();
		office=new Point(x,y);
		x=sc.nextInt();
		y=sc.nextInt();
		home=new Point(x,y);
		
		
		for(int i=0;i<N;i++) {
			x=sc.nextInt();
			y=sc.nextInt();
			client[i]=new Point(x,y);
		}
		dfs(0);
		
		System.out.println(min);
		
	}
	public static void dfs(int cnt) {
		if(cnt==N) {
			cal();
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				list[cnt]=client[i];
				dfs(cnt+1);
				visited[i]=false;
			}
		}
	}
	public static void cal() {
		int length=0;
		int x=office.x;
		int y=office.y;
			
		for(int i=0;i<N;i++) {
			int cx=list[i].x;
			int cy=list[i].y;
			length+=(Math.abs(x-cx)+Math.abs(y-cy));
			x=cx;
			y=cy;
		}
		length+=(Math.abs(x-home.x)+Math.abs(y-home.y));
		
		min=Math.min(min, length);
	}
}
