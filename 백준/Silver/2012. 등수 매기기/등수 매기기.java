import java.io.*;
import java.util.*;
public class Main {
	
	public static int N;
	public static int[] arr;
	public static void main(String[] args) throws IOException {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);    //오름차순으로 정렬
		
		long gap=0;	         // 불만도 총 합
		
		for(int i=0;i<arr.length;i++) {
			
			gap+=Math.abs(arr[i]-(i+1));
		}
		
		System.out.println(gap);
		
		
	}	
	
	
}
