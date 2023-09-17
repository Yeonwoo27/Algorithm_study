
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int N;
	public static int[] arr;
	public static ArrayList<Integer> list=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		arr=new int[N+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		list.add(Integer.MIN_VALUE);
		
		for(int i=1;i<=N;i++) {
			int num=arr[i];
			if(num>list.get(list.size()-1)) list.add(num);
			
			else {
				int left=1;
				int right=list.size()-1;
				while(left<right) {
					int mid=(left+right)/2;
					if(num>list.get(mid)) left=mid+1;
					else right=mid;
				}
				list.set(right, num);
			}
		}
		
		System.out.println(list.size()-1);
		
		
		

	}
	
	
}
