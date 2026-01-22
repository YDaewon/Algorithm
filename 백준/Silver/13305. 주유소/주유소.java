import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] road = new int [n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        int [] city = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int price = city[0];
        for (int i = 1; i < n; i++) {
            if(price > city[i]){
                sum += (long) price * road[i-1];
            }
            else{
                int j = i;
                int temp = 0;
                while(price < city[j]){
                    temp += road[j-1];
                    j++;
                }
                temp += road[j-1];
                // System.out.println("구간: " + (i-1) + " ~ " + j + " 합: " + temp);
                sum += (long) temp * price;
                i = j;
            }
            // System.out.println("now: " + i + ", sum: " + sum);
            price = city[i];
        }

        System.out.println(sum);
    }
}