import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int[] map;
    public static boolean[] visited;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N+1];
        visited = new boolean[N+1];

       
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            map[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1;i<=N;i++){
            visited[i]=true;
            dfs(i,i);
            visited[i]=false;
        }

        Collections.sort(answer); 
        System.out.println(answer.size());
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }

    public static void dfs(int start, int n){

       if(!visited[map[start]]){
        visited[map[start]]=true;
        dfs(map[start],n);
        visited[map[start]]=false;

       }
        
       if(map[start] == n) {
			answer.add(n);
		}

    }

   
    
  
}