

import java.util.*;

public class Main{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();	
		int[][] time=new int[N][2];
		for(int i=0;i<N;i++) {
			time[i][0]=sc.nextInt(); //시작
			time[i][1]=sc.nextInt(); //종료
		}
		Arrays.sort(time,(o1,o2)->{
			if(o1[1]==o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1];
		});
		
		int ans=1;
		int end=time[0][1];
		
		for(int i=1;i<N;i++) {
			if(time[i][0]>=end) {
				end=time[i][1];
				ans++;
			}
		}
			
		System.out.println(ans);
	}
	

	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
		
		
			
	

}
