import java.util.*;

class Solution {
    Set<Integer> numset = new HashSet<>();
    
    public int solution(String numbers) {
        String now = "";
        combination(numbers, now);
        int answer = 0;
        for(int i : numset){
            if(is_prime(i)) answer++;
        }
        
        return answer;
    }
    
    void combination(String nums, String now){
        if(!now.equals("")){
            numset.add(Integer.parseInt(now));
        }
        for(int i = 0; i < nums.length(); i++){
            combination(nums.substring(0,i) + nums.substring(i+1), now + nums.charAt(i));
        }
    }
    
    
    boolean is_prime(int num){
        
        if(num <= 1) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}