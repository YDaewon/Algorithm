 import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        0 ~ 9 : 10개
        1x -> 9개, 2x -> 8개 ... 9x: 1개 = 9+8+7+6+...+1 = 45  0부터? => 55개
        0xx -> 55개 , 1xx: 45개, 2xx: 


        
        */
        int n = Integer.parseInt(br.readLine());
        int [][] dp = new int [n+1][10];

        Arrays.fill(dp[1], 1);

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                for(int k = j; k < 10; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp[n][i];
            sum %= 10007;
        }
        System.out.println(sum);
    }


}
