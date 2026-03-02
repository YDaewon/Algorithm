 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static List<int []> [] g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        g = new List[n+1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[s].add(new int [] {e, c});
            g[e].add(new int [] {s, c});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(get_dist(s, e) + "\n");
        }
        System.out.println(sb);
    }

    static int get_dist(int s, int e){
        int dist = 0;
        boolean [] visit = new boolean[n+1];
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {s, 0});
        visit[s] = true;

        while(!q.isEmpty()){
            int [] cur = q.poll();

            if(cur[0] == e){
                dist = cur[1];
                break;
            }

            for(int [] nxt : g[cur[0]]){
                if(!visit[nxt[0]]){
                    visit[nxt[0]] = true;
                    q.add(new int [] { nxt[0], cur[1] + nxt[1]});
                }
            }
        }

        return dist;
    }

}
