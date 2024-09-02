import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2468 {
    static int [][] board;
    static boolean [][] visit;
    static int n;
    static int ans, max;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        max = 0;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                max = Math.max(board[i][j], max);
            }
        }

        for (int i = 0; i <= max; i++) rain(i);
        System.out.println(ans);

    }

    static void rain(int r){
        visit = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] > r && !visit[i][j]) {
                    bfs(i, j, r);
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    static void bfs(int y, int x, int r){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {y,x});
        visit[y][x] = true;
        while(!q.isEmpty()){
            int [] p = q.poll();
            int py = p[0];
            int px = p[1];
            for (int i = 0; i < 4; i++) {
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                if(!visit[ny][nx] && board[ny][nx] > r) {
                    visit[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }

}
