import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [] arr = new int [n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            if(a == 1){
                arr[b] = c;
            }
            else if(a == 2){
                for (int j = b; j <= c; j++) {
                    arr[j] = (arr[j] == 1 ? 0 : 1);
                }
            }
            else if(a == 3){
                for (int j = b; j <= c; j++) {
                    arr[j] = 0;
                }
            }
            else{
                for (int j = b; j <= c; j++) {
                    arr[j] = 1;
                }
            }
        }
        
        for (int x = 1; x <= n; x++) {
            System.out.print(arr[x] + " ");
        }
        System.out.println();

    }
}
