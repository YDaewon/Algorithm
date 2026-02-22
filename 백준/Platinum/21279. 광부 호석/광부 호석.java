 import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static int maxH = 0, maxW = 0;
    static List<Node> [] jewel;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        List<int []> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int [] arr = new int[3];
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken()); // x
            maxW = Math.max(arr[0], maxW);
            arr[1] = Integer.parseInt(st.nextToken()); // y
            maxH = Math.max(arr[1], maxH);
            arr[2] = Integer.parseInt(st.nextToken()); // cost
            input.add(arr);
        }

        jewel = new ArrayList[maxW + 1];
        for (int i = 0; i <= maxW; i++) {
            jewel[i] = new ArrayList<>();
        }

        for(int [] in : input){
            jewel[in[0]].add(new Node(in[1], in[2]));
        }

        long sum = 0;
        long answer = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int w = 0; w <= maxW; w++){
            if(jewel[w].isEmpty()) continue;
            for(Node node : jewel[w]){
                pq.add(new int[] {node.p, node.cost});
                sum += node.cost;
            }

            while(pq.size() > c){
                int mh = pq.peek()[0];
                while (!pq.isEmpty() && pq.peek()[0] == mh) {
                    int [] now = pq.poll();
                    sum -= now[1];
                }
            }

            answer = Math.max(sum, answer);
        }
        
        System.out.println(answer);
    }

    static class Node{
        int p;
        int cost;
        Node(int p, int cost){
            this.p = p;
            this.cost = cost;
        }
    }
}
