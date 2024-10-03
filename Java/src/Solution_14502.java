import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_14502 {
    static int [][] board;
    static boolean [][] visit;
    static int n, m;
    static int zero_cnt, ans;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int [n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 0) zero_cnt++;
            }
        }
        combination(0);
        System.out.println(ans);
    }

    static void combination(int d){
        if(d == 3){
            simulation();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    combination(d+1);
                    board[i][j] = 0;
                }
            }
        }
    }

    static void simulation(){
        int [][] copy = new int [n][m];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = board[i][j];
                if(copy[i][j] == 2) {
                    q.offer(new Point(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int y = p.y + dy[d];
                int x = p.x + dx[d];
                if(y <0 || y >= n || x < 0 || x >= m) continue;
                if(copy[y][x] == 0){
                    q.offer(new Point(y,x));
                    copy[y][x] = 2;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copy[i][j] == 0) cnt++;
            }
        }
        if(ans < cnt){
            /*for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(copy[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("===============================");
            */ans = cnt;
        }
    }


    static class Point{
        int y, x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
