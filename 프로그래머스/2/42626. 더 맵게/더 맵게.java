import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s); 
        }
        while(true){
            if(pq.peek() >= K) return cnt;

            if(pq.size() < 2) return -1;
            int first = pq.poll();
            int second = pq.poll();

            pq.offer(first + (second*2));
            cnt++;
            //System.out.println(pq.peek());
        }
    }
}