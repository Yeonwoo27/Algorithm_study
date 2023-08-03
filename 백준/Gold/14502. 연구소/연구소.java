
import java.util.*;
import java.io.*;
public class Main {

	public static int[][] arr;
    
    public static int[] dx= {0,1,-1,0};
    public static int[] dy= {1,0,0,-1};
    
    
    public static int N,M;
    public static int max=0;
    
    
    public static void main(String[] arg)  {
        Scanner sc=new Scanner(System.in);
        
        N=sc.nextInt();
        M=sc.nextInt();
        arr=new int[N][M];
        
       for(int i=0;i<N;i++) {
    	   for(int j=0;j<M;j++) {
    		   arr[i][j]=sc.nextInt();
    	   }
       }
    
        
       dfs(0);
       
       System.out.println(max);
        
    }
    
    public static void dfs(int wallcnt) {
        if(wallcnt==3) {
     	   bfs();
     	   return;
        }
        for(int i=0;i<N;i++) {
     	   for(int j=0;j<M;j++) {
     		   if(arr[i][j] == 0) {
                     arr[i][j] = 1;
                     dfs(wallcnt+1);
                     arr[i][j] = 0;
                 }
     	   }
        }
     }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if(arr[i][j]==2) {
    				q.add(new Node(i,j));
    			}
    		}
    	}
        //원본 연구소를 바꾸지 않기 위한 카피맵 사용
    	int copy_arr[][]=new int[N][M];
    	for(int i=0;i<N;i++) {
    		copy_arr[i]=arr[i].clone();
    }
    	while(!q.isEmpty()) {
    		Node tmp=q.poll();
    		int x=tmp.x;
    		int y=tmp.y;
    		for(int i=0;i<4;i++) {
    			int nx=x+dx[i];
    			int ny=y+dy[i];
    			
    			if(nx<0||ny<0||nx>=N||ny>=M) continue;
    			
    			if(copy_arr[nx][ny]==0) {
    				copy_arr[nx][ny]=2;
    				q.add(new Node(nx,ny));
    			}
    		}
    		int num=0;
    		for(int i=0;i<N;i++) {
    			for(int j=0;j<M;j++) {
    				if(copy_arr[i][j]==0) num++;
    			}
    		}
    		//max=Math.max(num, max);
    	}
        //SafeZone 확인
        funcSafeZone(copy_arr);
    }

    private static void funcSafeZone(int[][] copyMap) {
        int safeZone =0;
        for(int i=0; i<N ; i++) {
            for(int j=0; j<M; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (max < safeZone) {
            max = safeZone;
        }
    }

    //Queue에 좌표값 x,y를 넣기 위함.
    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

