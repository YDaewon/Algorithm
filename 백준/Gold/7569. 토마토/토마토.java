 import java.io.*;
import java.util.*;

public class Main {
    static int [] dx = {-1,1,0,0,0,0};
    static int [] dy = {0,0,-1,1,0,0};
    static int [] dz = {0,0,0,0,-1,1};

    static int n, m, h;
    static int [][][] box;
    static int [][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int [h][n][m];
        
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int day = 0;

        Queue<int []> q = new LinkedList<>();
        visit = new int[h][n][m];

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if(box[z][y][x] == 1){
                        visit[z][y][x] = 0;
                        q.add(new int [] {z,y,x,0});
                    }
                    else if (box[z][y][x] == 0) visit[z][y][x] = -1;
                }
            }
        }
        while(!q.isEmpty()){
            int [] cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nz = cur[0] + dz[i];
                int ny = cur[1] + dy[i];
                int nx = cur[2] + dx[i];
                int cost = cur[3] + 1;

                if(nz < 0 || nz >= h || ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(visit[nz][ny][nx] == -1&& box[nz][ny][nx] == 0){
                    box[nz][ny][nx] = 1;
                    visit[nz][ny][nx] = cost;
                    q.add(new int [] {nz,ny,nx,cost});
                }
            }
        }

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if(visit[z][y][x] == -1){
                        System.out.println(-1);
                        return;
                    }
                    day = Math.max(visit[z][y][x], day);
                }
            }
        }
        
        System.out.println(day);
    }
}
