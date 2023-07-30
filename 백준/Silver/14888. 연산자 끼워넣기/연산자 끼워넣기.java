

import java.util.*;
public class Main{
 
    static int[] arr;    //숫자 배열
    static int[] opr_arr;    //연산자 배열 (숫자 사이사이에 들어갈 연산자)
    static int[] opr=new int[4];    //연산자 배열 (4번 입력받을 배열)
    static int N;
    public static int min=Integer.MAX_VALUE;
    public static int max=Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N = sc.nextInt();
        arr=new int[N];
        opr_arr=new int[N-1];
        for(int i=0;i<N;i++) {
        	arr[i]=sc.nextInt();
        }
        for(int i=0;i<4;i++) {
        	opr[i]=sc.nextInt();
        }
        dfs(0);
        System.out.println(max);
        System.out.println(min);
        
    }
    public static void dfs( int cnt) {
    	if(cnt==N-1) {
    		cal();
    		return;
    	}
    	for(int i=0;i<4;i++) {
    		if(opr[i]!=0) {
    			opr[i]--;
    			opr_arr[cnt]=i;
    			dfs(cnt+1);
    			opr[i]++;
    		}
    	}
    }
    public static void cal() {
    	int sum=arr[0];
    	for(int i=0;i<N-1;i++) {
    		if(opr_arr[i]==0) {
    			sum=sum+arr[i+1];
    		}
    		else if(opr_arr[i]==1) {
    			sum=sum-arr[i+1];
    		}
    		else if(opr_arr[i]==2) {
    			sum=sum*arr[i+1];
    		}
    		else if(opr_arr[i]==3) {
    			sum=sum/arr[i+1];
    		}
    	}
    	max=Math.max(max, sum);
    	min=Math.min(min, sum);
    }
   
}
