 import java.io.*;
import java.util.*;

public class Main {
    static int n, l;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());

            if(left.size() == right.size()) left.add(t);
            else right.add(t);

            if(!right.isEmpty() && (left.peek() > right.peek())) {
                int a = left.poll();
                int b = right.poll();
                left.add(b);
                right.add(a);
            }
            
            sb.append(left.peek() + "\n");
        }

        // System.out.println("left");
        // while(!left.isEmpty()){
        //     System.out.print(left.poll() + " ");
        // }
        // System.out.println();

        // System.out.println("right");
        // while(!right.isEmpty()){
        //     System.out.print(right.poll() + " ");
        // }
        // System.out.println();
        
        System.out.println(sb);


    } 
}
