import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer=0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin,target,0,words);
        return answer;
    }
    public static void dfs(String word,String target,int num, String[] words){
        
        if(word.equals(target)){
            answer = num;
            return;
        }
        
        for(int i=0;i<words.length;i++){
            
            if(visited[i]) continue;
            
             int k=0;
            for(int j=0;j<word.length();j++){
               
                if(word.charAt(j)==words[i].charAt(j)){
                    k++;
                }
                
                if(k==(word.length()-1)){
                    visited[i]=true;
                    dfs(words[i],target,num+1,words);
                    visited[i]=false;
                }
            }
            
        }
        
    }
    
}