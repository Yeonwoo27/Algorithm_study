import java.util.*;
import java.io.*;

public class Main {

    public static int N,K,S,X,Y;
    public static int[][] map;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static PriorityQueue<Virus> queue = new PriorityQueue<>();
    public static int [][] useMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        useMap = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for(int n=0;n<S;n++){

            // N x N 배열을 돌면서 바이러스가 있으면 우선순위 큐에 집어넣는다
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(map[i][j]!=0&&useMap[i][j]==0){
                        queue.offer(new Virus(i,j,map[i][j]));
                    }
                }
            }

            while(!queue.isEmpty()){
                
                Virus virus = queue.poll();

                virusSpread(virus.n,virus.r,virus.number);
                useMap[virus.n][virus.r]=1;
               
            }
        }

        System.out.println(map[X][Y]);

    }

    public static void virusSpread(int x, int y, int num){
        for(int i=0;i<4;i++){
            int cx = x+dx[i];
            int cy = y+dy[i];

            if(cx<=0||cy<=0||cx>N||cy>N) continue;

            if(map[cx][cy]==0){
                map[cx][cy] = num;
            }

        }
    }
   
    
    public static class Virus implements Comparable<Virus>{
        int n;
        int r;
        int number;
    
        public Virus(int n, int r, int number) {
            this.n = n;
            this.r = r;
            this.number = number;
        }
    
        @Override
        public int compareTo(Virus o) {
            return this.number-o.number;
        }
    }
 
}