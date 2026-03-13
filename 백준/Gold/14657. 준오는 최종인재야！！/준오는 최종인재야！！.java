 import java.io.*;
import java.util.*;

public class Main {

    static int n,t;
    static List<Node> [] g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        g = new List[n+1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g[a].add(new Node(b, c));
            g[b].add(new Node(a, c));
        }

        Graph first = find_farthest(1);
        Graph second = find_farthest(first.now);

        int answer = second.total_cost / t;
        if(second.total_cost % t != 0) answer++;

        System.out.println(answer);
    }   

    static Graph find_farthest(int start){
        Queue<Graph> q = new LinkedList<>();
        boolean [] visit = new boolean[n+1];
        Graph s = new Graph(start, 1, 0);
        q.add(s);
        visit[s.now] = true;

        Graph farthest = s;

        while(!q.isEmpty()){
            Graph cur = q.poll();

            if(is_far(cur, farthest)){
                farthest = cur;
            }

            for(Node nxt : g[cur.now]){
                if(!visit[nxt.val]){
                    visit[nxt.val] = true;
                    q.add(new Graph(nxt.val, cur.cnt + 1, cur.total_cost + nxt.cost));
                }
            }
        }

        return farthest;
    }

    static boolean is_far(Graph o1, Graph o2){
        if(o1.cnt > o2.cnt) return true;
        if(o1.cnt == o2.cnt && o1.total_cost < o2.total_cost) return true;
        return false;
    }

    static class Node{
        int val;
        int cost;
        Node(int val, int cost){
            this.val = val;
            this.cost = cost;
        }
    }

    static class Graph{
        int now;
        int cnt;
        int total_cost;

        Graph(int now, int cnt, int total_cost){
            this.now = now;
            this.cnt = cnt;
            this.total_cost = total_cost;
        }
    }
}
