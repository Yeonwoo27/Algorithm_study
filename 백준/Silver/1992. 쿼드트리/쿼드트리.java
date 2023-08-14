
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		
		makeSpace(0,0,N,0);
		
	}
	
	public static void makeSpace(int sr,int sc,int size,int num ) {
		int sum_white=0;
		int sum_black=0;
		
		for(int i=sr;i<sr+size;i++) {
			for(int j=sc;j<sc+size;j++) {
				if(arr[i][j]==0) sum_white++;
				else sum_black++;
			}
		}
		if(sum_white==size*size) {
			System.out.print("0");
		}
		else if(sum_black==size*size) {
			System.out.print("1");
		}
		else {
			System.out.print("(");
			makeSpace(sr,sc,size/2,num+1);
			makeSpace(sr,sc+size/2,size/2,num+1);
			makeSpace(sr+size/2,sc,size/2,num+1);
			makeSpace(sr+size/2,sc+size/2,size/2,num+1);
			System.out.print(")");
		}
		
	}

}
