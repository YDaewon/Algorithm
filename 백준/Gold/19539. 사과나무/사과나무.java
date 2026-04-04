import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int [n];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        if(sum % 3 != 0) {
            System.out.println("NO");
            return;
        }

        int cnt = sum / 3;

        int two = cnt;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while(two > 0 && arr[i] >= 2){
                arr[i] -= 2;
                two--;
            }
            ans += arr[i];
        }

        System.out.println((ans == cnt ? "YES" : "NO"));
        

    }


}
