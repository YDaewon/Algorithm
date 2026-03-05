 import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int n, m, max = 2;
    static int [][] map;
    static boolean [][] visit;
    static List<Pos> pos = new ArrayList<>();

    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] == 2){
                    find_group(i, j, true);
                }
            }
        }

        max = Math.min(pos.size(), max);
        go(0, 0);
        System.out.println(ans);
    }   


    static int find_group(int y, int x, boolean flag){
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {y, x});
        visit[y][x] = true;

        int cnt = 1;
        int count_black = 0;
        while(!q.isEmpty()){
            int [] c = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = c[0] + dy[i];
                int nx = c[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(flag && !visit[ny][nx] && map[ny][nx] == 0){
                    visit[ny][nx] = true;
                    pos.add(new Pos(ny,nx));
                }
                
                if(!flag && map[ny][nx] == 0){
                    count_black++;
                }

                if(!visit[ny][nx] && map[ny][nx] == 2){
                    visit[ny][nx] = true;
                    q.add(new int [] {ny,nx});
                    cnt++;
                }
            }
        }

        return count_black == 0 ? cnt : 0;
    }

    static Pos [] select = new Pos[2];
    static void go(int d, int cur){
        if(d == max){
            for(int i = 0; i < max; i++){
                map[select[i].y][select[i].x] = 1;
            }
            // System.out.println("======================");
            // for (int i = 0; i < n; i++) {
            //     for (int j = 0; j < m; j++) {
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            // System.out.println("cnt: " + calc());
            ans = Math.max(ans,calc());

            for(int i = 0; i < max; i++){
                map[select[i].y][select[i].x] = 0;
            }
            return;
        }

        for(int i = cur; i < pos.size(); i++){
            select[d] = pos.get(i);
            go(d+1, i+1);
        }
    }

    static int calc(){
        int cnt = 0;
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] == 2){
                    cnt += find_group(i, j, false);
                }
            }
        }

        return cnt;
    }

    static class Pos{
        int y;
        int x;
        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

}
