

import java.util.*;
public class Main {
    static int[] up;
    static int[] down;
    static boolean[] visited; 
    static int[] sum;
    static int N,H;
    public static int min=Integer.MAX_VALUE;
    public static int ans=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N = sc.nextInt();
        H=sc.nextInt();
        up=new int[H+1];
        down=new int[H+1];
        for(int i=0;i<N;i++) {
        	int height=sc.nextInt();
        	if(i%2==0) up[height]++;
        	else down[height]++;
        }
        for(int i=H-1;i>0;i--) {
        	up[i]+=up[i+1];
        	down[i]+=down[i+1];
        }
        for(int i=1;i<=H;i++) {
        	int sum=down[i]+up[H+1-i];
        	if(sum<min) {
        		min=sum;
        		ans=1;
        	}
        	else if(sum==min) ans++;
        }
        System.out.println(min+" "+ans);
    }
   
}
