import java.util.*;

class Solution {
    int [] dy = {-1,1,0,0};
    int [] dx = {0,0,-1,1};
    final int SIZE = 100;
    boolean [][] visited = new boolean[101][101];
    int [][] board;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // Init
        board = new int [SIZE+1][SIZE+1];
        for(int [] rec : rectangle){
            Point f = new Point(rec[1] * 2, rec[0] * 2, 0);
            Point s = new Point(rec[3] * 2, rec[2] * 2, 0);
            for(int i = f.y; i <= s.y; i++){
                for(int j = f.x; j <= s.x; j++){
                    if(i == f.y || i == s.y || j == f.x || j == s.x){
                        if(board[i][j] == 0){
                            board[i][j] = 1;
                        }
                    }
                    else{
                        board[i][j] = 2;
                    }
                }
            } 
        }

        for(int i = 0; i <= 20; i++){
            for(int j = 0; j <= 20; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }    
        
        // Init 끝
        
        Point start = new Point(characterY * 2, characterX * 2, 0);
        sol(start, itemY * 2, itemX * 2);
        return answer;
    }

    void sol(Point p, int itemY, int itemX){
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        visited[p.y][p.x] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            //System.out.println("now Point: " + cur.y + ", " + cur.x + ", cost: " + cur.cost);
            if(cur.y == itemY && cur.x == itemX) answer = Math.min(answer, cur.cost / 2);
            for(int i = 0; i < 4; i++){
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny > SIZE || ny < 0 || nx > SIZE || nx < 0) continue;
                if(board[ny][nx] == 1 && !visited[ny][nx]){
                    q.add(new Point(ny, nx, cur.cost + 1));
                    visited[ny][nx] = true;
                }
            }
        }
    }
    
}

class Point{
    int y;
    int x;
    int cost; 
    Point(int y, int x, int cost){
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
}