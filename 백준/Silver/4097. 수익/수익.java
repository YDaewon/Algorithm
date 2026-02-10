import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int [] num = new int[n];
            int [] dp = new int [n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }
            dp[0] = num[0];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i-1] + num[i], num[i]);
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
}
