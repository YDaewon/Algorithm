 import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static int score = 0;

    static int [][] blue = new int [4][10];

    static int [][] green = new int [10][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(n -- > 0){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); // 세로
            int x = Integer.parseInt(st.nextToken()); // 가로
            simulation(t, y, x);
        }
        int cnt = 0;
        for (int i = 4; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                if(blue[j][i] == 1) cnt++;
                if(green[i][j] == 1) cnt++;
            }
        }

        System.out.println(score);
        System.out.println(cnt);
    }

    static void simulation(int block, int y, int x){
        // 1. simul
        blue_move(block, y, x);
        green_move(block, y, x);
      
        // 2. calc score
        blue_calc();
        green_calc();

        // 3. fall block
        fall_blue();
        fall_green();

        // pnt();
    }

    static void blue_move(int block, int y, int x){
        int tx = 0;
        for (int i = 0; i <= 9; i++) {
            if (block == 1 || block == 3) {
                if (i > 9 || blue[y][i] == 1 || (block == 3 && blue[y + 1][i] == 1)) break;
                tx = i;
            } else if (block == 2) {
                if (i > 9 || blue[y][i] == 1) break;
                tx = i;
            }
        }
        
        // 최종 위치에 블록 배치
        if (block == 1) blue[y][tx] = 1;
        else if (block == 2) {
            blue[y][tx] = 1;
            blue[y][tx - 1] = 1;
        } else if (block == 3) {
            blue[y][tx] = 1;
            blue[y + 1][tx] = 1;
        }
    }

    static void green_move(int block, int y, int x){
        int ty = 0;
        for (int i = 0; i <= 9; i++) {
            if (block == 1 || block == 2) {
                if (i > 9 || green[i][x] == 1 || (block == 2 && green[i][x + 1] == 1)) break;
                ty = i;
            } else if (block == 3) {
                if (i > 9 || green[i][x] == 1) break;
                ty = i;
            }
        }

        if (block == 1) green[ty][x] = 1;
        else if (block == 2) {
            green[ty][x] = 1;
            green[ty][x + 1] = 1;
        } else if (block == 3) {
            green[ty][x] = 1;
            green[ty - 1][x] = 1;
        }
    }

    static void blue_calc(){
        for (int i = 9; i >= 6; i--) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if(blue[j][i] == 0) flag = false;
            }

            if(flag){
                score++;
                for (int x = i; x > 4; x--) {
                    for (int y = 0; y < 4; y++) {
                        blue[y][x] = blue[y][x-1];
                    }
                }
                for (int y = 0; y < 4; y++) blue[y][4] = 0;
                i++;
            }
        }
    }

    static void green_calc(){
        for (int i = 9; i >= 6; i--) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if(green[i][j] == 0) flag = false;
            }

            if(flag){
                score++;
                for (int x = i; x > 4; x--) {
                    for (int y = 0; y < 4; y++) {
                        green[x][y] = green[x-1][y];
                    }
                }
                for (int x = 0; x < 4; x++) green[4][x] = 0;
                i++;
            }
        }
    }

    static void fall_blue(){
        int cnt = 0;
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if(blue[j][i] == 1){
                    cnt++;
                    break;
                }
            }
        }

        while(cnt-- > 0) {
            for (int x = 9; x > 4; x--) {
                for (int y = 0; y < 4; y++) {
                    blue[y][x] = blue[y][x-1];
                }
            }
            for (int y = 0; y < 4; y++) blue[y][4] = 0;
        }
    }

    static void fall_green(){
        int cnt = 0;
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if(green[i][j] == 1){
                    cnt++;
                    break;
                }
            }
        }
        while(cnt-- > 0) {
            for (int x = 9; x > 4; x--) {
                for (int y = 0; y < 4; y++) {
                    green[x][y] = green[x-1][y];
                }
            }
            for (int y = 0; y < 4; y++) green[4][y] = 0;
        }
    }


    static void pnt(){
        for (int i = 0; i < 4; i++) {
           for (int j = 0; j < 10; j++) {
                System.out.print(blue[i][j] + " ");
           } 
           System.out.println();
        }

        for (int i = 4; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(green[i][j] + " ");
            } 
            System.out.println();
        }
    }
}
