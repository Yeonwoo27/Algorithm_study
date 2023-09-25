

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
			int ans=0;
			st=new StringTokenizer(br.readLine());
			int K=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int P=Integer.parseInt(st.nextToken());
			
			int[] indegree=new int[M+1]; //각 노드에 들어오는 간선의 수를 저장한 배열
			int[] maxCnt=new int[M+1]; //각 노드에 들어오는 강의 수
			int[] strahler=new int[M+1]; //각 노드의 Strahler 순서를 저장하는 배열
			
			ArrayList<Integer>[] list=new ArrayList[M+1];
			for(int i=1;i<=M;i++) {
				list[i]=new ArrayList<>();
			}
			
			for(int i=0;i<P;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				indegree[b]++;
			}
			
			Queue<Integer> q=new LinkedList<>();
			
			for(int i=1;i<=M;i++) {
				if(indegree[i]==0) {
					q.add(i);
					strahler[i]=1;
					maxCnt[i]=1;
				}
			}
			
			while(!q.isEmpty()) {
				int node=q.poll();
				if(maxCnt[node]>=2) strahler[node]++;
				for(int idx : list[node]) {
					indegree[idx]--;
					
					if(strahler[idx]==strahler[node]) {
						maxCnt[idx]++;
					}
					else if(strahler[idx]<strahler[node]) {
						strahler[idx]=strahler[node];
						maxCnt[idx]=1;
					}
					
					if(indegree[idx]==0) {
						q.add(idx);
					}
				}
				
			}
			
			for(int i=1;i<=M;i++) {
				ans=Math.max(ans, strahler[i]);
			}
			sb.append(K).append(" ").append(ans).append("\n");
			
			
		}
		
		System.out.println(sb.toString());
	}

}
