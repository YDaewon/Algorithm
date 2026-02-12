import java.io.*;
import java.util.*;
/*
왼쪽 아래가 1,1
오른쪽 위가 2k, 2k
y가 새로, x가 가로
1부터 시작함




*/
public class Main {

    static int k, len, y, x;

    static int [][] g;
    static StringBuilder sb = new StringBuilder();
    static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        len = (int) Math.pow(2, k);
        g = new int[len][len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken())-1;
        y = Integer.parseInt(st.nextToken())-1;
        g[y][x] = -1;
        calc(len, 0, 0);

        print_answer();
    }
    /*
    8칸짜리
    0~3, 4~7

      o x
      o o  q: 1

      x o   
      o o  q: 2

      o o
      x o  q: 3

      o o
      o x  q: 4

      2 1
      3 4

    */

    

    static void calc(int now, int y, int x){
        if(now == 1) return;

        int quadrant = 0;
        int h = now / 2;
        if(!check(y, x + h, h)) g[y + h - 1][x + h] = num; 
        if(!check(y, x, h)) g[y + h - 1][x + h - 1] = num; 
        if(!check(y + h, x, h)) g[y + h][x + h - 1] = num; 
        if(!check(y + h, x + h, h)) g[y + h][x + h] = num; 

        num++;

        calc(h, y, x);
        calc(h, y, x + h);
        calc(h, y+h, x);
        calc(h, y + h, x + h);
    }

    static boolean check(int y, int x, int size){
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(g[i][j] != 0) return true;
            }
        }
        return false;
    }


    static void print_answer(){
        for (int i = len-1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                sb.append(g[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
