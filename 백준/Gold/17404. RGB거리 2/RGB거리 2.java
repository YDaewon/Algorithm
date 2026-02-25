 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [][] rgb;
    static int [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        rgb = new int [n][3];
        dp = new int [n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];


        // 첫번째 집과 두번째집, 마지막집을 지정하고 시작해야함
        // 0, 1, 2
        // 0, 2, 1
        // 1, 0, 2
        // 1, 2, 0
        // 2, 0, 1
        // 2, 1, 0

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < 3; c++) { 
            for(int i = 0; i < 3; i++){ // 첫번째 집(마지막집은 c와 n-2의 색과 달라야함)
                if(c != i) dp[0][i] = 10_000_000;
                else dp[0][i] = rgb[0][i];
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + rgb[i][2];
            }

            for(int i = 0; i < 3; i++){ // 마지막 집( != c)
                if(i != c) ans = Math.min(ans, dp[n-1][i]);
            }
        }

        System.out.println(ans);
    }

}
