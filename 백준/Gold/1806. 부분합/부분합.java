import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int [] arr = new int[n+1];
        int ans = n+1;
        for (int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] >= s){
                System.out.println(1);
                return;
            }
        }

        int left = 0;
        int right = 1;
        long sum = arr[0];
        while(right <= n){
            if(sum >= s){
                ans = Math.min(ans, right-left);
                sum -= arr[left++];
            }
            else sum += arr[right++];
        }
        System.out.println(ans != n+1 ? ans : 0);
    }
}
