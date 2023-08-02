
import java.io.*;
import java.util.*;
public class Main {
	public static int N;
	
	public static int[] alpha=new int[26];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		String str;
		
		for(int i=0;i<N;i++) {
			str=br.readLine();
			int idx=0;
			for(int j=str.length()-1;j>=0;j--) {
			
			
				alpha[str.charAt(j)-'A']+=(int) Math.pow(10, idx++);
			}
		}
		
		Arrays.sort(alpha);
		int sum=0;	//전체 합
		int idx=25;	//제일 큰 숫자를 포함한 배열의 인덱스
		for(int i=9;i>=0;i--) {
			sum+=alpha[idx--]*i;
		}

		System.out.println(sum);
	}
	
}
