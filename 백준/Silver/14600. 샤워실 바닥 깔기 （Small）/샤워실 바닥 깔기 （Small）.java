import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [][] arr;

    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, n);
        arr = new int [len][len];
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;

        arr[x][y] = -1;

        go(len, 0, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void go(int len, int y, int x){
        if(len == 1) return;
        int h = len / 2;
        if(find(h, y, x)) arr[y + h - 1][x + h - 1] = cnt;
        if(find(h, y, x + h)) arr[y + h - 1][x + h] = cnt;
        if(find(h, y + h, x)) arr[y + h][x + h - 1] = cnt;
        if(find(h, y + h, x + h)) arr[y + h][x + h] = cnt;

        cnt++;

        go(h, y, x);
        go(h, y, x + h);
        go(h, y + h, x);
        go(h, y + h, x + h);
    }

    private static boolean find(int h, int y, int x) {
        for (int i = y; i < y + h; i++) {
            for (int j = x; j < x + h; j++) {
                if(arr[i][j] != 0) return false;
            }
        }

        return true;
    }


}
