 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] arr;
    static int [] mem;

    static int [] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [n];
        mem = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = 0;
        for (int i = 0; i < n; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
            t += mem[i];
        }
        dp = new int [t+1];

        for (int i = 0; i < n; i++) {
            for (int j = t; j >= 0; j--) {
                if(j >= mem[i]) dp[j] = Math.max(dp[j], dp[j - mem[i]] + arr[i]);
            }
        }

        for(int i = 0; i <= t; i++){
            //System.out.print(dp[i] + " ");
            if(dp[i] >= m){
                System.out.println(i);
                break;
            }
        }

    }

}
