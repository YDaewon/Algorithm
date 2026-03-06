 import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int ans = Integer.MAX_VALUE;
    static int [][] dp = new int [2001][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        calc(0, 1, 0);

        System.out.println(ans);
    }   

    static void calc(int t, int cnt, int copy){
        PriorityQueue<int []> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        q.add(new int []{t,cnt,copy});

        while(!q.isEmpty()){
            int [] c = q.poll();
            if(c[1] == 0 || c[2] > n) continue;
            if(c[1] == n){
                ans = c[0];
                break;
            }
            // System.out.println(c[0] + ", " + c[1] + ", " + c[2]);
            if(dp[c[1]][c[2]] <= c[0]) continue;
            
            dp[c[1]][c[2]] = c[0];

            q.add(new int [] {c[0] + 1, c[1] -1, c[2]});
            if(c[1] != c[2]) q.add(new int [] {c[0]+1, c[1], c[1]});
            if(c[2] != 0) q.add(new int [] {c[0]+1, c[1] + c[2], c[2]});
        }
    }

    // static void calc(int t, int cnt, int copy){
    //     if(cnt == 0 || copy > n) return;
    //     if(cnt == n) {
    //         ans = Math.min(ans, t);
    //         return;
    //     }
    //     if(dp[cnt][copy] <= t) return;

    //     // System.out.println(t + ", " + cnt + ", " + copy);
        
    //     dp[cnt][copy] = t;

    //     calc(t + 1, cnt - 1, copy);
    //     if(cnt != copy) calc(t + 1, cnt, cnt);
    //     if(copy != 0) calc(t + 1, cnt + copy, copy);
    // }
}
