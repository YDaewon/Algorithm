 import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int [][] dp;

    /*
    dp[6][0] = 0;
    dp[6][1] = 1;
    dp[6][2] = dp[6][1] + dp[5][1] + ... + dp[0][1]
    dp[6][3] = dp[6][2] + dp[5][2] + ...  dp[0][2]
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int [n+1][k+1];

        for (int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }

    for (int j = 2; j <= k; j++) {
        for (int i = 0; i <= n; i++) {
            for (int l = 0; l <= i; l++) {
                dp[i][j] += dp[l][j-1];
                dp[i][j] %= 1000000000;
            }
        }
    }

        System.out.println(dp[n][k]);
    }   

}
