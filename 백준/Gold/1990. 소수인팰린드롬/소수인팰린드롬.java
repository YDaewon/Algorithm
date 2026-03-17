 import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> prime = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Math.min(Integer.parseInt(st.nextToken()), 10_000_000);

        for (int i = a; i <= b; i++) {
            if(isPalindrom(i) && isPrime(i)) prime.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int n : prime) sb.append(n).append("\n");

        sb.append(-1);

        System.out.println(sb);
        
    } 

    private static boolean isPalindrom(int num) {
        char [] a = String.valueOf(num).toCharArray();
        for(int i = 0; i < a.length / 2; i++){
            if(a[i] != a[a.length - 1 - i]) return false;
        }
        return true;
    }

    static boolean isPrime(int num){
        for(int i = 2; i < (int)Math.sqrt(num) + 1; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}
