 import java.io.*;
import java.util.*;

public class Main {
    /*
    m개 숫자 포함하는 n개 숫자
    C(m, 0) * 10^n 경우의 수
    - m개 숫자 포함 안하는 경우
     - C(m, 1) * 9 ^ n + C(m,2) * 8 ^ n ... C(m, m) * (10 - m)^n
    
     => i 가 짝수면 +, 홀수면 - 1



    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(m > 0)br.readLine();

        long ans = 0;
        for (int i = 0; i <= m; i++) {
            long temp = (long) (combination(m, i) * Math.pow(10 - i, n));
            if(i % 2 == 0) ans += temp;
            else ans -= temp;

            //System.out.println(ans);
        }

        System.out.println(ans);
    }

    private static double combination(int m, int i) {
       long t = 1;
       long d = 1;
       for (int j = 0; j < i; j++) {
            t *= m - j;
            d *= j + 1;
       }

       return t / d;
    }

}
