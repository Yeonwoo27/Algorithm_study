
import java.io.*;
import java.util.*;
public class Main {
	public static int N;
	public static int[] arr;
	public static boolean[][] visited;
	
	public static int ans=0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		arr=new int[N];
		
		dfs(0);
		
		
		System.out.println(ans);	
		
	}

	public static void dfs(int depth) {	// depth는 체스판에서 세로 번호를 의미
		if(depth==N) {
			ans++;
			return;
		}
		for(int i=0;i<N;i++) {
			arr[depth]=i;	// arr[]은 체스판에서 가로 번호를 의미
			if(possible(depth)) {
				dfs(depth+1);
			}
		}
		
	}
	public static boolean possible(int col){	
		for(int i=0;i<col;i++) {
			if(arr[i]==arr[col]) return false;	//세로 번호는 무조건 다르니 먼저 가로 번호가 같은지 체크
			//대각선에 true인게 없어야 하는데, 이 때 특정 좌표와의 가로 길이와 세로 길이가 같으면 
			//같은 대각선에 존재하는 것을 의미한다.
			else if(Math.abs(i-col)==Math.abs(arr[i]-arr[col])) return false;
		}
		return true;
	}
	
}
