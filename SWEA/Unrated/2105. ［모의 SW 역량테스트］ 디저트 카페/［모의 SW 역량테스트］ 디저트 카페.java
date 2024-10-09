import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int [] dy = {-1,1,1,-1};
    static int [] dx = {1,1,-1,-1};
    static int [][] board;
    static boolean [] num;
    static boolean [][] visit;
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
             init();
             for(int i = 1; i < n-1; i++){
                 for (int j = 0; j < n-2; j++) {
                     num = new boolean[101];
                     num[board[i][j]] = true;
                     sol(i, j, 0, 1, i, j);
                 }
             }
             System.out.println("#" + t + " " + ans);
        }
    }

    static void init(){
        n = sc.nextInt();
        ans = -1;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
    }

    static void sol(int sy, int sx, int d, int cnt, int y, int x){
        //System.out.println(cnt + ", " + y + ", " + x + ", " + d);
        for(int i = d; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
            if(ny == sy && nx == sx && cnt > 3){
               // System.out.println("flag: " + sy + ", " + sx);
                ans = Math.max(ans, cnt);
                return;
            }
            if(!num[board[ny][nx]]){
                num[board[ny][nx]] = true;
                sol(sy,sx,i,cnt+1, ny, nx);
                num[board[ny][nx]] = false;
            }
        }
    }
}
