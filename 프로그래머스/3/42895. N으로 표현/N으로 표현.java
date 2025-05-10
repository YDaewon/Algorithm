import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // Init
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i< 9; i++){
            dp.add(new HashSet<Integer>());
        }
        dp.get(1).add(N);
        if(number == N) return 1;
        // sol
        for(int i = 2; i < 9; i++){
            Set<Integer> cur = dp.get(i);
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < i; j++) sb.append(N);
            cur.add(Integer.parseInt(sb.toString()));
            
            for(int j = 1; j < i; j++){
                int t = i - j;
                Set<Integer> x = dp.get(j);
                Set<Integer> y = dp.get(t);
                for(int a : x){
                    for(int b: y){
                        cur.add(a + b); // +
                        cur.add(a-b); // -
                        cur.add(a*b); // *
                        if(b != 0) cur.add(a/b);
                    }
                }
            }
            
            if(cur.contains(number)) return i;
        }
        
        return -1;
    }
}

// N을 1번: N
// N을 2번: N 1번에 N1번 연산
// N 3번: N 2번에 N 1번, N 1번에 N 2번
// ...