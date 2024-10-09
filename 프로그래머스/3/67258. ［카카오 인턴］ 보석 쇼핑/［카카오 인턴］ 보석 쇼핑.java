import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(List.of(gems));
        Map<String, Integer> jewel = new HashMap<>();
        int start, end;
        start = end = 0;
        int[] answer = new int[2];
        int ans_len = gems.length+1;
        while(start != gems.length){
            if(set.size() == jewel.size()){
                if(ans_len > end-start){
                    ans_len = end - start;
                    answer[0] = start;
                    answer[1] = end-1;
                }
                else if(ans_len == (end - start) && answer[0] > start){
                    answer[0] = start;
                    answer[1] = end-1;
                }
                if(jewel.get(gems[start]) == 1) jewel.remove(gems[start]);
                else{
                    jewel.put(gems[start], jewel.get(gems[start]) - 1);
                }
                start++;
            }
            else{
                if(end < gems.length){
                    jewel.put(gems[end], jewel.getOrDefault(gems[end], 0) + 1);
                    end++;
                }
                else{
                    break;
                }
            }
            //System.out.println(start + ", " + end + ", " + jewel.size());
        }
        //System.out.println(answer[0]+1 + ", " + (answer[1]+1) );
        answer[0]++;
        answer[1]++;
        return answer;
    }
}