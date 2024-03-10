import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, Comparator.comparing(String::length));
        Map<String, Integer> hm = new HashMap<String, Integer>();
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book[i].length();j++){
                if(hm.get(phone_book[i].substring(0,j))!=null){
                    answer=false;
                }
            }
          hm.put(phone_book[i],1);
        }
        
        return answer;
    }
}