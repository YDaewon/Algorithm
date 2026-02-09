import java.io.*;
import java.util.*;

public class Main {
    // 각 지사의 PC는 본사와 연결이 되어있음
    // 지사끼리 연결되어있기도 함(입력받기)
    // if 본사가 고장나도 다 연결되어 있기를 바람

    static int n, m;
    static int [] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
        m = Integer.parseInt(st.nextToken()); // 컴퓨터 쌍 개수
        p = new int [n];

        for (int i = 0; i < n; i++) p[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            union(x, y);
        }


        PriorityQueue<Connect> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i != 0 && j != 0) pq.add(new Connect(i, j, cost));
            }
        }
        
        int ans_cost = 0;
        List<int []> ans_connect = new ArrayList<>();
        while(!pq.isEmpty()){
            Connect c = pq.poll();
            if(find(c.y) != find(c.x)){
                union(c.y, c.x);
                ans_cost += c.cost;
                ans_connect.add(new int [] {c.y + 1, c.x + 1});
            }
        }

        System.out.println(ans_cost + " " + ans_connect.size());
        for(int [] yx : ans_connect){
            System.out.println(yx[0] + " " + yx[1]);
        }
    }

    static int find(int x){
        if(x == p[x]) return x;
        return find(p[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) p[b] = a;
        else p[a] = b;
    }

    static class Connect implements Comparable<Connect>{
        int y;
        int x;
        int cost;
        public Connect(int y, int x, int cost){
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
        @Override
        public int compareTo(Connect o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }
}
