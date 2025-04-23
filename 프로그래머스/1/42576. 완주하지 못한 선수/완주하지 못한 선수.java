import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> clear = new HashMap<>();
        
        for(String str : participant){
            clear.merge(str, 1, Integer::sum);
        }
        
        for(String str : completion){
            clear.merge(str, -1, Integer::sum);
            if(clear.get(str) == 0){
                clear.remove(str);
            }
        }
        
        
        return clear.keySet().iterator().next();
    }
}