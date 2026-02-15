 import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static int n, m, island = 1;
    static int [][] map;
    static int [][] bridges;
    static boolean [][] visit;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1. count island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] != 0) counting_island(i, j);
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // 2. make bridges

        bridges = new int [island][island];
        for (int i = 1; i < island; i++) {
            Arrays.fill(bridges[i], Integer.MAX_VALUE);
            bridges[i][i] = 0;
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] != 0) make_bridge(i, j);
            }
        }

        // for (int i = 1; i < island; i++) {
        //     for (int j = 1; j < island; j++) {
        //         System.out.print(bridges[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        List<int []> temp = new ArrayList<>();
        
        for (int i = 1; i < island; i++) {
            for (int j = i+1; j < island; j++) {
                if(bridges[i][j] != Integer.MAX_VALUE) temp.add(new int [] {i,j,bridges[i][j]});  
            }
        }
        
        Collections.sort(temp, (a, b) -> {return a[2] > b[2] ? 1 : -1;});

        // 3. union island
        parent = new int [island];
        for (int i = 1; i < island; i++) {
            parent[i] = i;
        }
        
        int ans = 0;
        int use = 0;
        for (int [] now : temp) {
            if(union(now[0], now[1])) {
                ans += now[2];
                use++;
            }
        }

        if(use == island-2) System.out.println(ans);
        else System.out.println(-1);
    }
    
    static int find(int a){
        if(a == parent[a]) return a;
        else return find(parent[a]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            if(a < b) parent[b] = a;
            else parent[a] = b;
            return true;
        }
        else return false;
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

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
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
        int s = map[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

            int cnt = 0;
            boolean flag = true;
            while(map[ny][nx] == 0){
                ny += dy[i];
                nx += dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m){
                    flag = false;
                    break;
                } 
                cnt++;             
            }
            if(flag && cnt >= 2){
                int e = map[ny][nx];
                bridges[s][e] = Math.min(bridges[s][e], cnt);
                bridges[e][s] = Math.min(bridges[e][s], cnt);
            }
        }
    }
}
