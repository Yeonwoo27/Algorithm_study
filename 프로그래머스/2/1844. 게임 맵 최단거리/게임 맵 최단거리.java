import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int min = Integer.MIN_VALUE;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps.length,maps[0].length,maps);
        if(min == Integer.MIN_VALUE){
            return -1;
        }
        else return min;
    }
    
    public static void bfs(int n, int m, int[][] map){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,1));
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int value = node.value;
            
            if(x==n-1&&y==m-1){
                min = Math.max(min, value);
            }
            
            for(int i=0;i<4;i++){
                int cx = x+dx[i];
                int cy = y+dy[i];
                
                if(cx<0||cy<0||cx>=n||cy>=m) continue;
                
                if(!visited[cx][cy]&&map[cx][cy]==1){
                    q.add(new Node(cx,cy,value+1));
                    visited[cx][cy]=true;
                }
            }
        }
        
    }
    
    static class Node{
        int x;
        int y;
        int value;
        
        Node(int x, int y,int value){
            this.x=x;
            this.y=y;
            this.value = value;
        }
    }
}