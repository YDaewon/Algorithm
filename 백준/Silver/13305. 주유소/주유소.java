import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] road = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        int [] city = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        int price = city[0];
        long sum = (long) price * road[0];
        for (int i = 1; i < n; i++) {
            if(price > city[i]){
                price = city[i];
            }
            sum += (long) price * road[i];
            // System.out.println("now sum: " + sum);
        }

        System.out.println(sum);
    }
}