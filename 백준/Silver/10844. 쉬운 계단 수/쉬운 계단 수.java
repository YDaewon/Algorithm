 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int [101][10];
        int mod = 1_000_000_000;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < 101; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) dp[i][j] = dp[i-1][j+1] % mod;
                else if(j == 9) dp[i][j] = dp[i-1][j-1] % mod;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i];
            ans %= mod;
        }
        System.out.println(ans);
    }

}
