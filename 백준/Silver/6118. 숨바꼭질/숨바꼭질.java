 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static List<Integer> [] A;
    static int [] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        A = new List[n+1];
        dist = new int [n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) A[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int b = 0;
        int a = 0;
        int c = 0;
        pq.add(new int [] {1, 1});
        while(!pq.isEmpty()){
            int [] cur = pq.poll();

            for (int nxt : A[cur[0]]) {
                if(dist[nxt] > cur[1]){
                    dist[nxt] = cur[1];
                    b = Math.max(b, dist[nxt]);
                    pq.add(new int[] {nxt, cur[1]+1});
                }
            }
        }
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if(dist[i] == b) {
                if(flag){
                    a = i;
                    flag = false;
                }
                c++;
            }
        }

       System.out.println(a + " " + b + " " + c);

    }
}
