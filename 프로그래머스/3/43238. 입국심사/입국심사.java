import java.util.*;

class Solution {
    // 시간을 이분 탐색
    public long solution(int n, int[] times) {
        Arrays.sort(times);  
        long answer = 0;
        long left = 0;
        long right = (long) times[times.length-1] * (long)n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long people = counting_people(mid, times);
            if(people < n){
                left = mid + 1;
            }
            else{
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
    
    long counting_people(long time, int [] times){
        long people = 0;
        for(int i : times){
            people += time / i;
        }
        return people;
    }
    
}