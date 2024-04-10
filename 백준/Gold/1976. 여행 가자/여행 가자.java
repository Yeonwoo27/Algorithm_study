import java.util.*;
import java.io.*;

public class Main {

    public static int[] list;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = i;
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int k = Integer.parseInt(st.nextToken());
                if(k==0) continue;
                union(i,j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));

        boolean possible = true;
        for (int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
 
            if (start != find(now)) {
                possible=false;
                break;
            }
        }
        if(possible) System.out.println("YES");
        else System.out.println("NO");




    }
    public static int find(int x){
      if(x==list[x]){
        return x;
      }

      return list[x] = find(list[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            if(x<y){
                list[y]=x;
            }else{
                list[x]=y;
            }
        }
    }
 
}