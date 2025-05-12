import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long start = 0;
        long end = (long)times[times.length-1] * (long)n;
        
        while(start <= end){
            long mid = (start + end) / 2;
            long people = calc(mid, times);
            System.out.println("now: " + mid + ", person: " + people);
            if(people < n){
                start = mid + 1;
            }
            else{
                end = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
    
    long calc(long now, int [] times){
        long cnt = 0;
        for(int t : times){
            cnt += now / t;
        }
        return cnt;
    }
}