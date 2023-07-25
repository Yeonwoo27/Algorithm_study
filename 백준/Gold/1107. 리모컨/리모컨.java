
import java.util.*;

public class Main{
	
	public static boolean[] broken;
	public static int N,M;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();	// 이동하려는 채널
		M=sc.nextInt();	// 고장난 버튼의 개수
		
		broken=new boolean[10];	// 고장난 버튼 배열 0~9
		
		for(int i=0;i<M;i++) {
			int n=sc.nextInt();
			broken[n]=true;
		}
		
		int ans=Math.abs(100-N);	//초기값
		
		for(int i=0;i<999999;i++) {
			String str=Integer.toString(i);
			boolean check=false;
			for(int j=0;j<str.length();j++) {	
				if(broken[str.charAt(j)-'0']) {
					check=true;
					break;
				}
				}
			if(!check) {
				int min=str.length()+Math.abs(N-i);	//str길이 만큼 채널 이동을 하고, 그 이동한 채널에서 목표 채널까지 +/- 입력한 수를 더한다.
				ans=Math.min(min, ans);
				}
			}
		
		
		System.out.println(ans);
			
		
	}
}
