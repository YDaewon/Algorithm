 import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static int n, m;
    static int [][] map;
    static boolean [][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char [] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j] - '0';
            }
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int [] {0, 0, 1});

        while(!pq.isEmpty()){
            int [] c = pq.poll();
            if(c[0] == n -1 && c[1] == m-1){
                System.out.println(c[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = c[0] + dy[i];
                int nx = c[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(!visit[ny][nx] && map[ny][nx] == 1){
                    visit[ny][nx] = true;
                    pq.add(new int [] {ny,nx, c[2]+1});
                }
            }
        }
    }

   

}
