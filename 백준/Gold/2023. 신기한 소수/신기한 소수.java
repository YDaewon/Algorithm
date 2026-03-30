 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        go(0, 0);
        System.out.println(sb);
    }

    static void go(int d, int num){
        if(d == n){
            sb.append(num + "\n");
            return;
        }

        int sup = num * 10;
        for (int i = 1; i <= 9; i++) {
            int nxt = sup + i;
            if(isPrime(nxt)) go(d+1, sup + i);
        }
    }

    private static boolean isPrime(int nxt) {
        if(nxt == 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(nxt); i++) {
            if(nxt % i == 0) return false;
        }
        return true;
    }
}
