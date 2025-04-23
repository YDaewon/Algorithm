import java.util.*;

public class Solution {
    public Queue<Integer> solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        int temp = -1;
        for(int num : arr){
            if(q == null || temp != num) {
                q.offer(num);
                temp = num;
            }
            else  continue;
        }
        
        return q;
    }
}