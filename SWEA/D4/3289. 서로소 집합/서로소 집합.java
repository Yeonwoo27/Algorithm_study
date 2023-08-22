
import java.util.*;
import java.io.*;

class Solution{

public static int N,M;
public static int[] arr;
public static void main(String args[]) throws Exception
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());

int T;
T=Integer.parseInt(st.nextToken());


for(int test_case = 1; test_case <= T; test_case++){
	StringBuilder sb=new StringBuilder();
	st=new StringTokenizer(br.readLine());
	N=Integer.parseInt(st.nextToken());
	M=Integer.parseInt(st.nextToken());
	arr=new int[N+1];
	for(int i=1;i<=N;i++) arr[i]=i;
	
	for(int i=0;i<M;i++) {
		st=new StringTokenizer(br.readLine());
		int k=Integer.parseInt(st.nextToken());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		if(k==0) {
			union(a,b);
		}
		else if(k==1) {
			if(find(a)==find(b)) sb.append(1);
			else sb.append(0);
		}
	}
	
	System.out.println("#"+test_case+" "+sb);
	
	

}
}
public static void union(int x, int y) {
	int xRoot=find(x);
	int yRoot=find(y);
	if(xRoot==yRoot) return;
	arr[yRoot]=xRoot;
}
public static int find(int x) {
	if(x==arr[x]) return x;
	else return arr[x]=find(arr[x]);
}
}