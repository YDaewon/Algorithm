import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_12865 {
    static int [][] dp;
    static int n, k, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ans = 0;
        dp = new int[n+1][k+1];
        List<int []> arr = new ArrayList<>();
        arr.add(new int[]{0,0});
        for (int i = 1; i <= n; i++) { // 0 : weight,  1: value
            arr.add(new int [] {sc.nextInt(), sc.nextInt()});
        }
        for (int i = 1; i <= k; i++) {
            for(int j = 1; j <= n; j++){
                dp[j][i] = dp[j-1][i];
                if(i >= arr.get(j)[0]) dp[j][i] = Math.max(dp[j][i], dp[j-1][i-arr.get(j)[0]] + arr.get(j)[1]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
