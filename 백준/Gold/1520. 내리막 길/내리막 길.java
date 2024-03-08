
import java.util.*;
import java.io.*;

public class Main {

        
        
        public static int[][] arr;
        public static int[][] dp;
        public static int[][] length;
        public static int[] dx= {0,1,-1,0};
        public static int[] dy= {1,0,0,-1};
        
        public static int N,M;
      
        public static int result=0;
        
        
        public static void main(String[] arg) throws IOException{
            Scanner sc=new Scanner(System.in);
            
            M=sc.nextInt();
            N=sc.nextInt();
            arr=new int[M+1][N+1];
            dp=new int[M+1][N+1];
           for(int i=1;i<=M;i++) {
        	   for(int j=1;j<=N;j++) {
        		   arr[i][j]=sc.nextInt();
        		   dp[i][j]=-1;
        	   }
           }
            
        
            
           System.out.println(dfs(1,1));
            
        }
        public static int dfs(int x, int y) {
           if(x==M&&y==N) {
        	   return 1;
           }
           if(dp[x][y]!=-1) {
        	   return dp[x][y];
           }
           dp[x][y]=0;
           for(int i=0;i<4;i++) {
        	   int cx=x+dx[i];
        	   int cy=y+dy[i];
        	   
        	   if(cx<=0||cy<=0||cx>M||cy>N) continue;
        		   
        	   if(arr[cx][cy]<arr[x][y]) {
        		   dp[x][y]+=dfs(cx,cy);
        	   }
           }
           
           return dp[x][y];
        }
        
    
        
        
        
    

}
