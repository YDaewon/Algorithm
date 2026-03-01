 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] v;
    static int [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new int [n+1];
        dp = new int [n+1][n+1]; // [왼쪽 수확][오른쪽 수확]
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }
        dp[1][1] = v[1];
        dp[n][n] = v[n];

        for(int time = 1; time <= n; time++){
            for (int l = 0; l <= time; l++) { // 왼쪽 수확 개수
                int r = time - l; // 오른쪽 수확 개수

                if(l > 0) dp[l][r] = Math.max(dp[l][r], dp[l - 1][r] + v[l] * time);
                if(r > 0) dp[l][r] = Math.max(dp[l][r], dp[l][r-1] + v[n - r + 1] * time);
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(dp[i][n-i], ans);
        }
        
        System.out.println(ans);
        
    }


}
