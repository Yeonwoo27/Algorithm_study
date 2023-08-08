
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = Math.min(N, M) / 2; //한 바퀴를 도는 라인의 수
		for(int i=0; i<R ; i++) {
			
			for(int j=0; j<count; j++) { 
				int temp = arr[j][j]; //첫 번째 원소(맨 왼쪽 위)는 따로 저장해놓고 마지막에 대입해준다.
				
				for(int k=j+1; k<M-j; k++)	//라인의 위쪽 
					arr[j][k-1] = arr[j][k];
				
				for(int k=j+1; k<N-j; k++)	//라인의 오른쪽 
					arr[k-1][M-1-j] = arr[k][M-1-j];
				
				for(int k=M-2-j; k>=j; k--)	//라인의 아래쪽 
					arr[N-1-j][k+1] = arr[N-1-j][k];
				
				for(int k=N-2-j; k>=j; k--)	//라인의 왼쪽 
					arr[k+1][j] = arr[k][j];
				
				arr[j+1][j] = temp;	//아까 저장해놓은거 넣기
			}
		}
		
		for(int j=0; j<N; j++) {
			for(int k=0; k<M; k++) {
				System.out.print(arr[j][k] + " ");
			}
			System.out.println();
		}
	}
}