import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int [] need = new int [speeds.length];
        int cnt = 1;
        int max = need_time(progresses[0], speeds[0]);
        for(int i = 1 ; i < progresses.length; i++){
            if(max >= need_time(progresses[i], speeds[i])){
                cnt++;
            } else{
                answer.add(cnt);
                cnt = 1;
                max = need_time(progresses[i], speeds[i]);
            }
        }
        answer.add(cnt);
        return answer;
    }
    
    int need_time(int progress, int speed){
        int need = 100 - progress;
        return need / speed + (need % speed != 0 ? 1 : 0);
    }
}