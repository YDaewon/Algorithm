 import java.io.*;
import java.util.*;

public class Main {

    static int n,m,x,y,k;
    static int [][] map;
    static int [] dy = {0, 0, -1, 1};
    static int [] dx = {1, -1, 0, 0};
    static Dice dice = new Dice();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int [n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            go(cmd - 1);
        }
        System.out.println(sb);

    }   

    static void go(int cmd){
        int ny = y + dy[cmd];
        int nx = x + dx[cmd];

        if(ny < 0 || ny >= n || nx < 0 || nx >= m) return;

        y = ny;
        x = nx;
        roll(cmd);

        if(map[y][x] == 0) map[y][x] = dice.bottom;
        else {
            dice.bottom = map[y][x];
            map[y][x] = 0;
        }

        sb.append(dice.top + "\n");
    }


    static void roll(int cmd){  // 0 : 오 1: 왼 2 : 위 3 : 아래
        if(cmd == 0){
            int temp = dice.top;
            dice.top = dice.left;
            dice.left = dice.bottom;
            dice.bottom = dice.right;
            dice.right = temp;
        }
        else if(cmd == 1){
            int temp = dice.top;
            dice.top = dice.right;
            dice.right = dice.bottom;
            dice.bottom = dice.left;
            dice.left = temp;
        }
        else if(cmd == 2){
            int temp = dice.top;
            dice.top = dice.front;
            dice.front = dice.bottom;
            dice.bottom = dice.back;
            dice.back = temp;
        }
        else{
            int temp = dice.top;
            dice.top = dice.back;
            dice.back = dice.bottom;
            dice.bottom = dice.front;
            dice.front = temp;
        }
    }


    static class Dice{
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        int front = 0;
        int back = 0;
    }
}
