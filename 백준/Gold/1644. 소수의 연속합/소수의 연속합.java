import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean [] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new boolean[n+1];
        List<Integer> prime = new ArrayList<>();
        Arrays.fill(arr, true);
        arr[1] = false;
        for (int i = 2; i <= n; i++) {
            if(arr[i]){
                prime.add(i);
                //System.out.print(i + " ");
                for (int j = i*2; j <= n; j+=i) arr[j] = false;
            }
        }
        //System.out.println();
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        while(true){
            if(sum >= n) sum-= prime.get(left++);
            else if(right == prime.size()) break;
            else {
                sum += prime.get(right++);
            }
            if(sum == n) {
                //System.out.println(left + ", " + right);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
