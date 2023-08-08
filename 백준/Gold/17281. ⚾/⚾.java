
import java.io.*;
import java.util.*;
public class Main {
	
	public static int N,ans=0;
	public static int[] lineup;	//	실제 라인업
	public static boolean[] select;	//방문 배열
	public static int[][] arr;	//N번째 이닝에서 M번째 선수가 하는 행동
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		arr=new int[N+1][10];
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		lineup=new int[10];
		select=new boolean[10];
		lineup[4]=1;	//4번 타자는 1번째 선수로 고정
		select[4]=true;	//4번 자리는 고정 true
		
		dfs(2);
		
		System.out.println(ans);
		
	}
	public static void dfs(int num) {	//순열
		if(num==10) {
			baseball();
			return;
		}
		for(int i=1;i<=9;i++) {
			if(!select[i]) {
				select[i]=true;
				lineup[i]=num;
				dfs(num+1);
				select[i]=false;
			}
		}
	}
	
	
	public static void baseball() {
		int score=0;
		int startplayer=1;	//각 이닝에서 첫 타자 타순
		boolean[] base;
		
		for(int i=1;i<=N;i++) { //주어진 이닝 수 만큼 반복
			int outcount=0;
			base=new boolean[4];
			outer: while(true) {
				for(int j=startplayer;j<=9;j++) {
					int hit=arr[i][lineup[j]];
					switch (hit) {
					case 0:
						outcount++;
						break;
					case 1:	//안타
						for(int k=3;k>=1;k--) {
							if(base[k]) {
								if(k==3) {
									score++;
									base[k]=false;
									continue;
								}
								base[k]=false;
								base[k+1]=true;
							}
						}
						base[1]=true;
						break;
					case 2:	//2루타
						for(int k=3;k>=1;k--) {
							if(base[k]) {
								if(k==3||k==2) {
									score++;
									base[k]=false;
									continue;
								}
								base[k]=false;
								base[k+2]=true;
							}
						}
						base[2]=true;
						break;
					case 3:	//3루타
						for(int k=3;k>=1;k--) {
							if(base[k]) {
								
								score++;
								base[k]=false;
							}
						}
						base[3]=true;
						break;
					case 4:	//홈런
						for(int k=3;k>=1;k--) {
							if(base[k]) {
								score++;
								base[k]=false;
							}
						}
						score++;
						break;
					default:
						break;
					}
					if(outcount==3) {	//3아웃되면 다음 이닝의 startplayer는 마지막 타순+1
						startplayer=j+1;
						if(startplayer==10) startplayer=1;
						break outer;
					}
					
				}
				startplayer=1; //1~9번까지 다 돌았는데 3아웃이 안나왔으므로 다시 1번 타자부터
			}
		}
		ans=Math.max(ans, score);
	}
}
