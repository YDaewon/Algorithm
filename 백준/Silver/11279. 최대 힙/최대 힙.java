 import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            int t = Integer.parseInt(br.readLine());
            if(t == 0){
                if(pq.isEmpty()) sb.append(0 +"\n");
                else sb.append(pq.poll() + "\n");
            }
            else{
                pq.add(t);
            }
        }
        // System.out.println("===========");
        System.out.println(sb);
    } 
}
