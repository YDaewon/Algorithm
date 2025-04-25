import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -100;
                    reserve[j] = -100;
                    answer++;
                    break;
                }
            }
        }
        

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1){
                    answer++;
                    reserve[j] = -100;
                    break;
                }
            }
        }
        return answer;
    }
}