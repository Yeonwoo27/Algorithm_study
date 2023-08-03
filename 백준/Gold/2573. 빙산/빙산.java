
import java.util.*;
public class Main {
	public static int N,M;
	public static int[][] arr;
	public static int[][] arr2;
	public static int[] dx= {0,0,1,-1};
	public static int[] dy= {1,-1,0,0};
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int cnt=0;
    	int ans=0;
    	N=sc.nextInt();
    	M=sc.nextInt();
    	arr=new int[N+1][M+1];
    	arr2=new int[N+1][M+1];
    	
    	
    	
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=M;j++) {
    			arr[i][j]=sc.nextInt();
    			arr2[i][j]=arr[i][j];
    			
    		}
    	}
    	//arr2=arr.clone();
    	while((cnt=check())<2) {
    		if(cnt==0) {
    			ans=0;
    			break;
    		}
    		bfs();
    		ans++;
    	}
    	
    	System.out.println(ans);
    	
    }
    public static int check() {
    	boolean[][] visited=new boolean[N+1][M+1];
    	
    	int cnt=0;
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=M;j++) {
    			if(arr[i][j]!=0&&!visited[i][j]) {
    				dfs(i,j,visited);
    				cnt++;
    			}
    		}
    	}
    	
    	return cnt;
    }
    public static void dfs(int x, int y,boolean[][] visited) {
    	visited[x][y]=true;
    	
    	for(int i=0;i<4;i++) {
    		int cx=x+dx[i];
    		int cy=y+dy[i];
    		
    		if(cx<=0||cy<=0||cx>N||cy>M) continue;
    		
    		if(arr[cx][cy]!=0&&!visited[cx][cy]) {
    			dfs(cx,cy,visited);
    		}
    			
    		
    	}
    }
    public static void bfs() {
    	Queue<int[]> q=new LinkedList<>();
    	
    	boolean[][] visited=new boolean[N+1][M+1];
    	
    	for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] != 0) {
                    q.add(new int[] {i,j});
                    visited[i][j]=true;
                }
            }
        }
    	int cx,cy;
    	while(!q.isEmpty()) {
    		int[] tmp=q.poll();
    		int x=tmp[0];
    		int y=tmp[1];
    		
    		int seaNum=0;
    		
    		for(int i=0;i<4;i++) {
    			cx=x+dx[i];
    			cy=y+dy[i];
    			
    			if(cx<=0||cy<=0||cx>N||cy>M) continue;
    			
    			if(!visited[cx][cy]&&arr[cx][cy]==0) {
    				seaNum++;
    			}
    		}
    		if(arr[x][y]-seaNum<0) arr[x][y]=0;
    		else arr[x][y]-=seaNum;
    	}
    	
    	
    }
}
