import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [][] map;
    static int [][] cnt;

    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        cnt = new int [n][m];
        int y = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    y = i;
                    x = j;
                }
            }
        }

        bfs(y, x);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(cnt[i][j] == Integer.MAX_VALUE){
                    if(map[i][j] == 0) sb.append(0);
                    else sb.append(-1);
                }
                else sb.append(cnt[i][j]);

                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs(int y, int x) {
        Queue<int []> q = new LinkedList<>();
        cnt[y][x] = 0;
        q.add(new int [] {y, x, cnt[y][x]});

        while(!q.isEmpty()){
            int [] c = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = c[0] + dy[i];
                int nx = c[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(map[ny][nx] == 1 && cnt[ny][nx] > c[2] + 1){
                    cnt[ny][nx] = c[2] + 1;
                    q.add(new int [] {ny,nx, c[2] + 1});
                }
            }
        }
    }

}
