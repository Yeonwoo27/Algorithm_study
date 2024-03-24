import java.util.*;

class Solution {
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int[] depth;
    
    public int solution(int n, int[][] edge) {
        int answer=0;
        node = new ArrayList[n+1];
        visited= new boolean[n+1];
        depth = new int[n+1];
        
        for(int i=1;i<=n;i++){
            node[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            node[edge[i][0]].add(edge[i][1]);
            node[edge[i][1]].add(edge[i][0]);
        }
        
        bfs();
        
        Arrays.sort(depth);
        int max = depth[n];
        for(int k : depth){
            if(max==k) answer++;
        }
        
        return answer;
    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        depth[1]=0;
            
        while(!q.isEmpty()){
            int k = q.poll();
            visited[k]=true;
            for(Integer n : node[k]){
                if(!visited[n]){
                    visited[n]=true;
                    depth[n]=depth[k]+1;
                    q.add(n);
                }
            }
        }
    }
}