import java.util.*;

class Solution {
    // n: 멘토
    // k: 상담 유형
    // k개의 숫자쌍을 만들어서 완탐?
    int answer = Integer.MAX_VALUE;
    int n = 0;
    int k = 0;
    int [] nums;
    int [][] reqs;
    public int solution(int k, int n, int[][] reqs) {
        this.n = n;
        this.k = k;
        nums = new int [k];
        this.reqs = reqs;
        
        permu(0, n);
        return answer;
    }
    
    private void permu(int d, int r){
        if(d >= k) {
            if(r > 0) return;
            // for(int i : nums)
            //     System.out.print(i + " ");
            // System.out.println();
            int result = calc();
            //System.out.println(", result: " + result);
            answer = Math.min(result, answer);
            return;
        }
        for(int i = 1; i <= r; i++){
            nums[d] = i;
            permu(d+1, r - i);
        }
    }
    
    private int calc(){
        int cnt = 0;
        List<PriorityQueue<Integer>> wait = new ArrayList<>();
        int [] mentor = new int [k];
        for(int i = 0; i < k ; i++) {
            wait.add(new PriorityQueue<>());
            mentor[i] = nums[i];
        }
        for(int [] p : reqs){
            int a = p[0];// 0: 신청 시각
            int b = p[1];// 1: 상담 시간
            int c = p[2] - 1;// 2: 유형
            
            while(!wait.get(c).isEmpty() && wait.get(c).peek() <= a){
                wait.get(c).poll();
                mentor[c]++;
            }
            
            if(mentor[c] > 0) {
                mentor[c]--;
                wait.get(c).add(a + b);
            } else{
                int t = wait.get(c).poll() - a;
                cnt += t;
               // System.out.println("신청시간: " + a + " 상담 대기: " + t);
                wait.get(c).add(t + a + b);
            }
        }
        return cnt;
    }
}