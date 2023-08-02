import java.util.Scanner;

public class Main{
	public static int N,M;
	public static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		arr=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		
		M=sc.nextInt();
		
		for(int i=0;i<M;i++) {
			
			int mw=sc.nextInt();
			int num=sc.nextInt();
			if(mw==1) {
				man(num);
			}
			else if(mw==2) {
				woman(num);
			}
			
		}
		
		int k=0;
		for(int i=1;i<=N;i++) {
			if(k==20) {
				System.out.println();
				k=0;
			}
			System.out.print(arr[i]+" ");
			k++;
		}
	}
	public static void man(int n) {
		for(int i=1;i<=N;i++) {
			if(i%n==0) {
				swap(i,arr[i]);
			}
		}
	}
	public static void woman(int n) {
		int idx=1;
		swap(n,arr[n]);
			
		while(true) {
			if(n+idx>N||n-idx<1||arr[n+idx]!=arr[n-idx]) {
				break;
			}
			else if(arr[n+idx]==arr[n-idx]) {
				swap(n+idx,arr[n+idx]);
				swap(n-idx,arr[n-idx]);
				
				idx++;
			}
		}
	}
	public static void swap(int index,int num) {
		if(num==0) arr[index]=1;
		else if(num==1) arr[index]=0;
	}

}
