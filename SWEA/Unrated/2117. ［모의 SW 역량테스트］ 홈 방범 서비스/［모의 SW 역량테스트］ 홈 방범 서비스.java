import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static int N, M;
	public static int[][] arr;
	public static int max;
	public static ArrayList<Node> list;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N][N];
			max=Integer.MIN_VALUE;
			list=new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						list.add(new Node(i, j));
					}
				}
			}
			int k = 1;
			while (true) {
				boolean quit=false;
				int cost = k * k + (k - 1) * (k - 1);
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						quit=checkHomes(i,j,k-1,cost);
					}
				}
				
				if(quit) {
					break;
				}
				
				k++;
			}
			
			System.out.println("#"+test_case+" "+max);
		}
	}

	public static boolean checkHomes(int x, int y, int dist,int cost) {
		int sum=0;
		int home_num=0;
		
		for(int i=0;i<list.size();i++) {
			int cx=list.get(i).x;
			int cy=list.get(i).y;
			int distance=Math.abs(x-cx)+Math.abs(y-cy);
			
			if(dist>=distance) { //집이 격자 내에 위치할 경우
				sum+=M;
				home_num++;
			}
		}
	
		if(sum>=cost) {
			max=Math.max(max, home_num);
		}
		if(home_num==list.size()) {
			return true;
		}
		return false;
	}
	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}