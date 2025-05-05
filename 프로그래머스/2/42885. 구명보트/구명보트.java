import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int n = people.length;
        int j = 0;
        for(int i = n-1; i >= j; i--){
            if(people[j] + people[i] <= limit) j++;
            answer++;
        }
        return answer;
    }
}