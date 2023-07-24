
import java.util.*;
class Point {
	int x;
	int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Main{
    public static int[][] arr;
    public static boolean[] visited;
    public static List<Point> home=new LinkedList<>();
    public static List<Point> chicken=new LinkedList<>();
    public static int N,M;
    public static int ans=Integer.MAX_VALUE;
    
    public static void dfs(int start, int cnt) {
       if(cnt==M) {
    	   int sum=0;
    	   for(int i=0;i<home.size();i++) {
    		   int length=Integer.MAX_VALUE;
    		   for(int j=0;j<chicken.size();j++) {
    			   if(visited[j]==true) {
    				   length=Math.min(length, Math.abs(home.get(i).x-chicken.get(j).x)+Math.abs(home.get(i).y-chicken.get(j).y));
    				   
    			   }
    		   }
    		   sum+=length;
    	   }
    	   ans=Math.min(ans, sum);
    	   return;
       }
       
    	
       for(int i=start;i<chicken.size();i++) {
    	   visited[i]=true;
    	   dfs(i+1,cnt+1);
    	   visited[i]=false;
       }
    	
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][N];
        

        for (int i = 0; i < N; i++) {
            for(int j=0;j<N;j++) {
            	arr[i][j]=sc.nextInt();
            	if(arr[i][j]==1) home.add(new Point(i,j));
            	if(arr[i][j]==2) chicken.add(new Point(i,j));
            }
        }
        
        visited=new boolean[chicken.size()];

        dfs(0,0);
        
        System.out.println(ans);
    }
}
