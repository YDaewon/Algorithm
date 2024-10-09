import java.util.*;


public class A_star_Algorithm {
    static int W = 10;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int [][] board = {{1,0,0,0,0,1,0,0},
                             {0,0,0,1,0,0,0,0},
                             {0,0,1,1,1,1,0,0},
                             {0,0,1,0,0,0,0,0},
                             {0,0,0,0,0,1,0,0},
                             {0,0,1,1,1,1,0,0},
                             {-1,0,0,0,1,0,0,0},
                             {0,0,1,0,0,0,0,1},
                             };
    static int [] myPos = {6,0};
    static int [] select_enemy;
    static List<int []> enemy = new ArrayList<>();
    static int [][] pnt = new int [8][8];
    static int n = 8;
    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 2) enemy.add(new int[] {i, j});
                else if (board[i][j] == -1) {
                    myPos[0] = i;
                    myPos[1] = j;
                }
            }
        }
        enemy.add(new int[] {0, 7});
        for(int [] e : enemy){
            select_enemy = e;
            List<int[]> path = A_star();
            for(int [] p : path){
                pnt[p[0]][p[1]] = 1;
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(pnt[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static List<int []> A_star(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(myPos));
        Node[][] cameFrom = new Node[8][8];
        int[][] costSoFar = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                costSoFar[i][j] = Integer.MAX_VALUE;
            }
        }
        costSoFar[myPos[0]][myPos[1]] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.y == select_enemy[0] && now.x == select_enemy[1]){
                return Path(cameFrom, select_enemy);
            }
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || ny >= 8 || nx < 0 || nx >= 8) continue;
                if(board[ny][nx] == 0){
                    if(now.g+1 < costSoFar[ny][nx]){
                        costSoFar[ny][nx] = now.g+1;
                        Node next = new Node(ny,nx, now);
                        pq.add(next);
                        cameFrom[ny][nx] = now;
                    }
                }
            }
        }
        return null;
    }

    private static List<int[]> Path(Node[][] cameFrom, int[] goal) {
        List<int[]> path = new ArrayList<>();
        Node current = new Node(goal);

        while (current != null) {
            path.add(new int[]{current.y, current.x});
            current = cameFrom[current.y][current.x];
        }

        Collections.reverse(path);
        return path;
    }

    static class Node implements Comparable<Node> {
        int y, x;
        int g, h, f;
        Node(int [] Pos){ // 초기 노드
            this.y = Pos[0];
            this.x = Pos[1];
            this.g = 0;
            this.h = get_distance(select_enemy);
            this.f = this.g+this.h;
        }
        Node(int y, int x, Node node){
            this.y = y;
            this.x = x;
            this.g = node.g + 1;
            this.h =get_distance(select_enemy);
            this.f = this.g+this.h;
        }
        int get_distance(int [] pos){
            return Math.abs(pos[0]-y) + Math.abs(pos[1]-x);
        }

        @Override
        public int compareTo(Node o) {
            return this.f > o.f ? 1 : -1;
        }
    }
}
