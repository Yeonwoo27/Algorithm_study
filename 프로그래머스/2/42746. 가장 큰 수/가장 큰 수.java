import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        StringBuilder answer  = new StringBuilder();
        String[] array = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            array[i] =String.valueOf(numbers[i]);
        }
        
        Arrays.sort(array,new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        
         if(array[0].equals("0")) return "0";
        for(String s : array) answer.append(s);
        return answer.toString();
    }
}