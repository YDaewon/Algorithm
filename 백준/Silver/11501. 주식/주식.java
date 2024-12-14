import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int [] arr = new int [n];
            String [] num = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(num[j]);
            }
            long ans = 0;
            int sell = arr[n-1];
            for (int j = n-2; j >= 0; j--) {
                if(sell >= arr[j]){
                    ans += sell - arr[j];
                }
                else{
                    sell = arr[j];
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}