
import java.io.*;
import java.util.*;
public class Main {
	public static int N,M;
	public static int[][] arr;
	public static int[] dx= {-1,0,1,0};
	public static int[] dy=	{0,1,0,-1};
	public static int r,c,d;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int num=0;
		boolean check;
		while(true) {
			check=false;
			if(arr[r][c]==0) {
				arr[r][c]=2;
				num++;
			}
			for(int i=0;i<4;i++) {
				int cx=r+dx[i];
				int cy=c+dy[i];
				
				if(arr[cx][cy]==0) {
					check=true;
					move(r,c);	
					break;
				}
			}
			if(!check) {
				if(d==2) {
					if(arr[r+dx[0]][c+dy[0]]==1)	break;
					else {
						r=r+dx[0];
						c=c+dy[0];
					}
				}
				else if(d==3) {
					if(arr[r+dx[1]][c+dy[1]]==1)	break;
					else {
						r=r+dx[1];
						c=c+dy[1];
					}
				}
				else{
					if(arr[r+dx[d+2]][c+dy[d+2]]==1)	break;
					else {
						r=r+dx[d+2];
						c=c+dy[d+2];
					}
				}
				
			}
		}
		System.out.println(num);
		
	}
	public static void move(int x, int y) {
		for(int i=0;i<4;i++){
			d=d-1;
			if(d<0) d=3;
			int cx=x+dx[d];
			int cy=y+dy[d];
			if(arr[cx][cy]==0) {
				r=cx;
				c=cy;
				return;
			}
		}
	}
	
	
}
