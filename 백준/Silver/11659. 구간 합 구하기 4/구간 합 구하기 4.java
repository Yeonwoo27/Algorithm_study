

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int[] arr=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			int n=sc.nextInt();
			arr[i]=arr[i-1]+n;
		}
		
		
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			sb.append(arr[b]-arr[a-1]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
