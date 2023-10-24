class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        int length=numbers.length;
        dfs(numbers,0,length,0,target);
        return answer;
    }
    
    public void dfs(int[] numbers,int cnt,int len,int sum,int target){
        if(cnt==len){
            if(sum==target){
                answer++;
            }
            return;
        }
       
           dfs(numbers,cnt+1,len,sum+numbers[cnt],target);
            dfs(numbers, cnt+1,len,sum-numbers[cnt],target);
        
        
        
       
        
        
        
    }
}