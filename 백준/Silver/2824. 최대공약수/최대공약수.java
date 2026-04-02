 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> ngcd = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            add_gcd(ngcd, num);
        }

        int m = Integer.parseInt(br.readLine());
        Map<Integer, Integer> mgcd = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            add_gcd(mgcd, num);
        }

        // for(Map.Entry<Integer, Integer> e : ngcd.entrySet()){
        //     System.out.println(e.getKey() + ", " + e.getValue());
        // }
        // System.out.println("================");
        // for(Map.Entry<Integer, Integer> e : mgcd.entrySet()){
        //     System.out.println(e.getKey() + ", " + e.getValue());
        // }
        // System.out.println("================");

        long gcd = 1;
        long MOD = 1_000_000_000;
        boolean flag = false;
        for (int i : ngcd.keySet()) {
            if(mgcd.get(i) == null) continue;

            int cnt = Math.min(ngcd.get(i), mgcd.get(i));

            for (int j = 0; j < cnt; j++) {
                gcd *= i;
                if(gcd >= MOD){
                    flag = true;
                    gcd %= MOD;
                } 
            }
        }
        if(flag) System.out.printf("%09d", gcd);
        else System.out.println(gcd);
    }

    static void add_gcd(Map<Integer,Integer> gcd, int num){
        for (int t = 2; t * t <= num; t++) {
            while (num % t == 0) {
                gcd.put(t, gcd.getOrDefault(t, 0) + 1);
                num /= t;
            }
        }

        if (num > 1) {
            gcd.put(num, gcd.getOrDefault(num, 0) + 1);
        }
    }
}
