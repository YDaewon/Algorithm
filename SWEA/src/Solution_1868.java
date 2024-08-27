import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1868 {
    static int [] dy = {-1,1,0,0,-1,-1,1,1};
    static int [] dx = {0,0,-1,1,-1,1,-1,1};
    static int r,c, cnt;
    static int [][] board, visit;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            init();
            sol();
            System.out.println("#"+i+" " + cnt);
        }
    }

    static void init(){
        r = c = sc.nextInt();
        sc.nextLine();
        board = new int[r][c];
        visit = new int[r][c];
        cnt = r * c;
        for(int i = 0; i < r; i++){
            String t = sc.nextLine();
            for(int j = 0; j < c; j++){
                if(t.charAt(j) == '*') board[i][j] = -1;
                else board[i][j] = 0;

            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == 0) minecraft(i,j);
                else cnt--;
            }
        }
    }

    static void minecraft(int y, int x){
        for (int k = 0; k < 8; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
            if(board[ny][nx] == -1) board[y][x]++;
        }
    }

    static void sol(){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(visit[i][j] == 0 && board[i][j] == 0){
                    bfs(i,j);
                }
            }
        }
    }

    static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        visit[i][j] = 1;
        while(!q.isEmpty()){
            int [] t = q.poll();
            int y =t[0];
            int x = t[1];
            for (int k = 0; k < 8; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if(visit[ny][nx] == 0 && board[ny][nx] == 0){
                    q.add(new int[]{ny,nx});
                    visit[ny][nx] = 1;
                    cnt--;
                }
                else if(visit[ny][nx] == 0 && board[ny][nx] > 0){
                    visit[ny][nx] = 1;
                    cnt--;
                }
            }
        }
    }
}
