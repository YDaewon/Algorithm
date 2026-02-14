import java.io.*;
import java.util.*;

public class Main {
    // 0 : 위, 1: 아래, 2: 좌, 3: 우
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static int n, m, k;
    static boolean isEnd = false;

    static int [][] map;
    static int [][][] smell;
    static Shark [] sharks;
    
    /*
    이동 메커니즘
    1. 냄새가 없는 칸 
    1-1. 여러개 일때는 우선순위를 따름
    2. 자신의 냄새가 있는 칸
    2-1. 여러개 일때는 우선순위를 따름
    
    3.이동 후 같은 칸에 겹치면 가장 작은 번호 상어만 생존(격자판 min 활용)
    */
    public static void main(String[] args) throws IOException {
        init();
        // pnt();
        int cnt = 0;
        while(!isEnd && cnt <= 1000){
            simulate();
            // pnt();
            check();
            cnt++;
        }
        if(cnt > 1000) System.out.println(-1);
        else System.out.println(cnt);
    }

    static void check(){
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0) t++;
            }
        }
        if(t ==1) isEnd = true;
    }

    static void pnt(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + "(" + smell[i][j][0] + ", " + smell[i][j][1] + ") ");
            }
            System.out.println();
        }
        System.out.println("=============================================================");
    }

    static void simulate(){
        int [][] nxtmap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0){
                    int next_direction = decide_direction(i, j, map[i][j]);
                    sharks[map[i][j]].d = next_direction;
                    int ny = i + dy[next_direction];
                    int nx = j + dx[next_direction];
    
                    if(nxtmap[ny][nx] == 0 || nxtmap[ny][nx] > map[i][j]){
                        nxtmap[ny][nx] = map[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                if(smell[i][j][0] != 0) if(--smell[i][j][1] == 0) smell[i][j][0] = 0;
                
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(nxtmap[i][j] != 0){
                    smell[i][j][0] = nxtmap[i][j];
                    smell[i][j][1] = k;
                }
                map[i][j] = nxtmap[i][j];
            }
        }

        
    }

    static int decide_direction(int y, int x, int shark){
        int cur = sharks[shark].d;
        int nxt = cur;
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int priority = sharks[shark].move[cur][i];
            int ny = y + dy[priority];
            int nx = x + dx[priority];
            if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
            if(smell[ny][nx][0] == 0) {
                return priority;
            }
            else{
                if (smell[ny][nx][0] == shark && flag){
                    nxt = priority;
                    flag = false;
                }
            }
        }

        return nxt;
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int [n][n];
        sharks = new Shark [m+1];
        smell = new int[n][n][2];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    smell[i][j][0] = map[i][j];
                    smell[i][j][1] = k;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            sharks[i] = new Shark(Integer.parseInt(st.nextToken()) - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < 4; l++) {
                    sharks[i].move[j][l] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }
    }

    static class Shark{
        int d;
        int [][] move; // [방향][우선순위(앞부터)]

        public Shark(int d){
            this.d = d;
            this.move = new int[4][4];
        }
    }

    
}
