
import java.util.Scanner;

public class Main {
	public static int N,M;
	public static int[] arr;
	public static boolean[] visited;
	public static int[] save_arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		visited=new boolean[N];
		save_arr=new int[M];
		
		recursive(0);
	}
	public static void recursive(int cnt) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				System.out.print(save_arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				save_arr[cnt]=arr[i];
				recursive(cnt+1);
				visited[i]=false;
			}
		}
		
	}

}
