import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] city = new int [n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            city[i]= Integer.parseInt(st.nextToken());
            right = Math.max(city[i], right);
        }

        int m = Integer.parseInt(br.readLine());

        int left = 1;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            int result = calc(city, mid);

            if(result <= m){
                left = mid + 1;
                answer = mid;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

    static int calc(int [] city, int avg){
        int sum = 0;
        for (int i = 0; i < city.length; i++) {
            sum += Math.min(city[i], avg);
        }
        return sum;
    }
}