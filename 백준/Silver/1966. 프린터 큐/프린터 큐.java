import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
            Queue<int []> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int t = Integer.parseInt(st.nextToken());
                pq.add(t);
                q.add(new int [] {i, t});
            }
            
            
            int cnt = 0;

            while(!q.isEmpty()){
                int [] c = q.poll();
                if(c[1] == pq.peek()){
                    pq.poll();
                    cnt++;
                    if(c[0] == m){
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
                else{
                    q.add(c);
                }
            }
        }
        System.out.println(sb);
    }
}
