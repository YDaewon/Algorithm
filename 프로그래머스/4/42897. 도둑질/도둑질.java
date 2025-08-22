class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int [] dp_start = new int[len+1]; // 시작 집 고르기
        int [] dp_end = new int[len+1]; // 마지막 집 고르기
        
        dp_start[0] = 0;
        dp_start[1] = money[0];
        dp_start[2] = Math.max(dp_start[1], money[1]);
        
        dp_end[0] = 0;
        dp_end[1] = 0;
        dp_end[2] = money[1];
        
        for(int i = 3; i <= len; i++){
            dp_start[i] = Math.max((money[i-1] + dp_start[i-2]), dp_start[i-1]);
            dp_end[i] = Math.max((money[i-1] + dp_end[i-2]), dp_end[i-1]);
        }
        
        System.out.println(dp_start[len-1] + ", " + dp_end[len]);
        answer = Math.max(dp_start[len-1], dp_end[len]);
        return answer;
    }
}



// dp[0] = 0;
// dp[1] = money[0];
// dp[2] = MAX(money[0], money[1]);
// dp[3] = MAX(money[2] + dp[1], dp[2]);
// dp[4] = MAX(money[3] + dp[2], dp[3]);

// ㅁ_ㅁ_ㅁ_ㅁ_ㅁ
// ㅁ__ㅁ_ㅁ_ㅁ__ㅁ