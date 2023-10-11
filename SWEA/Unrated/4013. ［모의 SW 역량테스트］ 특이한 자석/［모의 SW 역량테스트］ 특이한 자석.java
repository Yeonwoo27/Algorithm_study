
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int K;
	public static int magnet[][];
	public static boolean[] visited;
	public static void main(String args[]) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int T;
		T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st=new StringTokenizer(br.readLine());
			K=Integer.parseInt(st.nextToken());
			
			magnet=new int[5][8];
			
			for(int i=1;i<=4;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					magnet[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int score=0;
			
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken());
				int dir=Integer.parseInt(st.nextToken());
				
				visited=new boolean[5];
				rotate(num,dir);
				
				
			}
			score=checkScore();
			System.out.println("#"+test_case+" "+score);
		}
	}
	

	
	public static void rotate(int num, int dir) {
		visited[num]=true;
		
		if(num+1<=4) { //오른쪽에 다른 자석이 있다면
			if(!visited[num+1]) {
				if(magnet[num][2]!=magnet[num+1][6]) {
					rotate(num+1,dir*(-1));
				}
			}
		}
		
		if(num-1>0) { //왼쪽에 다른 자석이 있다면
			if(!visited[num-1]) {
				if(magnet[num][6]!=magnet[num-1][2]) {
					rotate(num-1,dir*(-1));
				}
			}
		}
		
		if(dir==1) { //시계방향 회전
			int tmp=magnet[num][7];
			for(int i=7;i>0;i--) {
				magnet[num][i]=magnet[num][i-1];
			}	
			magnet[num][0]=tmp;
		}
		else if(dir==-1) { //반시계방향 회전
			int tmp=magnet[num][0];
			for(int i=0;i<7;i++) {
				magnet[num][i]=magnet[num][i+1];
			}	
			magnet[num][7]=tmp;
		}
		
		
	}
	
	public static int checkScore() {
		int sum=0;
		if(magnet[1][0]==1) sum+=1;
		if(magnet[2][0]==1) sum+=2;
		if(magnet[3][0]==1) sum+=4;
		if(magnet[4][0]==1) sum+=8;
		
		return sum;
	}

}
