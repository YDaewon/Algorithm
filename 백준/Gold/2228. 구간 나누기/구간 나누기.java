 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static int [] arr;
    static int [] sum;
    static int [][] dp;
    /*
    0~1까지 최대 + d
    5, 2에
    1 2 -3 4 5이면
    => [1 2] [4, 5]
    

    i+1을 지금 구간에 포함하냐 vs i + 2부터 다음 구간으로 할거냐

    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        sum = new int [n+1];
        dp = new int [n+1][m+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i-1] + arr[i];
        }

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1000000);
            dp[i][0] = 0;
        }
        
        for(int d = 1; d <= m; d++){
            for(int idx = 1; idx <= n; idx++){

                dp[idx][d] = dp[idx-1][d]; // 지금꺼 포함 x

                for (int s = 1; s <= idx; s++) { // 지금 번호 i를 포함하는 구간 중에 start를 앞으로 한칸씩 당기면서 가장 큰걸 구한다
                    if (s == 1) {
                        if (d == 1) dp[idx][d] = Math.max(dp[idx][d], getsum(s, idx));
                    } else {
                        if (dp[s - 2][d - 1] != -1000000) {
                            dp[idx][d] = Math.max(dp[idx][d], dp[s - 2][d - 1] + getsum(s, idx));
                        }
                    }
                }
            }
        }

        System.out.println(dp[n][m]);

    }

    static int getsum(int a, int b){ // a ~ b
        return sum[b] - sum[a-1];
    }
}
