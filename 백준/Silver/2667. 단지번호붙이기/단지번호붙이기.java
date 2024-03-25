import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int k = 1;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
               if(map[i][j]==1&&!visited[i][j]) bfs(i,j);
            }
        }

        int[] answer = new int[k];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
               if(map[i][j]!=0) answer[map[i][j]]++;
            }
        }

        Arrays.sort(answer);

        System.out.println(k-1);
        for(int i=1;i<k;i++){
            System.out.println(answer[i]);
        }
    }
                            
    public static void bfs(int r, int c){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visited[r][c]=true;
        map[r][c] = k;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            visited[x][y]=true;

            for(int i=0;i<4;i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx<0||cy<0||cx>=N||cy>=N) continue;

                if(map[cx][cy]==1&&!visited[cx][cy]){
                    visited[cx][cy]=true;
                    map[cx][cy] = k;
                    q.add(new Node(cx,cy));
                }
            }
        }

        k++;

    }

    public static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}