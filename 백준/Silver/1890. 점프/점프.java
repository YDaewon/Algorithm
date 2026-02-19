 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int cnt = 0;
    static int [][] map;
    static long [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int [n][n];
        dp = new long [n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;

        int [] dy = {1, 0};
        int [] dx = {0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j] == 0) continue;
                if(map[i][j] == 0) break;
                for (int x = 0; x < 2; x++) {
                    int ny = i + (dy[x] * map[i][j]);
                    int nx = j + (dx[x] * map[i][j]);

                    if(ny >= n || nx >= n) continue;
                    // if(ny == n-1 && nx == n-1) System.out.println("i: " + i + ", j: " + j);
                    dp[ny][nx] += dp[i][j];
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[n-1][n-1]);
    }


}
