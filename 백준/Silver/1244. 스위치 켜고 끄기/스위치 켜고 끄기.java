 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());            
        }
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if(sex == 1) change_boy(idx);
            else change_girl(idx);
        }

        for (int i = 1; i <= n; i+= 20) {
            for (int j = i; j < Math.min(i+20, n + 1); j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }


    static void change_boy(int idx){
        for (int i = idx; i <= n; i += idx) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    static void change_girl(int idx){
        arr[idx] = arr[idx] == 0 ? 1 : 0;
        for (int i = 1; i <= n; i++) {
            int left = idx - i;
            int right = idx + i;

            if(left < 1 || right > n) break;

            if(arr[left] == arr[right]){
                arr[left] = arr[left] == 0 ? 1 : 0;
                arr[right] = arr[left];
            }
            else break;
        }
    }
}
