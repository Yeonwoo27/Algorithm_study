
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M; //과목의 개수, 선수과목 정보 개수
	static int[] degrees; //진입차수
	static List<Integer>[] adjList; //인접리스트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		degrees=new int[N+1];
		adjList=new List[N+1];
		for(int i=1;i<=N;i++) {
			adjList[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			degrees[to]++;
		}
		
		bfs();
		
	}
	public static void bfs() {
		StringBuilder sb=new StringBuilder();
		Queue<Integer> q=new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			if(degrees[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int from=q.poll();
			
			sb.append(from);
			sb.append(" ");
			
			for(int to : adjList[from]) {
				if(--degrees[to]==0) {
					q.add(to);
				}
			}
		}
		
		System.out.println(sb);
	}

}
