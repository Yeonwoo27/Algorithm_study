
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int[] dpR=new int[1001];
		int[] dpG=new int[1001];
		int[] dpB=new int[1001];
		
		int N=sc.nextInt();
		//첫 줄 입력은 dp배열의 초기값 설정
		dpR[1]=sc.nextInt();
		dpG[1]=sc.nextInt();
		dpB[1]=sc.nextInt();
		
		for(int i=2;i<=N;i++) {
			int R=sc.nextInt();
			int G=sc.nextInt();
			int B=sc.nextInt();
			
			dpR[i]=Math.min(dpG[i-1], dpB[i-1])+R;
			dpG[i]=Math.min(dpR[i-1], dpB[i-1])+G;
			dpB[i]=Math.min(dpR[i-1], dpG[i-1])+B;
		}
		
		System.out.println(Math.min(dpR[N], Math.min(dpG[N], dpB[N])));
	}

}
