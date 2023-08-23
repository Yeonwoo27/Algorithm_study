

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * DFS 느낌이 온다.
 * 쭉 가서 끝나면 그 깊이와 해당 노드를 따로 저장.
 * 다른 루트에서 더 긴 길이를 찾으면 교체, 같은 길이면 노드 숫자 비교
 * 방향이 있는 그래프 구현
 * 
 */
public class Solution {
	public static int N,M;
	public static ArrayList<Integer>[] list; //인접 리스트
	public static boolean[] visited;
	public static int[]result;
	public static int max_depth;
	public static int max_num;
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		for(int test_case=1;test_case<=10;test_case++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			list=new ArrayList[101];
			for(int i=1;i<=100;i++) list[i]=new ArrayList<>();
			
			visited=new boolean[101];
			result=new int[101];
			max_depth=Integer.MIN_VALUE;
			max_num=0;
			
			int from,to;
			for(int i=0;i<N/2;i++) {
				from=sc.nextInt();
				to=sc.nextInt();
				if(!list[from].contains(to)) {
					list[from].add(to);  //from 에서 to로 가는 간선추가
				}
			}
			
			visited[M]=true;
			bfs(M);
			for(int i=1;i<=100;i++) {
				if(result[i]>=max_depth) {
					if(result[i]>max_depth) {
						max_depth=result[i];
						max_num=i;
					}
					else {
						max_num=Math.max(max_num, i);
					}
				}
			}
			System.out.println("#"+test_case+" "+max_num);
		}
	}
	public static void bfs(int n) {
		Queue<Integer> q=new LinkedList<>();
		q.add(n);
		visited[n]=true;
		result[n]=0;
		
		while(!q.isEmpty()) {
			int current=q.poll();
			visited[current]=true;
			for(int i=0;i<list[current].size();i++) {
				int num=list[current].get(i);
				if(!visited[num]) {
					if(result[num]==0) {
						result[num]=result[current]+1;
					}
					q.add(num);
				}
				
			}
		}
	}
	

}
