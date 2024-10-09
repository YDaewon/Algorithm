import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int [n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int f = 0;
        int e = 0;
        int sum = 0;
        int ans = 0;
        while(e <= n){
            if(sum < m) sum += arr[e++];
            else sum -= arr[f++];
            
            if(sum == m) ans++;
        }
        System.out.println(ans);
    }
}
