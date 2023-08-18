import java.io.*;
import java.util.*;

public class Main{
	
	public static int N,x,y,d,g;
	public static int[][] arr=new int[101][101];
	public static ArrayList<Integer> list=new ArrayList<>();
	public static int[] dx= {0,-1,0,1}; //우 상 좌 하
	public static int[] dy= {1,0,-1,0};
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		for(int t=0;t<N;t++) {
			st=new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			g=Integer.parseInt(st.nextToken());
			
			int tmp=x;
			x=y;
			y=tmp;
			
			arr[x][y]=1;
			list.add(d);
			x=x+dx[d];
			y=y+dy[d];
			arr[x][y]=1;
			
			for(int i=0;i<g;i++) {
				for(int j=list.size()-1;j>=0;j--) {
					
					int dir=list.get(j); //좌표를 저장해놓은 리스트에서 역순으로 빼온다.
					list.add((dir+1)%4); //그리고 다음 방향으로 이동 시킨뒤 다시 넣는다.
					
					int nx=x+dx[(dir+1)%4];
					int ny=y+dy[(dir+1)%4];
					if(nx>=0&&nx<=100&&ny>=0&&ny<=100) { //이동된 x,y좌표가 범위내라면 이동
						x=nx;
						y=ny;
						arr[x][y]=1;
					}
				}
				
			}
			list.clear();
		}
		
		
		int result=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1) { //왼쪽위에서부터 탐색하면 겹치는 부분없이 탐색 가능
					if(arr[i][j+1]==1&&arr[i+1][j]==1&&arr[i+1][j+1]==1) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
		
	}
	
		
}

	
	
	
	

