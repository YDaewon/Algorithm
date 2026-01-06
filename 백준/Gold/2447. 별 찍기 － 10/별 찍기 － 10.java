import java.util.*;
import java.io.*;


public class Main {
    static char [][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        star = new char [n][n];
        starPrint(0, 0, n, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(star[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void starPrint(int y, int x, int now, int cnt){
        if(cnt == 5){
            for (int i = y; i < y + now; i++) {
                for (int j = x; j < x + now; j++) {
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if(now == 1) {
            star[y][x] = '*';
            return;
        }
        int cur = 1;
        for (int i = y; i < y + now; i += now/3) {
            for (int j = x; j < x + now; j += now/3) {
                starPrint(i, j, now/3, cur++);
            }
        }
    }
}