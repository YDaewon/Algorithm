import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] nums = new int [n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int [] sums = new int[n+1];
            for (int i = 1; i <= n; i++) sums[i] = sums[i-1] + nums[i-1];

            int [][] dp = new int [n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    dp[i][j] = i == j ? 0 : 100000000;

            for (int len = 1; len <= n; len++) {
                for (int left = 0; left <= n-len; left++) {
                    int right = left + len - 1;
                    for (int mid = left; mid < right; mid++) {
                        dp[left][right] = Math.min(dp[left][mid] + dp[mid+1][right] + (sums[right + 1] - sums[left]), dp[left][right]);
                    }
                }
            }

            System.out.println(dp[0][n-1]);
        }

    }
}