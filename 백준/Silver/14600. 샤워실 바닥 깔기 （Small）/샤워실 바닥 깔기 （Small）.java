import java.io.*;
import java.util.*;

public class Main {
    static int k;
    
    static int num = 1;
    static int [][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        int len = (int)Math.pow(2, k);
        board = new int [len][len];
        board[y][x] = -1;

        go(0,0, len);

        StringBuilder sb = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void go(int y, int x, int l){
        if(l == 1) return;

        int half = l / 2;

        if(!find(y, x, half)) board[y + half - 1][x + half - 1] = num;
        if(!find(y, x + half, half)) board[y + half - 1][x + half] = num;
        if(!find(y + half, x, half)) board[y + half][x + half - 1] = num;
        if(!find(y + half, x + half, half)) board[y + half][x + half] = num;
        num++;

        go(y, x, half);
        go(y, x + half, half);
        go(y + half, x, half);
        go(y + half, x + half, half);
    }


    static boolean find(int y, int x, int l){
        for (int i = y; i < y + l; i++) {
            for (int j = x; j < x + l; j++) {
                if(board[i][j] != 0) return true;
            }
        }
        return false;
    }
}
