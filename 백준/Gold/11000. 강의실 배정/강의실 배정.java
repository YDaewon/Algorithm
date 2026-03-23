 import java.io.*;
import java.util.*;

public class Main {
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        PriorityQueue<Class> pq = new PriorityQueue<>((a, b) -> {
            if(a.s == b.s) return a.e - b.e;
            return a.s - b.s;
        });


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Class(s, e));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(-1);

        while(!pq.isEmpty()){
            Class now = pq.poll();
            if(now.s >= room.peek()) room.poll();
            
            room.add(now.e);
        }

        System.out.println(room.size());

        
    }

    static class Class{
        int s;
        int e;
        Class(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}
