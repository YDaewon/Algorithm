 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer> [] g;
    static boolean [] visit;
    static int max_cost;
    static int end = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        g = new List[n+1];
        visit = new boolean[n+1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();    
        
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g[a].add(b);
            g[b].add(a);
        }

        max_cost = -1; 
        visit[end] = true;
        dfs(1, 0);

        visit = new boolean[n + 1];
        max_cost = -1; 
        visit[end] = true;
        dfs(end, 0);

        System.out.println((max_cost + 1) / 2);
    } 

    static void dfs(int now, int cost) {
        if(cost > max_cost){
            max_cost = cost;
            end = now;
        }

        for(int i : g[now]){
            if(visit[i]) continue;
            visit[i] = true;
            dfs(i, cost+1);
        }
    }
}
