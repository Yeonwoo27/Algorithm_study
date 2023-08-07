
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb=new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		
		Stack<int[]> stack=new Stack<>();
		int[] number=new int[N+1];	//해당 탑에서 쏜 신호를 수신하는 탑 번호를 저장하는 배열
		int max=Integer.MIN_VALUE; // 가장 높은 탑의 높이를 저장
		
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			
	
			int height=Integer.parseInt(st.nextToken()); //입력받은 탑의 높이
			
			while(!stack.isEmpty()) {
				if(stack.peek()[1]>=height) {
					System.out.print(stack.peek()[0]+" ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			
			stack.push(new int[] {i,height});

		
		
		}
	}
}
