import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 12865 평범한 배낭
 * 메모리 : 51364KB
 * 시간 : 160ms
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // dp 배열과 물건의 무게와 가치를 저장할 배열 선언
        int[][] dp = new int[n + 1][k + 1];
        int[][] items = new int[2][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            items[0][i] = Integer.parseInt(st.nextToken());
            items[1][i] = Integer.parseInt(st.nextToken());
        }

        // 각 무게마다
        for (int j = 1; j <= k; j++) {
            // 각 물건의 무게를 본다.
            for (int i = 1; i <= n; i++) {
                // 각 무게에서 보다 물건의 무게가 더 크면
                if (j < items[0][i]) {
                    // 이전 물건의 결과를 가져온다.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // j보다 물건의 무게가 작거나 같으면
                    // 이전의 무게의 가치와 이전 무게 - items[i].x의 가치와 items[i].y의 가치의 합 중 최대치를 고른다.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[0][i]] + items[1][i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
