

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int S,P;
	public static char[] arr;
	public static int A,C,G,T;
	public static int ans=0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		S=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		arr=new char[S];
		
		String str=br.readLine();
		for(int i=0;i<S;i++) {
			arr[i]=str.charAt(i);
		}
		
		st=new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		G=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		int pA=0,pC=0,pG=0,pT=0;
		for(int i=0;i<P;i++) {
			if(arr[i]=='A') pA++;
			else if(arr[i]=='C') pC++;
			else if(arr[i]=='G') pG++;
			else if(arr[i]=='T') pT++;
		}
		compare(pA,pC,pG,pT);
		
		for(int i=0;i<S-P;i++) {
			if(arr[i]=='A') pA--;
			else if(arr[i]=='C') pC--;
			else if(arr[i]=='G') pG--;
			else if(arr[i]=='T') pT--;
			
			if(arr[i+P]=='A') pA++;
			else if(arr[i+P]=='C') pC++;
			else if(arr[i+P]=='G') pG++;
			else if(arr[i+P]=='T') pT++;
			
			compare(pA,pC,pG,pT);
		}
		
		System.out.println(ans);
	}
	public static void compare(int a,int c, int g, int t) {
		if(a>=A&&c>=C&&g>=G&&t>=T) ans++;
	}

}
