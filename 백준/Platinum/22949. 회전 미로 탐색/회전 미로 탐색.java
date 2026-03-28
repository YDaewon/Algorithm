 import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static char [][][] board;

    static int [] dy = {-1,1,0,0, 0};
    static int [] dx = {0,0,-1,1, 0};

    static int [] s = new int [2];

    static boolean [][][] visit;

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        board = new char[4][4 * k + 1][4 * k + 1];
        visit = new boolean[4][4 * k + 1][ 4 * k + 1];
        int len = 4 * k;
        for (int i = 1; i <= len; i++) {
            char [] t = br.readLine().toCharArray();
            for (int j = 1; j <= len; j++) {
                board[0][i][j] = t[j-1];
                if(board[0][i][j] == 'S'){
                    s[0] = i;
                    s[1] = j;
                }
            }
        }

        for (int d = 0; d < 3; d++) {
            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= len; j++) {
                    int[] next = get_rotated_pos(i, j);
                    board[d + 1][next[0]][next[1]] = board[d][i][j];
                }
            }
        }

        System.out.println(solve());
    }

static int solve() {
        Queue<int[]> q = new LinkedList<>();
           
        // y, x, 시간, 현재 구역의 회전 상태
        q.add(new int[]{s[0], s[1], 0, 0});
        visit[0][s[0]][s[1]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int dist = curr[2];
            int d = curr[3];

            if (board[d][y][x] == 'E') return dist;

            int curSec = get_sector(y, x);

            for (int i = 0; i < 5; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                int nextSec = get_sector(ny, nx);
                if(nextSec == -1) continue;

                int nd = (curSec == nextSec) ? (d + 1) % 4 : 1;   
                int[] np = get_rotated_pos(ny, nx);
                
                if (visit[nd][np[0]][np[1]] || board[nd][np[0]][np[1]] == '#') continue;

                visit[nd][np[0]][np[1]] = true;
                q.add(new int[]{np[0], np[1], dist + 1, nd});
            }
        }
        return -1;
    }
    
    static int get_sector(int y, int x) {
        if (y <= 0 || y > 4 * k || x <= 0 || x > 4 * k) return -1;
        return ((y - 1) / 4) * k + ((x - 1) / 4);
    }


    static int[] get_rotated_pos(int y, int x) {
        int zero_r = ((y - 1) / 4) * 4 + 1;
        int zero_c = ((x - 1) / 4) * 4 + 1;
        int r = y - zero_r;
        int c = x - zero_c;
        
        return new int[]{zero_r + c, zero_c + 3 - r};
    }
}
