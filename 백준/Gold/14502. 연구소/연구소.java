import java.util.*;
import java.io.*;


public class Main {
    static int d; // 0 : up, 1: right, 2: down, 3: left
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};

    static int n;
    static int m;
    static int answer = Integer.MIN_VALUE;
    static int [][] map;
    static int [][] mmap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        mmap = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0);
        System.out.println(answer);

    }

    static void combination(int d){
        if(d == 3){
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    combination(d + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        int cnt = 0;
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mmap[i][j] = map[i][j];
                if(mmap[i][j] == 2){
                    q.add(new int [] {i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(mmap[ny][nx] == 0){
                    q.add(new int [] { ny, nx});
                    mmap[ny][nx] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mmap[i][j] == 0) cnt++;
            }
        }

        answer = Math.max(cnt, answer);
    }

}