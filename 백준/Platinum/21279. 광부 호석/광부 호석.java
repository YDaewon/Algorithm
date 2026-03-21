 import java.io.*;
import java.util.*;

public class Main {
    static int n, c;

    static List<Jewel> arr = new ArrayList<>();

    static List<Jewel>[] ax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int maxy = 0;
        int maxx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            maxy = Math.max(y, maxy);
            int x = Integer.parseInt(st.nextToken());
            maxx = Math.max(x, maxx);
            int cost = Integer.parseInt(st.nextToken());

            arr.add(new Jewel(y, x, cost));
        }

        ax = new List[maxx+1];
        for (int i = 0; i < maxx+1; i++) ax[i] = new ArrayList<>();

        for(Jewel j : arr) ax[j.x].add(j);
        
        long ans = 0;
        int nowy = maxy;
        PriorityQueue<Jewel> pq = new PriorityQueue<>((a, b) -> b.y - a.y);
        long sum = 0;

        for (int sx = 0; sx <= maxx; sx++) {
            if(ax[sx].isEmpty()) continue;

            for (Jewel j : ax[sx]) {
                if(nowy >= j.y) {
                    pq.add(j);
                    sum += j.cost;
                }
            }


            while(pq.size() > c){
                int max = pq.peek().y;
                while(!pq.isEmpty() && max == pq.peek().y){
                    sum -= pq.poll().cost;
                }
                nowy = max;
            }

            ans = Math.max(ans, sum);
        }


       System.out.println(ans);

    }

    static class Jewel{
        int y;
        int x;
        int cost;

        Jewel(int y, int x, int cost){
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }

}
