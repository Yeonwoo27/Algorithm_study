import java.util.*;
class Solution {
    
    public int solution(int[][] routes) {
        int answer = 0;
        boolean[] visited=new boolean[routes.length];
        
       Arrays.sort(routes, new Comparator<int[]>() {
    
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        
        for(int i=0;i<routes.length;i++){
            if(!visited[i]){
                visited[i]=true;
                int num=routes[i][1];
                for(int j=i+1;j<routes.length;j++){
                    if(num>=routes[j][0]){
                        visited[j]=true;
                        if(routes[j][1]<num){
                            num=routes[j][1];
                        }
                    }else{
                        break;
                    }
                }
                answer++;
            }
            
        }
       
       
        return answer;
    }
    
}