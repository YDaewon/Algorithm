 import java.io.*;
import java.util.*;

public class Main {
    static int n, start, end, m;

    static List<Node> g;
    static long [] dist;

    static int [] money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n];
        money = new int [n];
        Arrays.fill(dist, Long.MIN_VALUE);

        g = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.add(new Node(a,b,c));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        bellman_ford();
    }


    static void bellman_ford(){
        dist[start] = money[start];
        boolean[] cycle = new boolean[n];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                Node cur = g.get(j);
                if(dist[cur.s] != Long.MIN_VALUE && dist[cur.e] < dist[cur.s] - cur.cost + money[cur.e]){
                    dist[cur.e] = dist[cur.s] - cur.cost + money[cur.e];
                    if(i == n) cycle[cur.e] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node cur = g.get(j);
                if(cycle[cur.s]){
                    cycle[cur.e] = true;
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.print(dist[i] + " ");
        // }
        // System.out.println();

        if(dist[end] == Long.MIN_VALUE) System.out.println("gg");
        else if(cycle[end]) System.out.println("Gee");
        else System.out.println(dist[end]);
    }

    static class Node{
        int s;
        int e;
        int cost;
        Node(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
