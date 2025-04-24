import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> progres = new LinkedList<>();
        int nowW = 0;
        for(int i = 0; i < truck_weights.length; i++){
            while(true){
                if(progres.isEmpty()){
                    progres.add(truck_weights[i]);
                    nowW+=truck_weights[i];
                    answer+=1;
                    break;
                }
                
                if(progres.size() == bridge_length){
                    nowW -= progres.poll();
                }
                else{
                    if(nowW + truck_weights[i] <= weight){
                        progres.add(truck_weights[i]);
                        nowW+=truck_weights[i];
                        answer+=1;
                        break;
                    }
                    else{
                        progres.add(0);
                        answer+=1;
                    }
                }
            }
        }
        
        
        return answer + bridge_length;
    }
}