
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Node>[] list;
	public static int N,M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
			
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end,d));
			list[end].add(new Node(start,d)); 
		}
		int[] answer=new int[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			answer[i]=getdistance(start,end);
					
		}
		for(int i=0;i<M;i++) {
			System.out.println(answer[i]);
		}
		
	}
	public static int getdistance(int s, int e) {
		Queue<Node> q=new LinkedList<>(); 
		boolean[] visited=new boolean[N+1];
		visited[s]=true;
		q.add(new Node(s,0));
			
		int ans=0;
		while(!q.isEmpty()) {
			Node n=q.poll();
			if(n.next==e) {
				ans=n.distance;
				break;
			}
			for(Node temp : list[n.next]) {
				if(!visited[temp.next]) {
					q.add(new Node(temp.next,n.distance+temp.distance));
					visited[temp.next]=true;
				}
			}
		}
		return ans;
	}
	public static class Node{
		int next;
		int distance;
		public Node(int next, int distance) {
			this.next=next;
			this.distance=distance;
		}
	}
}