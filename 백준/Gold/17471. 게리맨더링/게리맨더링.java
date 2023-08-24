
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 구역은 1~N번까지 번호가 매겨져있음
 * 구역을 두개의 선거구로 나눠야하고, 각 구역은 두 선거구 중 하나에 포함되어야 함
 * 한 선거구에 포함되어 있는 구역은 모두 연결돼야함
 * 두 선거구에 포함된 인구 차이 최소로
 * 
 * 풀이 :
 * 먼저 부분집합으로 전체 구역을 2 구역으로 나누고
 * 각각 DFS를 이용해서 연결되어있는 상태인지 확인
 * 되어있다면 포함된 노드들의 합의 차이를 구한다.
 * 
 */
public class Main{
	public static ArrayList<Integer>[] list;
	public static int[] pList; //각 구역의 인구 수
	public static int N;
	public static boolean[] area; //한쪽 선거구에 속한 구역의 번호들
	public static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		pList=new int[N+1];
		list=new ArrayList[11];
		area=new boolean[N+1];
		
		for(int i=1;i<=10;i++) {
			list[i]=new ArrayList<>();
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			pList[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			
			int adjNum=Integer.parseInt(st.nextToken()); //인접한 구역의 수
			
			for(int j=0;j<adjNum;j++) {
				list[i].add(Integer.parseInt(st.nextToken())); //인접리스트에 인접한 구역의 번호를 넣는다.
			}
		}
		
		subset(0); //부분집합 실행
		
		if(min==Integer.MAX_VALUE) { //값이 바뀌지않았다는 것은 연결되는 경우가 없었다는 뜻
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
		
	}
	public static void subset(int cnt) {
		if(cnt==N) {
			bfs(); //bfs 함수 실행
			return; //한 지역구에 최대 N-1 구역이 올 수 있으므로
		}
		
		
		area[cnt+1]=true;
		subset(cnt+1);
		area[cnt+1]=false;
		subset(cnt+1);
		
	}
	public static void bfs() {
		boolean[] visited=new boolean[N+1];
		Queue<Integer> q=new LinkedList<>();
		boolean[] copy_area=area.clone();
		
		for(int i=1;i<=N;i++) { //area배열에서 true인 인덱스 하나를 일단 큐에 넣는다.
			if(area[i]) {
				q.add(i);
				visited[i]=true;
				break;
			}
		}
		
		while(!q.isEmpty()){ //bfs를 통해 연결되어있는 구역들의 area값을 false로 바꿔준다.
			int cur=q.poll();
			for(int i=0;i<list[cur].size();i++) {
				int n=list[cur].get(i);
				if(!visited[n]&&area[n]) { //같은 선거구라면
					visited[n]=true;
					q.add(n);
				}
				
			}
		}	
		//2번째 구역
		for(int i=1;i<=N;i++) { //area배열에서 false인 인덱스 하나를 일단 큐에 넣는다.
			if(!area[i]) {
				q.add(i);
				visited[i]=true;
				break;
			}
		}
		while(!q.isEmpty()){ //bfs를 통해 연결되어있는 구역들의 area값을 false로 바꿔준다.
			int cur=q.poll();
			for(int i=0;i<list[cur].size();i++) {
				int n=list[cur].get(i);
				if(!visited[n]&&!area[n]) { //같은 선거구라면
					visited[n]=true;
					q.add(n);
				}
				
			}
		}	
		for(int i=1;i<=N;i++) { //위의 과정이 끝나고 visited에 있었던 false값들이 모두 true가 되었으면 다 연결되었다는 의미
			if(!visited[i]) {
				return;
			}
		}
		
		int sum1=0,sum2=0;
		for(int i=1;i<=N;i++) { //위의 과정이 끝나고 area에 있었던 true값들이 모두 false가 되었으면 다 연결되었다는 의미
			if(copy_area[i]) {
				sum1+=pList[i];
			}
			else {
				sum2+=pList[i];
			}
		}
		
		min=Math.min(min, Math.abs(sum1-sum2)); //두 선거구의 인구 차이의 최솟값 구하기
		
	}

}
