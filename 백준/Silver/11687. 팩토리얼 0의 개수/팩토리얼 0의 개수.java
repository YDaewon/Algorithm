 import java.io.*;
import java.util.*;

public class Main {
    /*
    1! = 1
    2! = 2
    3! = 6
    4! = 24
    5! = 120
    6! = 720
    7! = 5040
    8! = 40320
    9! = 362880
    10! = 3628800

    10의 배수 = 0 의 개수
    2 x 5
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = m * 5;
        boolean flag = false;
        while(left <= right){
            int mid = (left+ right) / 2;

            int n = 0;
            for (int i = 5; i <= mid; i *= 5) n += mid / i;
            
            if(n >= m) {
                if(n == m) flag = true;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        System.out.println((flag ? left : -1 ));
    }
}
