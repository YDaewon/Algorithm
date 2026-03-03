 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static List<int []> [] g;
    

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        g = new List[n+1];
        for(int i = 0; i<= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g[a].add(new int [] {b, c});
            g[b].add(new int [] {a,c});
        }

        boolean [] visit = new boolean[n+1];
        
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int [] {1, 0}); 
        int ans = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            int [] cur = pq.poll();

            if(visit[cur[0]]) continue;

            cnt++;
            ans += cur[1];
            visit[cur[0]] = true;

            if(cnt == n){
                System.out.println(ans);
                return;
            }

            for(int [] nxt : g[cur[0]]){
                if(!visit[nxt[0]]){
                    pq.add(new int [] {nxt[0], nxt[1]});
                }
            }
        }
    }
}
