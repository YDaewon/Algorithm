 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static int [][] board;
    static int [][] visit;

    static int [] dy = {0,-1,0,1};
    static int [] dx = {-1,0,1,0};

    static int room_cnt = 1;
    static int max_room_size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int [n][m];
        visit = new int [n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> size = new ArrayList<>();
        size.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j] == 0){
                    int sz = bfs(i,j);
                    size.add(sz);
                    max_room_size = Math.max(max_room_size, sz);
                    room_cnt++;
                }
            }
        }
        // System.out.println("-----------------------------------");
        // for (int y = 0; y < n; y++) {
        //     for (int x = 0; x < m; x++) {
        //         System.out.print(visit[y][x] + " ");
        //     }
        //     System.out.println();
        // }

        int real_max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = visit[i][j];
                
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                    if(visit[ny][nx] != num){
                        real_max = Math.max(real_max, size.get(visit[ny][nx]) + size.get(num));
                    }
                }
            }
        }

        System.out.println(room_cnt-1);
        System.out.println(max_room_size);
        System.out.println(real_max);
    }

    static int bfs(int y, int x){
        Queue<int []> q = new LinkedList<>();

        q.add(new int [] { y, x});
        visit[y][x] = room_cnt;
        int cnt = 0;
        while(!q.isEmpty()){
            int [] c = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int ny = c[0] + dy[i];
                int nx = c[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(visit[ny][nx] == 0 && (board[c[0]][c[1]] & (1 << i)) == 0){
                    q.add(new int [] {ny, nx});
                    visit[ny][nx] = room_cnt;
                }
            }
        }

        return cnt;
    }
}
