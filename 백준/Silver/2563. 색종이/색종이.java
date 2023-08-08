

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		boolean[][] checked=new boolean[101][101];	//색칠이 되었는지 체크하는 배열
		
		int N=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			for(int j=a;j<a+10;j++) {
				for(int k=b;k<b+10;k++) {
					if(j<0||k<0||j>=100||k>=100) continue;;
					if(!checked[j][k]) checked[j][k]=true;
				}
			}
			
		}
		int ans=0;
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				if(checked[i][j]) ans++;
			}
		}
		
		System.out.println(ans);
	}

}
