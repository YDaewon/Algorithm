import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> maps = new HashMap<>();
        
        for(String [] strs : clothes){
            maps.put(strs[1], maps.getOrDefault(strs[1], 0) + 1);
        }
        for(Integer i : maps.values()){
            //System.out.print(i + " ");
            answer *= i+1;
        }
        
        return answer-1;
    }
}