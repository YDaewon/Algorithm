import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_17089 {
    static int n, m;
    static int [][] friend;
    static List<Integer> save;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        friend = new int [n+1][n+1];
        save = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = 1;
            friend[b][a] = 1;
            friend[a][0]++;
            friend[b][0]++;
        }
        calc(0, 1, -6);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void calc(int d, int now, int sum){
        if(d == 3){
            ans = Math.min(sum, ans);
            return;
        }
        for(int i = now; i <= n; i++){
            boolean flag = true;
            for (int j : save){
                if(friend[j][i] == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                save.add(i);
                calc(d+1, i+1, sum+friend[i][0]);
                save.remove(d);
            }
        }
    }
}
