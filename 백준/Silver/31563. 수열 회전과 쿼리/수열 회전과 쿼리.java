import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            arr[i] += arr[i-1];
        }
        int start_pointer = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(q != 0){
            st = new StringTokenizer(br.readLine());
            long[] str = new long[st.countTokens()];
            for (int i = 0; i < str.length; i++) {
                str[i] = Long.parseLong(st.nextToken());
            }
            if(str[0]== 1){
                start_pointer += n - str[1];
                start_pointer %= n;
            }
            else if (str[0] == 2){
                start_pointer += str[1];
                start_pointer %= n;
            }
            else {
                long sum = 0;
                int s = (start_pointer + (int)str[1] - 1) % n + 1;
                int e = (start_pointer + (int)str[2] - 1) % n + 1;
                if (s <= e) {
                    sum = arr[e ] - arr[s-1];
                }
                else {
                    sum = arr[n] - arr[s-1] + arr[e];
                }
                bw.write(sum + "\n");
            }
            q--;
        }
        bw.flush();
    }
}