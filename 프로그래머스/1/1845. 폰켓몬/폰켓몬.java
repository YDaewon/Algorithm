import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        int size = nums.length / 2;
        for(int num : nums){
            maps.merge(num, 1, Integer::sum);
        }
        
        int values = maps.size();
        
        return size > values ? values : size;
        
    }
}