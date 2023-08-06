
import java.io.*;
import java.util.*;
public class Main {

	public static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		boolean check=false;	//-가 등장하기 전에는 false
		int ans=0; 				// 결과값 저장
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			
			if(c!='+'&&c!='-') {	//연산자가 아니면 sb에 숫자 추가
				sb.append(c);
			}
			if(c=='+'||c=='-'||i==str.length()-1) {	//연산자가 오거나 마지막 숫자가 오면
				if(!check) {	//-가 등장하기 전에는 다 더해준다.
					ans+=Integer.parseInt(sb.toString());
					sb.setLength(0);
				}
				else{			// -가 등장한 이후로는 다 빼준다.
					ans-=Integer.parseInt(sb.toString());
					sb.setLength(0);
				}
			}
			
			if(c=='-') check=true;	// -가 나왔으므로 check값에 true 대입
			
		}
		
		System.out.println(ans);
	
		
		
	}	
	
	
}
