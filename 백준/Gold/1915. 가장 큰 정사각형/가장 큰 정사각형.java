 import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [n+1][m+1];

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j-1) - '0';
                if(arr[i][j] == 0) continue;

                int t =  arr[i-1][j];
                t = Math.min(t, arr[i][j-1]);
                t = Math.min(t, arr[i-1][j-1]);
                arr[i][j] = t + 1;

                ans = Math.max(ans, arr[i][j]);
            }
        }

        System.out.println(ans * ans);
    }   
}
