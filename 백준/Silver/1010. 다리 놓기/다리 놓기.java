
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		int N,M;
		
		for (int test_case = 0; test_case < T; test_case++) {
			int[][] B=new int[31][31];
			N=sc.nextInt();
			M=sc.nextInt();
			
			for(int i=0;i<=M;i++) {
				for(int j=0,end=Math.min(i, N);j<=end;j++) {
					if(j==0||i==j) B[i][j]=1;
					else B[i][j]=B[i-1][j-1]+B[i-1][j];
				}
			}
			
			System.out.println(B[M][N]);
		}
		
	}

}
