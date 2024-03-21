import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek()<K){
            if(pq.size()==1) {
                answer = -1;
                break;
            }
            int n1 = pq.poll();
            int n2 = pq.poll();
            
            int num = n1 + (n2*2);
            pq.add(num);
            
            answer++;
        }
            
        
        return answer;
    }
}