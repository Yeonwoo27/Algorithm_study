

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[100001];
		int N=sc.nextInt();
		int K=sc.nextInt();
		if(N==K) System.out.println("0");
		else {
			Queue<Integer> q=new LinkedList<>();
			arr[N]=1;
			q.add(N);
			
			
			while(!q.isEmpty()) {
				int current=q.poll();
				
				for(int i=0;i<3;i++) {
					int num=0;
					
					if(i==0) {
						num=current-1;
					}
					else if(i==1) {
						num=current+1;
					}
					else if(i==2) {
						num=current*2;
					}
					
					if(num==K) {
						System.out.println(arr[current]);
						return;
					}
					
					if(num>=0&&num<100001&&arr[num]==0) {
						arr[num]=arr[current]+1;
						q.add(num);
					}
				}
				
			}
		}
		
		
	}
	
}
