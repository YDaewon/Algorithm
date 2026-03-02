 import java.io.*;
import java.util.*;

public class Main {
    static int k;

    static int num = 1;
    static int [][] tile;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, k);
        tile = new int [len][len];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        tile[y][x] = -1;

        lay_tiles(0, 0, len);
        pnt(len);
        System.out.println(sb);
    }
    /*
    4분할 후 구멍이 있는 곳 찾기
    2 1 
    3 4
    로 사분면을 정의할 때 경우의 수는
    o x   x o   o o   o o
    o o   o o   x o   o x

    사분면이 있는 쪽은 제외, 나머지를 타일 채우기
    ex
    0  0  0  0        0  0  0  0
    0  0  0  0   ->   0  1  1  0
    0  0 -1  0        0  1 -1  0
    0  0  0  0        0  0  0  0

    이후 각 사분면을 다시 4분할
    이 때 아까 채워둔 타일이 새로운 구멍이 되는 것 = 나머지 빈곳 타일 채우기
    1이 구멍이 됨
    2 사분면을 봤을 때
    0  0   ->     2  2
    0  1          2  1


    각 사분면이 끝난다면

    3  3  2  2
    3  1  1  2
    4  1 -1  5 
    4  4  5  5

    완성
    */

    static void lay_tiles(int y, int x, int len) {
        if(len == 1) return;

        int now = len/2;

        if(!find_hole(y, x + now, now)) tile[y + now - 1][x + now] = num;    // 1 사분면
        if(!find_hole(y, x, now)) tile[y + now - 1][x + now - 1] = num;      // 2 사분면
        if(!find_hole(y + now, x, now)) tile[y + now][x + now - 1] = num;    // 3 사분면
        if(!find_hole(y + now, x + now, now)) tile[y + now][x + now] = num;  // 4 사분면

        num++;

        lay_tiles(y, x + now, now);
        lay_tiles(y, x, now);
        lay_tiles(y + now, x, now);
        lay_tiles(y + now, x + now, now);
    }

    static boolean find_hole(int y, int x, int len){
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if(tile[i][j] != 0) return true;
            }
        }

        return false;
    }

    static void pnt(int size){
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                sb.append(tile[i][j] + " ");
            }
            sb.append("\n");
        }
    }
}
