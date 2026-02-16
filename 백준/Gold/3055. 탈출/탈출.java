 import java.io.*;
import java.util.*;

public class Main {
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static int r, c;
    static Pos start, end;
    static char [][] map;
    static List<Pos> water;
    static int [][] can_move;
    static boolean [][] visit;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        can_move = new int[r][c];
        visit = new boolean[r][c];
        water = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 'D') end = new Pos(i,j);
                else if(map[i][j] == 'S') start = new Pos(i,j); 
                else if(map[i][j] == '*') {
                    water.add(new Pos(i, j));
                    can_move[i][j] = 0;
                } 
                else can_move[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int []> q = new LinkedList<>();
        for(Pos w : water) q.add(new int [] { w.y, w.x, 0});
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if(map[ny][nx] == 'X') continue;
                if(can_move[ny][nx] > cur[2]+1){
                    q.add(new int [] {ny,nx,cur[2]+1});
                    can_move[ny][nx] = cur[2]+1;
                }
            }
        }

        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         System.out.print(can_move[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        bfs();
        
        if(answer != Integer.MAX_VALUE) System.out.println(answer);
        else System.out.println("KAKTUS");
    }

    static void bfs(){
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] { start.y, start.x, 0});
        visit[start.y][start.x] = true;

        while(!q.isEmpty()){
            int [] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;

                if(map[ny][nx] == 'X') continue;

                if(ny == end.y && nx == end.x){
                    answer = Math.min(answer, cur[2] + 1);
                    return;
                }

                if(!visit[ny][nx] && cur[2] + 1 < can_move[ny][nx]){
                    q.add(new int [] {ny,nx, cur[2] + 1});
                    visit[ny][nx] = true;
                }
            }
        }
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
