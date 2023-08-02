
import java.io.*;
import java.util.*;
public class Main {
	public static int N,H;
	
	public static int[] up;
	public static int[] down;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		up=new int[H+1];
		down=new int[H+1];
		
		for(int i=0;i<N/2;i++) {
			int d=Integer.parseInt(br.readLine());
			down[d]++;
			
			int u=Integer.parseInt(br.readLine());
			up[u]++;
		}
		
		for(int i=H-1;i>1;i--) {
			up[i-1]+=up[i];	
			down[i-1]+=down[i];
		}
		for(int i=1;i<H;i++) {
			//System.out.println(down[i]+" "+up[i]);
		}
		int min=Integer.MAX_VALUE;
		int ans=0;
		for(int i=1;i<=H;i++) {
			int num=up[i]+down[H+1-i];
			
			if(num<min) {
				min=num;
				ans=1;
			}
			else if(num==min) ans++;
		}
		System.out.println(min+" "+ans);
		
	}

	
	
}
