import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_5650 {
    static Scanner sc = new Scanner(System.in);
    static int sy, sx;
    static int [] dy = {0,-1,0,1};// 좌, 상, 우, 하
    static int [] dx = {-1,0,1,0};
    static int [][] board;
    static int n, d, ans;
    static List<Point>[] wormhole;// pair, (y,x), 웜홀 번호

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            init();
            sol();
            System.out.println("#" + i + " " + ans);
        }
    }

    static void init(){
        ans = 0;
        n = sc.nextInt();
        board = new int [n][n];
        wormhole = new ArrayList[11];
        for (int i = 6; i <=10; i++) {
            wormhole[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                board[i][j] = val;
                if(val > 5){
                    wormhole[val].add(new Point(i,j));
                    //System.out.println(val + "번 웜홀 좌표 입력: " + i + ", " + j);
                    //System.out.println(wormhole[val].size());
                }
            }
        }
    }
    static void sol(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0){
                    sy = i; sx = j;
                    for (int k = 0; k < 4; k++) {
                        d = k;
                        go();
                    }
                }
            }
        }
    }

    static void go(){
        int y = sy;
        int x = sx;
        int cnt = 0;
        while(true){
            y += dy[d];
            x += dx[d];
            if(y < 0 || y >= n || x <0 || x >= n){
                d = (d+2)%4;
                y+=dy[d];
                x+=dx[d];
                cnt++;
            }
            if(board[y][x] < 6 && board[y][x] > 0){
                turn(board[y][x]);
                cnt++;
            }
            if(board[y][x] >= 6){
                int idx = board[y][x];
                for (int i = 0; i < 2; i++) {
                    //System.out.println(wormhole[board[y][x]].size());
                    if(wormhole[idx].get(i).y == y && wormhole[idx].get(i).x == x){
                        y = wormhole[idx].get((i+1)%2).y;
                        x = wormhole[idx].get((i+1)%2).x;
                        break;
                    }
                }
            }
            if(y == sy && x == sx) break;
            if(board[y][x] == -1) break;
        }
        ans = Math.max(ans, cnt);
    }


    static void turn(int block_num){
        // 좌, 상, 우, 하
        if(d == 0 && block_num == 1) d = 1;
        else if(d == 0 && block_num == 2) d = 3;
        else if(d == 1 && block_num == 2) d = 2;
        else if(d == 1 && block_num == 3) d = 0;
        else if(d == 2 && block_num == 3) d = 3;
        else if(d == 2 && block_num == 4) d = 1;
        else if(d == 3 && block_num == 4) d = 0;
        else if(d == 3 && block_num == 1) d = 2;
        else d = (d+2)%4;
    }

    static class Point{
        int y, x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
