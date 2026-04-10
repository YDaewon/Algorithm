import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [][] map;
    static int [][][] visit;

    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        visit = new int [2][n][m];
        for (int i = 0; i < n; i++) {
            String t = br.readLine();
            for (int j = 0; j < t.length(); j++) {
                map[i][j] = t.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {0,0,0});
        visit[0][0][0] = 1;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int wall = cur[0];
            int y = cur[1];
            int x = cur[2];

            if(y == n -1 && x == m-1){
                return visit[wall][y][x];
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(map[ny][nx] == 1 && wall == 0){
                    q.add(new int [] {wall + 1, ny, nx});
                    visit[wall + 1][ny][nx] = visit[wall][y][x] + 1;
                }
                else if(map[ny][nx] == 0 && visit[wall][ny][nx] == 0){
                    q.add(new int [] {wall, ny, nx});
                    visit[wall][ny][nx] = visit[wall][y][x] + 1;
                }
            }
        }

        return -1;
    }
}
