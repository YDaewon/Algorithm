 import java.io.*;
import java.util.*;

public class Main {
    static int n, m, a, b;
    static long c;

    static List<Node> [] road;
    static long [] sum;
    static List<int []> save;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());

        road = new ArrayList[n+1];
        sum = new long [n+1];

        for (int i = 1; i <= n; i++) road[i] = new ArrayList<>();
        
        long max = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            max = Math.max(cost, max);
            road[s].add(new Node(e, cost));
            road[e].add(new Node(s, cost));
        }
        
        long left = 0;
        long right = max;
        while(left <= right){
            long mid = (left + right) / 2;
            // System.out.println("l: " +left+", r: " + right);
            if(calc(mid)) right = mid - 1;
            else left = mid + 1;
        }
        
        System.out.println((left > max ? -1 : left));
    }
    
    static boolean calc(long max){
        PriorityQueue<long []> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        Arrays.fill(sum, Long.MAX_VALUE);
        sum[a] = 0;
        
        pq.add(new long [] {a, 0});
        
        while(!pq.isEmpty()){
            long [] cur = pq.poll();

            if (cur[1] > sum[(int)cur[0]]) continue;
            
            for(Node node : road[(int)cur[0]]){
                long nc = cur[1] + node.cost;
                if(node.cost <= max && nc < sum[node.x]){
                    sum[node.x] = nc;
                    pq.add(new long [] {node.x, nc});
                }
            }
        }

        return sum[b] <= c;
    }


    static class Node{
        int x;
        long cost;

        Node(int x, long cost){
            this.x = x;
            this.cost = cost;
        }
    }

}
