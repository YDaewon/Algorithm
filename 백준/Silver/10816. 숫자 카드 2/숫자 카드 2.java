import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int [] arr;
    public static void main(String[] args) {
        n = sc.nextInt();
        arr = new int [n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        while(m-- != 0){
            int t = sc.nextInt();
            int first = lower(t);
            int second = upper(t);
            sb.append((second - first) + " ");
        }
        System.out.println(sb);
    }
    static int lower(int t){
        int s = 0;
        int e = n;
        int mid = 0;
        while(s < e){
            mid = (s + e) /2;
            if(arr[mid] >= t) e = mid;
            else s = mid+1;
        }
        return s;
    }

    static int upper(int t){
        int s = 0;
        int e = n;
        int mid = 0;
        while(s < e){
            mid = (s + e) /2;
            if(arr[mid] > t) e = mid;
            else s = mid+1;
        }
        return s;
    }
}
