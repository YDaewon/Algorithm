 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] arr;
    static int [] res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [n];
        res = new int [m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        go(0,0);

        System.out.println(sb);
    }

    static void go(int cur, int d){
        if(d == m){
            for(int i = 0; i < m; i++){
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int t = -1;
        for (int i = cur; i < n; i++) {
            if(arr[i] != t){
                res[d] = arr[i];
                t = arr[i];

                go(i + 1, d + 1);
            }
        }
    }
}
