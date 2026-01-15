import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Stack<Integer> s = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!s.isEmpty() && s.peek() > y){
                if(s.peek() != 0) cnt++;
                s.pop();
                // System.out.println("cnt++");
            }
            if(s.isEmpty() || s.peek() != y) s.push(y);
            // System.out.println("stack size: " + s.size() + ", now top: " + (s.isEmpty() ? "x" : s.peek()));
        }
        while(!s.isEmpty()){
            if(s.peek() != 0) cnt++;
            s.pop();
        }
        System.out.println(cnt);
    }

}