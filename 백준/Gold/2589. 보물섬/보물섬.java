import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='L'){
                    bfs(i,j,0);
                }
            }
        }

        System.out.println(max);


    }
    public static void bfs(int r, int c, int d){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new Node(r, c, d));
        visited[r][c]=true;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int depth = node.depth;
            max = Math.max(max,depth);
            
            for(int i=0;i<4;i++){
                int cx = x+dx[i];
                int cy = y+dy[i];
                
                if(cx<0||cy<0||cx>=N||cy>=M) continue;

                if(map[cx][cy]=='W') continue;

                if(!visited[cx][cy]){
                    q.add(new Node(cx, cy, depth+1));
                    visited[cx][cy]=true;
                }
            }
           
        }
    }
    static class Node{
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
 
}