

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static int N;
	public static int[] operator;
	public static int[] number;
	public static int[] blank; //숫자 사이에 빈 칸
	public static int max;
	public static int min;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N=sc.nextInt();
			operator=new int[4];
			number=new int[N];
			blank= new int[N-1];
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			
			for(int i=0;i<4;i++) {
				operator[i]=sc.nextInt();
			}
			
			for(int i=0;i<N;i++) {
				number[i]=sc.nextInt();
			}
			
			permutation(0, 0);
			
			System.out.println("#"+test_case+" "+(max-min));
			
		}
	}
	public static void permutation(int start,int cnt) {
		if(cnt==N-1) {
			calculate();
			return;
		}
		
		for(int i=start;i<N-1;i++) {
			for(int j=0;j<4;j++) {
				if(operator[j]>0) {
					operator[j]--;
					blank[cnt]=j;
					permutation(i+1, cnt+1);
					operator[j]++;
				}
			}
		}
		
	}
	public static void calculate() {
		int sum=number[0];
//		for(int i=0;i<N-1;i++) {
//			System.out.print(blank[i]+" ");
//		}
//		System.out.println();
		for(int i=0;i<N-1;i++) {
			switch (blank[i]) {
			case 0:
				sum=sum+number[i+1];
				break;
			case 1:
				sum=sum-number[i+1];			
				break;
			case 2:
				sum=sum*number[i+1];
				break;
			case 3:
				sum=sum/number[i+1];
				break;
			default:
				break;
			}
		}
		
		max=Math.max(sum, max);
		min=Math.min(sum, min);
	}
	
	
}
