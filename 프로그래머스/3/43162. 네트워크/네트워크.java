class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers,i,n);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int[][] computers,int idx, int n){
        visited[idx]=true;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                 if(computers[idx][i]==1){
                     dfs(computers,i,n);
                 }    
            }
           
        }
    }
    
}