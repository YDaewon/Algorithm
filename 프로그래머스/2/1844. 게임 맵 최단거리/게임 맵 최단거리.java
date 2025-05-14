import java.util.*;

class Solution {
    int [] dy = {1, -1,0,0};
    int [] dx = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        // 0 이 벽
        return sol(maps);
    }
    
    public int sol(int [][] maps){
        int n = maps.length;
        int m = maps[0].length;
        
        int [][] visit = new int [n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] {1, 0, 0});
        visit[0][0] = 0;
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            int cost = cur[0];
            int y = cur[1];
            int x = cur[2];
            if(y == n-1 && x == m-1) return cost;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || maps[ny][nx] == 0) continue;
                if(cost + 1 < visit[ny][nx]){
                    pq.add(new int [] {cost + 1, ny, nx});
                    visit[ny][nx] = cost + 1;
                }
            }
        }
        return -1;
    }
    
}