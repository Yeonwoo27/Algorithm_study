import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder answerString = new StringBuilder();
     
        int length = number.length() - k;
        
        int start = 0;
        
        for(int i=0;i<length;i++){
            int max = 0;
            for(int j=start;j<=k+i;j++){
                if(max<number.charAt(j)-'0') {
                    max =number.charAt(j)-'0';
                    start = j+1;
                }
            }
            answerString.append(max);
            
        }
        
        return answerString.toString();
    }
}