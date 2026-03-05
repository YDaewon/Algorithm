 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean [][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 총높이
        star = new boolean[n][n*2];

        calc(0, n-1, n);
        pnt();
    }

    static void calc(int y, int x, int len){
        if(len == 3){
            for(int i = 0; i <= 2; i++)
                for(int j = -i; j <= i; j++) 
                    star[y+i][x+j] = true;
            
            star[y+1][x] = false;
            return;
        }

        int half = len / 2;

        calc(y, x, half);
        calc(y + half, x - half, half);
        calc(y + half, x + half, half);
    }

    static void pnt(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if(star[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
