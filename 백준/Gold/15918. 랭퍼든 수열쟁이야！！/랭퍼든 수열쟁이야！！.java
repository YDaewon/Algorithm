import java.io.*;
import java.util.*;

public class Main {
    static int n, x, y;
    static int num;
    static int [] arr;
    static boolean [] visit;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        num = y - x - 1;

        arr = new int [2*n + 1];
        visit = new boolean[n+1];
        arr[x] = arr[y] = num;
        visit[num] = true;
        go(1, 1, 2);

        System.out.println(ans);
    }


    static void go(int d, int idx, int cnt){
        if(cnt >= 2 * n){
            ans++;
            return;
        }
        else if(idx > 2 * n){
            return;
        }

        // for(int i : arr){
        //     System.out.print(i + " ");
        // }
        // System.out.println();

        if(arr[idx] == 0){
            for (int i = 1; i <= n; i++) {
                if(visit[i]) continue;
                if(idx + i + 1 <= 2 * n && arr[idx+i+1] == 0){
                    arr[idx] = i;
                    arr[idx + i + 1] = i;
                    visit[i] = true;
                    go(d+1, idx+1, cnt+2);
                    visit[i] = false;
                    arr[idx + i + 1] = 0;
                    arr[idx] = 0;
                }
            }
        }
        else{
            go(d, idx+1, cnt);
        }
    }
}
