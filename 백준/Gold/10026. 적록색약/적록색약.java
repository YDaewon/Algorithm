import java.util.*;

public class Main {
    static int n, ans1, ans2;
    static int[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][][] greed = new int[100][100][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String t = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (t.charAt(j) == 'B') {
                    greed[i][j][0] = 3;
                    greed[i][j][1] = 3;
                } else if (t.charAt(j) == 'R') {
                    greed[i][j][0] = 2;
                    greed[i][j][1] = 1;
                } else {
                    greed[i][j][0] = 1;
                    greed[i][j][1] = 1;
                }
            }
        }
        visit = new int[100][100];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0) {
                    dfs(i, j, 1);
                    //System.out.println("[1]. " + i + ", " + j);
                    ans1++;
                }
            }
        }

        visit = new int[100][100];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0) {
                    dfs(i, j, 2);
                    //System.out.println("[2]. " + i + ", " + j);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    static void dfs(int y, int x, int v) {
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{y, x});
        visit[y][x] = 1;

        int sec = (v == 1) ? greed[y][x][0] : greed[y][x][1];

        while (!s.isEmpty()) {
            int[] temp = s.pop();
            int ty = temp[0];
            int tx = temp[1];

            for (int i = 0; i < 4; i++) {
                int ny = ty + dy[i];
                int nx = tx + dx[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (v == 1 && visit[ny][nx] == 0 && greed[ny][nx][0] == sec) {
                    s.push(new int[]{ny, nx});
                    visit[ny][nx] = 1;
                } 
                else if (v == 2 && visit[ny][nx] == 0 && greed[ny][nx][1] == sec) {
                    s.push(new int[]{ny, nx});
                    visit[ny][nx] = 1;
                }
            }
        }
    }
}
