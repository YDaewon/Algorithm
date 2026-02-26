 import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1,-1,1,1};
    static int [] dx = {-1, 1, -1, 1};

    static int n;
    static int [] ans = {0,0};
    static int [][] board;
    static boolean [] left_down = new boolean [20];
    static boolean [] right_down = new boolean [20];
    /*
    left_down(0,0), {(0,1), (1, 0)}, {(0,2), (1,1), (2,0)} => 합이 같음(0, 1, 2, ...) 0 ~ 19
    right_down{(0,0), (1,1), (2,2), ...}, {(0,1), (1, 2)} => x - y가 같음(0, 1, 2, ...) -9 ~ 9
    */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int [n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        n_bishop(0, 0, 0, 0);
        n_bishop(0, 1, 0, 1);

        System.out.println(ans[0] + ans[1]);
    }

    static void n_bishop(int y, int x, int cnt, int color){
        if(x >= n) {
            y += 1;
            x = (y % 2 == color % 2) ? 0 : 1;
        }

        if(y >= n){
            ans[color] = Math.max(ans[color], cnt);
            return;
        }
        // System.out.println("y: " + y + ", x: " + x);

        if(board[y][x] == 1 && !left_down[y+x] && !right_down[x - y + (n-1)]){
            //set_board(y,x, -1);
            left_down[y+x] = true;
            right_down[x - y + (n-1)] = true;
            n_bishop(y, x + 2, cnt + 1, color);
            right_down[x - y + (n-1)] = false;
            left_down[y+x] = false;
            //set_board(y,x, 1);
        }
        n_bishop(y, x + 2, cnt, color);
    }


    // static void set_board(int y, int x, int num){
    //     board[y][x] = num;
    //     for (int i = 0; i < 4; i++) {
    //         int ny = y + dy[i];
    //         int nx = x + dx[i];
    //         while(ny >= 0 && ny < n && nx >= 0 && nx < n){
    //             if(board[ny][nx] != 0) board[ny][nx] = num;
    //             ny += dy[i];
    //             nx += dx[i];
    //         }
    //     }
    // }

}
