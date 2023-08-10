

import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] selected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		arr=new int[9];
		selected=new int[7];
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
		}
		dfs(0,0,0);
		
	}
	public static void dfs(int cnt,int sum,int idx) {	//조합
		if(cnt==7) {
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(selected[i]);
				}
			}
			return;
		}
		for(int i=idx;i<9;i++) {
			
			selected[cnt]=arr[i];
			dfs(cnt+1,sum+arr[i],i+1);
			
		}
	}
}
