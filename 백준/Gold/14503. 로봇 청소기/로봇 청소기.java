import java.util.*;
import java.io.*;


public class Main {
    static int d; // 0 : up, 1: right, 2: down, 3: left
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};

    static int n;
    static int m;
    static int cnt = 0;
    static int [][] map;
    static int [] now;
    static boolean [][] clean;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        now = new int[2];
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        clean = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(simulation()){ // 후진
                int temp_d = (d + 2) % 4;
                int ny = now[0] + dy[temp_d];
                int nx = now[1] + dx[temp_d];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == 1) break;
                now[0] = ny;
                now[1] = nx;
            }
            else{
                change_direction();
                int ny = now[0] + dy[d];
                int nx = now[1] + dx[d];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] == 0 && !clean[ny][nx]){
                    now[0] = ny;
                    now[1] = nx;
                }
            }
        }

        System.out.println(cnt);

    }

    static boolean simulation(){
        if(!clean[now[0]][now[1]]){
            clean[now[0]][now[1]] = true;
            cnt++;
        }
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int ny = now[0] + dy[i];
            int nx = now[1] + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(map[ny][nx] == 0 && !clean[ny][nx]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    static void change_direction(){
        d = (d + 3) % 4;
    }

}