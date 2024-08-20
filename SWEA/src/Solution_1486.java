import java.util.Scanner;

public class Solution_1486 {
    static int n, b;
    static int[] arr;
    static int ans;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int t = 1; t<= T; t++){
            init();
            subset(0, 0);
            System.out.println("#" + t + " " + ans);
        }
    }

    static void init(){
        n = sc.nextInt();
        b = sc.nextInt();
        ans = Integer.MAX_VALUE;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static void subset(int d, int sum){
        if(sum >= b){
            ans = Math.min(ans, sum-b);
            return;
        }
        if(d == n) return;
        subset(d+1, sum+arr[d]);
        subset(d+1, sum);
    }
}