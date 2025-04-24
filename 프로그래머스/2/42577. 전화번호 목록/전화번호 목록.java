import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> maps = new HashMap<>();
        for(String str : phone_book){
            maps.put(str, 0);
        }
        
        for(String str : phone_book){
            for(int i = 0; i < str.length();i++){
                String temp = str.substring(0,i);
                if(maps.get(temp) != null){
                    return false;
                }
            }
        }
        
        return true;
    }
}