
import java.util.*;
import java.io.*;
public class Main {
	public static int N,M;
	public static int[][] arr;
	public static Queue<int[]> q=new LinkedList<>();
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
    public static void main(String[] args) throws IOException{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	M=Integer.parseInt(st.nextToken());
    	N=Integer.parseInt(st.nextToken());
    	arr=new int[N][M];
    	int max=0;
    	
    	for(int i=0;i<N;i++) {
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j]=Integer.parseInt(st.nextToken());
    			if(arr[i][j]==1) q.add(new int[] {i,j});
    		}
    	}
    	bfs();
    	
    	if(checkzero()) {
    		System.out.println("-1");
    	}
    	else {
    		for(int i=0;i<N;i++) {
        		for(int j=0;j<M;j++) {
        			max=Math.max(max, arr[i][j]);
        		}
        	}
    		System.out.println(max-1);
    	}
    	
    }
    public static boolean checkzero() {
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if(arr[i][j]==0) return true;
    		}
    	}
    	return false;
    }
    public static void bfs() {
    	
    	while(!q.isEmpty()) {
    		int[] tmp=q.poll();
    		int x=tmp[0];
    		int y=tmp[1];
    		
    		
    		for(int i=0;i<4;i++) {
    			int cx=x+dx[i];
    			int cy=y+dy[i];
    			
    			if(cx<0||cy<0||cx>=N||cy>=M) continue;
    			
    			if(arr[cx][cy]==0) {
    				arr[cx][cy]=arr[x][y]+1;
    				q.add(new int[] {cx,cy});
    			}
    		}
 
    	}
    	
    }
}
