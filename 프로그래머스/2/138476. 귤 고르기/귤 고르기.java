import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] num = new int[100001];
        int answer = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> vlist=new ArrayList<>(map.values());
        vlist.sort((o1,o2)->o2-o1);
        
        int sum=k;
        
        for(int i : vlist){
            
            if(sum-i<=0){
                answer++;
                break;
            }
            
            sum-=i;
            answer++;
            
            
        }
        
        
        return answer;
    }
}