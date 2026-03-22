 import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int ans = -1;
    static int [][] board;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int [n][m];
        for(int i = 0; i < n; i++){
            String t = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = t.charAt(j) - '0';
            }
        }

        for (int dy = -n; dy <= n; dy++) {
            for(int dx = -m; dx <= m; dx++){
                if(dy == 0 && dx == 0) continue;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        go(0, dy,dx,i,j,0);
                    }
                }
            }
        }


        System.out.println(ans);
    }

    static void go(int d, int dy, int dx, int y, int x, int num){

        if(d >= 1 && isPow(num)){
            ans = Math.max(num, ans);
        }

        if(y < 0 || y >= n || x < 0 || x >= m) return;
        num *= 10;
        num += board[y][x];
        go(d + 1, dy, dx, y + dy, x + dx, num);
    }

    private static boolean isPow(int num) {
        int root = (int) Math.sqrt(num);
        return (root * root == num);
    }

}
