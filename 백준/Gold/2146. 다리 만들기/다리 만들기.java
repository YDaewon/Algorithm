 import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static int n, island = 1;
    static int [][] map;
    static int answer = Integer.MAX_VALUE;
    static boolean [][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int [n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1. count island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j] && map[i][j] != 0) counting_island(i, j);
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // 2. make bridges

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0){
                    visit = new boolean[n][n];
                    make_bridge(i, j);
                }
            }
        }

        System.out.println(answer);
    }
    
    static void counting_island(int y, int x){
        Queue <int []> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visit[y][x] = true;
        map[y][x] = island;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(!visit[ny][nx] && map[ny][nx] == 1){
                    visit[ny][nx] = true;
                    map[ny][nx] = island;
                    q.add(new int [] { ny, nx });
                }
            }
        }

        island++;
    }

    static void make_bridge(int y, int x){

        int now_island = map[y][x];
        Queue <int []> q = new LinkedList<>();
        q.add(new int[] {y, x, 0});
        visit[y][x] = true;

        while(!q.isEmpty()){
            int [] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(map[ny][nx] == now_island) continue;
                
                if(!visit[ny][nx]){
                    visit[ny][nx] = true;
                    if(map[ny][nx] != 0) {
                        answer = Math.min(answer, cur[2]);
                        continue;
                    }
                    q.add(new int [] { ny, nx, cur[2] + 1});
                }
            }
        }
    }
}
