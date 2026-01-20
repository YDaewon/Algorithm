import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.length() < m) continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> {
            int o1 = map.get(a);
            int o2 = map.get(b);

            if(o1 != o2) return o2 - o1;
            else if(a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        StringBuilder sb =new StringBuilder();
        for(String s : list) sb.append(s + "\n");
        System.out.println(sb);

    }

}