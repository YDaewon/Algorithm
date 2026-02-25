 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [][] arr;
    static int [] dy= {1,0,-1,0};
    static int [] dx = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());

        int y = 1;
        int x = 1;
        int d = 0;

        arr = new int[n+2][n+2];

        for (int i = 0; i < n + 1; i++) {
            arr[i][0] = -1;
            arr[i][n+1] = -1;
            arr[0][i] = -1;
            arr[n+1][i] = -1;
        }


        int ansy = 0;
        int ansx = 0;

        for (int i = n * n; i >= 1; i--) {
            arr[y][x] = i;
            if(arr[y][x] == find) {
                ansy = y;
                ansx = x;
            }

            //System.out.println("y: " + y + ", x: " + x + ", arr[y][x]: " + arr[y][x]);
            if(arr[y + dy[d]][x + dx[d]] != 0) d = (d+1) % 4;
            y += dy[d];
            x += dx[d];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(ansy + " " + ansx);
    }

}
