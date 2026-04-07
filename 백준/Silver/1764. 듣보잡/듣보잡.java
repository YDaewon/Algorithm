import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<String> a = new ArrayList<>();
        Set<String> b = new HashSet<>();

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n + m; i++) {
            String t = br.readLine();
            a.add(t);
            b.add(t);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if(e.getValue() == 2){
                cnt++;
                sb.append(e.getKey()).append("\n");
            }
        }


        System.out.println(cnt);
        System.out.println(sb);

    }
}
