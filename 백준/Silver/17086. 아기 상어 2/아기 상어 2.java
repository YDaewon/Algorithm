 import java.io.*;
import java.util.*;

public class Main {
    static int n , m;
    static int [][] board;
    static int [][] cnt;

    static int [] dy = {-1,1,0,0,-1,-1,1,1};
    static int [] dx = {0,0,-1,1,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        cnt = new int[n][m];
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) {
                    q.add(new int [] {i,j, 0});
                    cnt[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int [] cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                int cost = cur[2] + 1;
                if(y >= n || y < 0 || x >= m || x < 0) continue;

                if(cnt[y][x] > cost){
                    cnt[y][x] = cost;
                    q.add(new int [] {y,x, cost});
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, cnt[i][j]);
            }
        }

        System.out.println(answer);
    } 
}
