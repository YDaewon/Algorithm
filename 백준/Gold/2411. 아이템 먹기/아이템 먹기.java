 import java.io.*;
import java.util.*;

public class Main {
    static int n, m, a, b;
    static int [][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        board = new int [n + 1][m + 1];
        List<int []> items = new ArrayList<>();
        items.add(new int [] {1,1});
        items.add(new int [] {n,m});
        for (int i = 0; i < a + b; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(i < a) {
                board[y][x] = 1;
                items.add(new int [] {y,x});
            }
            else board[y][x] = -1;
        }

        Collections.sort(items, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });


        int [][] dp = new int [n + 1][m + 1];
        int ans = 1;
        for (int i = 1; i < items.size(); i++) {
            int [] s = items.get(i-1);
            int [] e = items.get(i);
            
            for (int y = s[0]; y <= e[0]; y++) {
                for (int x = s[1]; x <= e[1]; x++) {
                    if(board[y][x] == -1) continue;
                    if(y == s[0] && x == s[1]) dp[s[0]][s[1]] = 1;
                    else dp[y][x] = dp[y-1][x] + dp[y][x-1];
                }
            }
            ans *= dp[e[0]][e[1]];
        }

        // for (int y = 1; y <= n; y++) {
        //     for (int x = 1; x <= m; x++) {
        //         if(board[y][x] != -1) System.out.print(dp[y][x] + " ");
        //         else if(board[y][x] == -1) System.out.print("x ");
        //         else System.out.print("0 ");
        //     }
        //     System.out.println();
        // }
        
        System.out.println(ans);
    }

}
