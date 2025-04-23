import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int [] one = {1,2,3,4,5};
        int [] two = {2,1,2,3,2,4,2,5};
        int [] three = {3,3,1,1,2,2,4,4,5,5};
        
        int one_cnt = 0;
        int two_cnt = 0;
        int three_cnt = 0;
        
        int max = 0;
        
        for(int i = 0; i < answers.length; i++){
            int a = answers[i];
            if(a == one[i%5]) one_cnt++;
            if(a == two[i%8]) two_cnt++;
            if(a == three[i%10]) three_cnt++;
            
            max = Math.max(one_cnt, Math.max(two_cnt, three_cnt));
        }
        
        if(max == one_cnt) answer.add(1);
        if(max == two_cnt) answer.add(2);
        if(max == three_cnt) answer.add(3);
        
        
        return answer;
    }
}
