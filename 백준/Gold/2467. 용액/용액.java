import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int [] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans1=0, ans2=0;
        int val = Integer.MAX_VALUE;
        int start = 0;
        int end = n-1;
        while(start < end){
            int ans = arr[start] + arr[end];
            if(Math.abs(ans) < val){
                ans1 = start;
                ans2 = end;
                val = Math.abs(ans);
            }
            if(ans < 0) start++;
            else end--;
        }
        System.out.println(arr[ans1] + " " + arr[ans2]);
    }
}
