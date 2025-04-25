import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int [][] dp = new int [n+1][n+1];

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            dp[i][i+1] = dp[i-1][i-1] + triangle[i][i];
        }
        
        for(int i : dp[n-1]){
            answer = Math.max(answer, i);
        }
        return answer;
    }
}