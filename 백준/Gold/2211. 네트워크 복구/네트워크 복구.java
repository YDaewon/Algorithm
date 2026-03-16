 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Node> [] g;
    static int [] d;
    static int [] bef;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = new List[n+1];
        d = new int[n+1];
        bef = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g[a].add(new Node(b, c));
            g[b].add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost > d[cur.v]) continue;

            for(Node nxt : g[cur.v]){
                if(d[nxt.v] > cur.cost + nxt.cost){
                    d[nxt.v] = cur.cost + nxt.cost;
                    bef[nxt.v]= cur.v;
                    pq.add(new Node(nxt.v, cur.cost + nxt.cost));
                }
            }
        }

        // for (int i = 1; i <= n; i++) {
        //     System.out.print(d[i] + " ");
        // }
        // System.out.println();
     
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            cnt++;
            sb.append(i + " " + bef[i]).append("\n");
        }
        System.out.println(cnt);
        System.out.println(sb);
    } 

    static class Node {
        int v;
        int cost;

        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
}
