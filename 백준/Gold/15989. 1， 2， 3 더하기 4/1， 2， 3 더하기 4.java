import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] dp = new int [10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            System.out.println(dp[c][1]+dp[c][2]+dp[c][3]);
        }
    }
}


/*
1: 1
2: 1+1, 2
3: 1+1+1, 2 + 1, 1 + 2, 3



 */