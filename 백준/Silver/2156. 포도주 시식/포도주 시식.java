import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] wine = new int [n];
        int [] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1) {
            System.out.println(wine[0]);
            return;
        } else if(n== 2){
            System.out.println(wine[0] + wine[1]);
            return;
        }
        dp[0] = 0;
        dp[1] = wine[0];
        dp[2] = dp[1] + wine[1];
        //System.out.println("dp[1] = "+dp[1]);
        //System.out.println("dp[2] = "+dp[2]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + wine[i-1]);
            dp[i] = Math.max(dp[i], dp[i-3] + wine[i-2] + wine[i-1]);
            //System.out.println("dp["+i+"] = "+dp[i]);
        }
        System.out.println(dp[n]);

    }
}