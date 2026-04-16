import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int m, n;
    static List<Node> [] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(n ==0 && m == 0) break;
            
            list = new List[m+1];

            for (int i = 0; i <= m; i++) {
                list[i] = new ArrayList<>();
            }
            long max = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                max += z;
                list[x].add(new Node(y, z));
                list[y].add(new Node(x, z));
            }
            for (int i = 1; i <= m; i++) {
                Collections.sort(list[i], (a, b) -> a.cost - b.cost);
            }

            long total = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
            boolean [] visit = new boolean[m+1];
            pq.add(new Node(1, 0));

            while(!pq.isEmpty()){
                Node c = pq.poll();
                
                if(visit[c.x]) continue;
                visit[c.x] = true;
                total += c.cost;

                for(Node nxt : list[c.x]){
                    if(!visit[nxt.x]){
                        pq.add(nxt);
                    }
                }
            }

            System.out.println(max - total);
        }
        
    }

    static class Node{
        int x;
        int cost;
        Node(int x, int cost){
            this.x = x;
            this.cost = cost;
        }
    }
}
