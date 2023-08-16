
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 먼저 오름차순으로 정렬을 해준뒤, C개의 알파벳중에서 L개를 뽑고 뽑으면서 str을 만들어준다.
/* 그리고 재귀함수 진행중에 길이가 L이 되면 check함수 실행. 
/*check함수는 각 자리에 최소 2개의 자음과 최소 한개의 모음이 있는지 체크
 */
public class Main {
	public static int L,C;
	public static char[] arr;
	public static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new char[C];
		
		String str=br.readLine();
		for(int i=0;i<C;i++) {
			arr[i]=str.charAt(i*2);
		}
		Arrays.sort(arr);
		
		dfs(0,0,"");
		
		System.out.println(sb);
	}
	public static void dfs(int start,int cnt,String str) {
		if(cnt==L) {
			if(check(str)) {
				sb.append(str);
				sb.append("\n");
			}
			return;
		}
		for(int i=start;i<C;i++) {
			dfs(i+1,cnt+1,str+arr[i]);
		}
	}
	public static boolean check(String s) {
		int num1=0; //모음의 개수
		int num2=0; //자음의 개수
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u') {
				num1++;
			}
			else num2++;
		}
		if(num1>=1&&num2>=2) return true;
		else return false;
	}
}



