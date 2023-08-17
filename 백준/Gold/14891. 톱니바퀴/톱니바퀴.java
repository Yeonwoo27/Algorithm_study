
import java.io.*;
import java.util.*;

public class Main{
	
	public static int[][] tobni=new int[5][8]; //i번째 톱니바퀴의 j방향 극 상태
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		String str;
		for(int i=1;i<=4;i++) {
			str=br.readLine();
			for(int j=0;j<8;j++) {
				tobni[i][j]=str.charAt(j)-'0';
			}
		}
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int K=Integer.parseInt(st.nextToken());
		for(int i=0;i<K;i++) {
			
			st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int polar=Integer.parseInt(st.nextToken());
			
			visited=new boolean[5];//회전 체크
			
			rot(num,polar);
		}
		
		int score=0;
		score+=(tobni[1][0]==0?0:1);
		score+=(tobni[2][0]==0?0:2);
		score+=(tobni[3][0]==0?0:4);
		score+=(tobni[4][0]==0?0:8);
		
		System.out.println(score);
	}
	public static void rot(int n,int p) {
		visited[n]=true;
		if(n-1>=1) {
			if(!visited[n-1]&&(tobni[n][6]!=tobni[n-1][2])) {
				rot(n-1,p*(-1)); 
			}
		}
		if(n+1<=4) {
			if(!visited[n+1]&&(tobni[n][2]!=tobni[n+1][6])) rot(n+1,p*(-1)); 
		}
		rotate(n,p);
		
	}
	public static void rotate(int n,int p) { //시계 또는 반시계 회전하는 함수
		if(p==1) { //시계방향 회전
			
			int tmp=tobni[n][7];
			for(int i=7;i>0;i--) {
				tobni[n][i]=tobni[n][i-1];
			}
			tobni[n][0]=tmp;
		}
		else { //반시계 회전
			int tmp=tobni[n][0];
			for(int i=0;i<7;i++) {
				 tobni[n][i]=tobni[n][i+1];
			}
				tobni[n][7]=tmp;
		}
			
		}
		
	}
	
	
	
	

