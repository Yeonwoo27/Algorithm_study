import java.io.*;
import java.util.*;
public class Main {
	public static StringBuilder sb=new StringBuilder();
	public static int N,M,x1,y1,K;
	public static int[][] arr;
	public static int[] dice;
    
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		x1=Integer.parseInt(st.nextToken());
		y1=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		dice=new int[7];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int dir=Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:
				if(y1+1<M) roll(x1,++y1,1);		
				break;
			case 2:
				if(y1-1>=0) roll(x1,--y1,2);
				break;
			case 3:
				if(x1-1>=0) roll(--x1,y1,3);
				break;
			case 4:
				if(x1+1<N) roll(++x1,y1,4);
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
		
	}
	public static void roll(int x, int y,int dir) {
		int tmp=dice[1];
		switch (dir) {
		case 1:
			dice[1]=dice[4];
			dice[4]=dice[6];
			dice[6]=dice[3];
			dice[3]=tmp;
			break;
		case 2:
			dice[1]=dice[3];
			dice[3]=dice[6];
			dice[6]=dice[4];	
			dice[4]=tmp;
			break;	
		case 3:
			dice[1]=dice[5];
			dice[5]=dice[6];
			dice[6]=dice[2];
			dice[2]=tmp;
			break;
		case 4:
			dice[1]=dice[2];
			dice[2]=dice[6];
			dice[6]=dice[5];		
			dice[5]=tmp;
			break;
		default:
			break;
		}
		if(arr[x][y]==0) arr[x][y]=dice[6];
		else {
			dice[6]=arr[x][y];
			arr[x][y]=0;
		}
		
		sb.append(dice[1]);
		sb.append(" ");
	}
	
	
}
