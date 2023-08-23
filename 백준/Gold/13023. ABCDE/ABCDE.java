
import java.util.*;

/*
 * 얘도 DFS문제
 * 특정 노드에서 중복없이 깊이탐색을 할때 깊이가 5가 되면 1출력.
 * 위의 조건이 실행안되면 5 이상인 경로가 없다는 뜻이므로 0출력
 */
public class Main{
	public static int N,M;
	public static ArrayList<Integer>[] list;
	public static boolean[] visited;
	public static boolean check=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		list=new ArrayList[N];
		visited=new boolean[N];
		
		for(int i=0;i<N;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0;i<N;i++) {
			visited[i]=true;
			dfs(i,1);
			visited[i]=false;
			if(check) break; //check가 true가 되었다는 것은 조건을 만족하는 관계가 있다는 뜻이므로 break
		}
		
		if(check) System.out.println(1); //
		else System.out.println(0);
	}	
	public static void dfs(int n,int cnt) {
		if(cnt==5) {
			check=true;
			return;
		}
		for(int i=0;i<list[n].size();i++) {
			int num=list[n].get(i);
			if(!visited[num]) {
				visited[num]=true;
				dfs(num,cnt+1);
				visited[num]=false;
			}
		}
		
	}

}
