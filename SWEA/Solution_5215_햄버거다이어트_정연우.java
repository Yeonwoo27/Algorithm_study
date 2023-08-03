package recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5215_햄버거다이어트_정연우 {	//조합
	public static int N,L;
	public static ArrayList<int[]> list=new ArrayList<>();	//햄버거의 점수와 칼로리를 저장하는 arraylist
	public static boolean[] visited;	//중복을 막기위한 방문 배열
	public static int max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		L=sc.nextInt();
		
		visited=new boolean[N];
		
		for(int i=0;i<N;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			list.add(new int[] {x,y});
		}
		dfs(0,0,0);
		System.out.println(max);
		list.clear();
	}
	public static void dfs(int start,int score,int cal) {	//조합 함수
		
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				int[] temp=list.get(i);
				if(cal+temp[1]<=L) {	//기존 칼로리에 새로운 재료의 칼로리를 더한게 L이하면 실행
					max=Math.max(max, score+temp[0]);	//위 조건문이 참일때 마다 max값과 비교후 더 크다면 변경
					dfs(i+1,score+temp[0],cal+temp[1]);	//재귀 실행
				}
				visited[i]=false;
			}
			
		}
	}

}
