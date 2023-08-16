
import java.io.*;
import java.util.*;

public class Main{

	public static int M,N,K;
	public static int[][] arr;
	public static int[][] cycle;
	public static int[] select;
	public static boolean[] visited;
	public static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][M+1]; 
		cycle=new int[K][3]; //회전 정보 저장
		select=new int[K]; // 순서 저장
		visited=new boolean[K]; //방문 배열
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			cycle[i][0]=Integer.parseInt(st.nextToken());
			cycle[i][1]=Integer.parseInt(st.nextToken());
			cycle[i][2]=Integer.parseInt(st.nextToken());
		}
		
		permutation(0); 
		
		System.out.println(min);
		
	}
	public static void permutation(int cnt) { //순열 함수
		if(cnt==K) {
			rotate();
			return;
		}
		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				visited[i]=true;
				select[cnt]=i;
				permutation(cnt+1);
				visited[i]=false;
			}
			
		}
	}
	public static void rotate() {
		int[][] copy_arr=new int[N+1][M+1]; //임시로 쓸 배열
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				copy_arr[i][j]=arr[i][j];
			}
		}
		for(int k=0;k<K;k++) {
			int x=cycle[select[k]][0];
			int y=cycle[select[k]][1];
			int n=cycle[select[k]][2];
			
			for(int i=1;i<=n;i++) {
				int temp=copy_arr[x-i][y-i]; //왼쪽 위 값 임시저장
				for(int j=x-i;j<x+i;j++) { //왼쪽 변 처리
					copy_arr[j][y-i]=copy_arr[j+1][y-i];
				}
				for(int j=y-i;j<y+i;j++) { //아래쪽 변 처리
					copy_arr[x+i][j]=copy_arr[x+i][j+1];
				}
				for(int j=x+i;j>x-i;j--) { //오른쪽 변 처리
					copy_arr[j][y+i]=copy_arr[j-1][y+i];
				}
				for(int j=y+i;j>y-i;j--) { //위쪽 변 처리
					if(j==y-i+1) copy_arr[x-i][j]=temp;
					else copy_arr[x-i][j]=copy_arr[x-i][j-1];
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=M;j++) {
			 sum+=copy_arr[i][j];
			}
			min=Math.min(min, sum);
		}
	}
	
}
	



