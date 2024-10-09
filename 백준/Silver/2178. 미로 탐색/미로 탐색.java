import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] board = new int[101][101];
    static int[][] visit = new int[101][101];
    static int n, m;
    static int[] headY = {-1, 1, 0, 0};
    static int[] headX = {0, 0, -1, 1};

    public static int bfs(int startY, int startX) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});
        visit[startY][startX] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int ty = current[0];
            int tx = current[1];

            for (int i = 0; i < 4; i++) {
                int py = ty + headY[i];
                int px = tx + headX[i];

                if (py < 1 || py > n || px < 1 || px > m) continue;
                if (board[py][px] == 1 && visit[py][px] == 0) {
                    visit[py][px] = visit[ty][tx] + 1;
                    q.add(new int[]{py, px});
                }
            }
        }

        return visit[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();  // Consume newline

        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs(1, 1));
    }
}