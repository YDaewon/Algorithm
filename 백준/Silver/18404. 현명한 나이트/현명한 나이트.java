import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] dy = {-2, -2, -1, -1, 1, 1, 2 ,2};
    static int [] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        int [][] board = new int[n][n];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken()) - 1;
            int py = Integer.parseInt(st.nextToken()) - 1;
            board[py][px] = i;
        }
        int [] ans = new int [m+1];
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {y, x, 0});
        boolean [][] visit = new boolean[n][n];
        visit[y][x] = true;
        while(!q.isEmpty()){
            int [] c = q.poll();

            if(board[c[0]][c[1]] != 0){
                ans[board[c[0]][c[1]]] = c[2];
            }

            for (int i = 0; i < 8; i++) {
                int ny = c[0] + dy[i];
                int nx = c[1] + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

                if(!visit[ny][nx]){
                    visit[ny][nx] = true;
                    q.add(new int [] {ny, nx, c[2] + 1});
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}
