 import java.io.*;
import java.util.*;

public class Main {
    static int n, d, k, c;
    static int [] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int [n * 2];

        for (int i = 0; i < n; i++) {
            arr[i] = arr[n+i] = Integer.parseInt(br.readLine());
        }

        // k 개 = e - s + 1
        boolean [] visit = new boolean[d+1];
        int ans = 0;
        for (int s = 0; s < n; s++) {
            int cnt = 1;
            visit[arr[s]] = true;
            for (int e = s+1; e < s + k; e++) {
                if(!visit[arr[e]]){
                    visit[arr[e]] = true;
                    cnt++;
                }
            }
            if(!visit[c]) cnt++;
            ans = Math.max(ans, cnt);
            Arrays.fill(visit, false);
        }

        System.out.println(ans);
    }

}
