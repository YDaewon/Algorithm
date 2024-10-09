import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1194 {

    static int [][] map;
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int [][][] visit;
    static Node start;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        map = new int[n][m];
        visit = new int[64][n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if(c == '.') map[i][j] = 0;
                else if(c == '#') map[i][j] = -100;
                else if(c >= 'a' && c <= 'z') map[i][j] = c - 'a' + 1;
                else if(c >= 'A' && c <= 'Z') map[i][j] = (c - 'A') * -1 - 1;
                else if (c == '0') start = new Node(i, j,0,0);
                else map[i][j] = -500;
            }
        }

        bfs();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }

    private static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(start);
        visit[0][start.p.y][start.p.x] = 1;
        int [] dy = {-1,1,0,0};
        int [] dx = {0,0,-1,1};
        while(!q.isEmpty()){
            Node now = q.poll();
            System.out.println(now.p.y + ", " + now.p.x + ", " + now.cost + ", " + now.key);
            if(map[now.p.y][now.p.x] == -500){
                ans = now.cost;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = now.p.y + dy[i];
                int nx = now.p.x + dx[i];
                if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                if(map[ny][nx] != -100 && visit[now.key][ny][nx] == 0){
                    if(map[ny][nx] > 0){ // 열쇠찾음
                        int key = now.key | 1 << (map[ny][nx]-1);
                        q.offer(new Node(ny,nx, now.cost+1,key));
                        visit[key][ny][nx] = 1;
                    }
                    else if(map[ny][nx] > -10 && map[ny][nx] < 0){ // 문 만남
                        int val = (map[ny][nx] * -1)-1;
                        if((now.key & (1 << val)) != 0){
                            q.offer(new Node(ny,nx, now.cost+1,now.key));
                            visit[now.key][ny][nx] = 1;
                        }
                    }
                    else{
                        q.offer(new Node(ny,nx, now.cost+1,now.key));
                        visit[now.key][ny][nx] = 1;
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        Point p;
        int cost, key;
        Node(int y, int x, int cost, int key){
            p = new Point(y,x);
            this.cost = cost;
            this.key = key;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }

    static class Point{
        int y, x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }


}
