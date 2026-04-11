import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean [] wall;

    /*
    |   |   |   |   |   |
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        wall = new boolean [n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j < e; j++) {
                wall[j] = true;
            }
        }

        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if(!wall[i]) cnt++;
        }
        System.out.println(cnt);
    }

}
