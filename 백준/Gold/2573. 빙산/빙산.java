 import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int n, m;

    static int [][] arr;
    static int [][] nxt;
    static boolean [][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int [n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        int time = -1;
        while(cnt != 0 &&cnt < 2){
            cnt = is_divide();
            // pnt();
            time++;
        }

        System.out.println(cnt != 0 ? time : 0);
    }

    static void bfs(int y, int x) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] { y, x});
        visit[y][x] = true;
        
        while(!q.isEmpty()){
            int [] cur = q.poll();

            nxt[cur[0]][cur[1]] = Math.max(arr[cur[0]][cur[1]] - count_zero(cur[0], cur[1]), 0);

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(!visit[ny][nx] && arr[ny][nx] != 0){
                    visit[ny][nx] = true;
                    q.add(new int [] {ny, nx});
                }
            }
        }
    }

    static void pnt(){
        System.out.println("=======================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }    
    }

    static int is_divide(){
        visit = new boolean[n][m];
        nxt = new int [n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && arr[i][j] != 0){
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        arr = nxt;
        return cnt;
    }

    static int count_zero(int y, int x){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(arr[ny][nx] == 0) cnt++;
        }
        return cnt;
    }
}
