 import java.io.*;
import java.util.*;

public class Main {
    static int n, c;

    static List<Jewel> [] list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        List<int []> jewel = new ArrayList<>();
        int maxY = 0;
        int maxX = 0;


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            maxX = Math.max(maxY, x);
            int y = Integer.parseInt(st.nextToken());
            maxY = Math.max(maxX, y);
            int c = Integer.parseInt(st.nextToken());

            jewel.add(new int[] {x, y, c});
        }

        list = new List[maxX+1];
        for (int i = 0; i <= maxX; i++) {
            list[i] = new ArrayList<>();
        }

        for (int [] arr : jewel) {
            list[arr[0]].add(new Jewel(arr[0], arr[1], arr[2]));
        }

        PriorityQueue<Jewel> pq = new PriorityQueue<>((a, b) -> b.y - a.y);

        long ans = 0;
        long sum = 0;
        int curY = maxY;
        for(int i = 0; i <= maxX; i++){
            if(list[i].isEmpty()) continue;

            for(Jewel j : list[i]){
                if(j.y <= curY) {
                    pq.add(j);
                    sum += j.cost;
                }
            }

            while(pq.size() > c){
                int ty = pq.peek().y;
                while(!pq.isEmpty() && pq.peek().y == ty){
                    sum -= pq.poll().cost;
                }
                curY = ty;
            }

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
    
    static class Jewel{
        int y;
        int x;
        int cost;

        Jewel(int x, int y, int cost){
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
