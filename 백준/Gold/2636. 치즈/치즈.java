 import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static int n, m, cnt = 0;
    static int [][] chz;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chz = new int [n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                chz[i][j] = Integer.parseInt(st.nextToken());
                if(chz[i][j] == 1) cnt++;
            }
        }

        int ans = 0;
        int bef = 0;
        while(cnt > 0){
            bef = cnt;
            boolean [][] visit = new boolean[n][m];
            bfs(visit); 
            ans++;
        }
        System.out.println(ans);
        System.out.println(bef);
    }

    static void bfs(boolean [][] visit){
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {0, 0});
        visit[0][0] = true;

        while(!q.isEmpty()){
            int [] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(!visit[ny][nx]){
                    visit[ny][nx] = true;
                    if(chz[ny][nx] == 1) {
                        chz[ny][nx] = 2;
                        cnt--;
                    }
                    else q.add(new int [] {ny,nx});
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(chz[i][j] == 2) chz[i][j] = 0;
            }
        }
    }

    
}
