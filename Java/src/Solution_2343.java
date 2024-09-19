import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2343 {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int end = 0;
        int start = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            start = Math.max(start, arr[i]);
        }

        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = calc(mid);
            //System.out.println("w: " + mid + ", cnt: " + cnt);
            if(cnt > m){ // m개보다 많은 cd 필요= 모자람
                start = mid+1;
            }
            else{ // m개안으로 충분히 가능 = 용량 줄이기
                end = mid-1;
            }
        }
        System.out.println(start);
    }

    static int calc(int w){
        int cnt = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if(sum + arr[i] > w){
                cnt++;
                sum = 0;
            }
            sum += arr[i];
        }
        return cnt;
    }
}
