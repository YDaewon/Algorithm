import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for(int t = 0; t <= 10000; t++){
            int c = 0;
            int nc = 0;
            for(int i = 0; i < n; i++){
                if(citations[i] >= t) c++;
                if(citations[i] <= t) nc++;
            }
            if(c >= t && nc <= t) answer = t;
        }
        return answer;
    }
}