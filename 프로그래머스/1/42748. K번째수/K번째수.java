import java.util.*;

class Solution {
    public List<Integer>  solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int [] cmd : commands){
            int start = cmd[0];
            int end = cmd[1];
            int k = cmd[2];
            
            List<Integer> temp = new ArrayList<>();
            for(int i = start -1; i < end; i++){
                temp.add(array[i]);
            }
            Collections.sort(temp);
            answer.add(temp.get(k-1));
        }
        return answer;
    }
}