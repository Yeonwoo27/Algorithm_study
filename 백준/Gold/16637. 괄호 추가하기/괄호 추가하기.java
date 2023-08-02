
import java.io.*;
import java.util.*;
public class Main {
	public static int N;
	
	public static int[] num_arr;
	public static char[] opr_arr;
	public static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		sc.nextLine();
		num_arr=new int[N/2+1];
		opr_arr=new char[N/2];
		String str;
		str=sc.nextLine();
		for(int i=0;i<N;i++) {
			if(i%2==0) {
				num_arr[i/2]=str.charAt(i)-'0';
			}
			else opr_arr[i/2]=str.charAt(i);
		}
		
		dfs(num_arr[0],0);
		System.out.println(max);
	
	}
	
	public static void dfs(int res, int idx) {
		if(idx>=N/2) { 
			
			max=Math.max(max, res);
			return;
		}
		//괄호 x
		int sum1=math(res,num_arr[idx+1],opr_arr[idx]);	
		dfs(sum1,idx+1);
		//괄호 o
		if(idx+1<N/2) {
			int sum2=math(num_arr[idx+1],num_arr[idx+2],opr_arr[idx+1]);
			dfs(math(res,sum2,opr_arr[idx]),idx+2);
		}
		
	}
	
	public static int math(int a, int b,char c) {
		if(c=='+') {
			return a+b;
		}
		else if(c=='-') {
			return a-b;
		}
		else return a*b;
		
	}
		
	
}
