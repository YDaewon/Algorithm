import java.util.*; 

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for(String operation : operations){
            char cmd = operation.charAt(0);
            int num = Integer.parseInt(operation.substring(2));
            
            switch(cmd){
                case 'I':
                    max.add(num);
                    min.add(num);
                    break;
                case 'D':
                    if(num < 0){ // 삭제 : 최솟값
                        if(!min.isEmpty()){
                            int temp = min.poll();
                            if(!max.isEmpty()){
                                max.remove(temp);
                            }
                        }
                    } else{  // 삭제 : 최댓값
                        if(!max.isEmpty()){
                            int temp = max.poll();
                            if(!min.isEmpty()){
                                min.remove(temp);
                            }
                        }
                    }
                    break;
            } 
        }
        if(max.isEmpty() && min.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }
}