
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution
{
	public static char[][] arr;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
public static void main(String args[]) throws Exception
{

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st=new StringTokenizer(br.readLine());
int T;
T=Integer.parseInt(st.nextToken());


for(int test_case = 1; test_case <= T; test_case++)
{
	st=new StringTokenizer(br.readLine());
	int H=Integer.parseInt(st.nextToken());
	int W=Integer.parseInt(st.nextToken());
	arr=new char[H][W]; //전체 맵
	int r=0,c=0,dir=0;	//탱크의 행열 좌표와 방향
	
	for(int i=0;i<H;i++) {
		String str=br.readLine();
		for(int j=0;j<W;j++) {
			arr[i][j]=str.charAt(j);
			if(arr[i][j]=='^') {
				r=i;
				c=j;
				dir=0;
			}
			else if(arr[i][j]=='v') {
				r=i;
				c=j;
				dir=1;
			}
			else if(arr[i][j]=='<') {
				r=i;
				c=j;
				dir=2;
			}
			else if(arr[i][j]=='>') {
				r=i;
				c=j;
				dir=3;
			}
		}
	}
	
	int N=Integer.parseInt(br.readLine());
	char[] action=new char[N]; //탱크의 행동을 순서대로 저장해놓는 배열
	String str=br.readLine();
	for(int i=0;i<N;i++) {
		action[i]=str.charAt(i);
		
	}

	for(int i=0;i<N;i++) {
	
		if(action[i]=='U') {
			dir=0;
			arr[r][c]='^';
			int x=r+dx[dir];
			int y=c+dy[dir];
			if(x<0||y<0||x>=H||y>=W) continue;
			if(arr[x][y]=='.'&&arr[x][y]!='-') {
				arr[r][c]='.';
				r=x;
				c=y;
				arr[x][y]='^';
			}
		}
		else if(action[i]=='D') {
			dir=1;
			arr[r][c]='v';
			int x=r+dx[dir];
			int y=c+dy[dir];
			if(x<0||y<0||x>=H||y>=W) continue;
			if(arr[x][y]=='.'&&arr[x][y]!='-') {
				arr[r][c]='.';
				r=x;
				c=y;
				arr[x][y]='v';
			}
		}
		else if(action[i]=='L') {
			dir=2;
			arr[r][c]='<';
			int x=r+dx[dir];
			int y=c+dy[dir];
			if(x<0||y<0||x>=H||y>=W) continue;
			if(arr[x][y]=='.'&&arr[x][y]!='-') {
				arr[r][c]='.';
				r=x;
				c=y;
				arr[x][y]='<';
			}
		}
		else if(action[i]=='R') {
			dir=3;
			arr[r][c]='>';
			int x=r+dx[dir];
			int y=c+dy[dir];
			if(x<0||y<0||x>=H||y>=W) continue;
			if(arr[x][y]=='.'&&arr[x][y]!='-') {
				arr[r][c]='.';
				r=x;
				c=y;
				arr[x][y]='>';
			}
		}
		else if(action[i]=='S') {
			int x=r;
			int y=c;
			
			while(true) {
				x=x+dx[dir];
				y=y+dy[dir];
				if(x<0||y<0||x>=H||y>=W) break;
				if(arr[x][y]=='#') break;
				if(arr[x][y]=='*') {
					arr[x][y]='.';
					break;
				}
			}
			
		}
	}
	System.out.print("#"+test_case+" ");
	for(int i=0;i<H;i++) {
		for(int j=0;j<W;j++) {
			System.out.print(arr[i][j]);
		}
		System.out.println();
	}
}

}

}