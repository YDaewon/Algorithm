import java.io.*;
import java.util.*;


public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> s = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!s.isEmpty() && s.peek() > y) {
                s.pop();
                answer++;
            }
            if(y == 0) continue;
            if(!s.isEmpty() && s.peek() == y) continue;
            s.add(y);
        }
        System.out.println(answer + s.size());

    }

}
