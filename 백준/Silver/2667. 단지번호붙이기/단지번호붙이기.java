import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[][] board;
    static int[][] visit;
    static ArrayList<Integer> cnt;
    static int n;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        board = new int[n][n];
        visit = new int[n][n];
        cnt = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String t = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = t.charAt(j) - '0';
            }
        }
        
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0 && board[i][j] != 0) {
                    dfs(i, j, num);
                    num++;
                }
            }
        }
        
        System.out.println(cnt.size());
        Collections.sort(cnt);
        for (int c : cnt) {
            System.out.println(c);
        }
    }
    
    public static void dfs(int i, int j, int num) {
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{i, j});
        visit[i][j] = 1;
        board[i][j] = num;
        int count = 1;
        while (!s.isEmpty()) {
            int[] pos = s.pop();
            int y = pos[0];
            int x = pos[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (visit[ny][nx] == 0 && board[ny][nx] != 0) {
                    visit[ny][nx] = 1;
                    s.push(new int[]{ny, nx});
                    board[ny][nx] = num;
                    count++;
                }
            }
        }
        cnt.add(count);
    }

}
