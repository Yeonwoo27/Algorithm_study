

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N,M,R;
	public static int height,width;
	public static int[][] arr;
	public static boolean rotate=false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());	//세로 길이
		M=Integer.parseInt(st.nextToken());	//가로 길이
		R=Integer.parseInt(st.nextToken());	//연산의 수
		height=N;
		width=M;
		int Max=Math.max(N, M);
		arr=new int[Max][Max];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int cal_num=Integer.parseInt(st.nextToken());
			
			if(cal_num==3||cal_num==4) {
				if(!rotate) {
					height=M;
					width=N;
					rotate=!rotate;
				}
				else {
					height=N;
					width=M;
					rotate=!rotate;
				}
			}
			cal(cal_num);
		}
		
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		
		
		
	}
	public static void cal(int n) {
		int[][] res_arr = null;
		
		switch (n) {
		case 1:
			res_arr=new int[height][width];
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					res_arr[i][j]=arr[height-1-i][j];
				}
			}
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					arr[i][j]=res_arr[i][j];
				}
			}
			break;
		case 2:
			res_arr=new int[height][width];
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					res_arr[i][j]=arr[i][width-1-j];
				}
			}
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					arr[i][j]=res_arr[i][j];
				}
			}
			break;
		case 3:
			res_arr=new int[height][width];
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					res_arr[i][j]=arr[width-1-j][i];
				}
			}
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					arr[i][j]=res_arr[i][j];
				}
			}
			break;
		case 4:
			res_arr=new int[height][width];
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					res_arr[i][j]=arr[j][height-1-i];
				}
			}
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					arr[i][j]=res_arr[i][j];
				}
			}
			break;
		case 5:
			res_arr=new int[height][width];
			for(int i=0;i<height/2;i++) {
				for(int j=0;j<width/2;j++) {
					res_arr[i][j+width/2]=arr[i][j];
				}
			}
			for(int i=0;i<height/2;i++) {
				for(int j=width/2;j<width;j++) {
					res_arr[i+height/2][j]=arr[i][j];
				}
			}
			for(int i=height/2;i<height;i++) {
				for(int j=width/2;j<width;j++) {
					res_arr[i][j-width/2]=arr[i][j];
				}
			}
			for(int i=height/2;i<height;i++) {
				for(int j=0;j<width/2;j++) {
					res_arr[i-height/2][j]=arr[i][j];
				}
			}
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					arr[i][j]=res_arr[i][j];
				}
			}
			break;
		case 6:
			res_arr=new int[height][width];
			for(int i=0;i<height/2;i++) {
				for(int j=0;j<width/2;j++) {
					res_arr[i+height/2][j]=arr[i][j];
				}
			}
			for(int i=0;i<height/2;i++) {
				for(int j=width/2;j<width;j++) {
					res_arr[i][j-width/2]=arr[i][j];
				}
			}
			for(int i=height/2;i<height;i++) {
				for(int j=width/2;j<width;j++) {
					res_arr[i-height/2][j]=arr[i][j];
				}
			}
			for(int i=height/2;i<height;i++) {
				for(int j=0;j<width/2;j++) {
					res_arr[i][j+width/2]=arr[i][j];
				}
			}
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					arr[i][j]=res_arr[i][j];
				}
			}
			break;
		
		default:
			break;
		}
		
	}

}
