import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int n1, n2;
    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    static int[] depth;
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        depth = new int[N+1];
        matrix = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            matrix[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a].add(b);
            matrix[b].add(a);
        }
        depth[n1]=0;
        dfs(n1);

        if(answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }
    public static void dfs(int num){
        if(num == n2){
            answer = depth[num];
            return;
        }

        for(Integer i : matrix[num]){
            if(!visited[i]){
                depth[i] = depth[num]+1;
                visited[i]=true;
                dfs(i);
                visited[i]=false;   
            }
        }
    }
                        
  
}