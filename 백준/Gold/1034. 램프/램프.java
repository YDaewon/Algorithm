 import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int k = Integer.parseInt(br.readLine());

        int answer = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            int zero = 0;
            for (int i = 0; i < m; i++) {
                char c = e.getKey().charAt(i);
                if(c == '0') zero++;
            }

            if(zero <= k && (k - zero) % 2 == 0) answer = Math.max(answer, e.getValue());
        }
        System.out.println(answer);

    }


}
