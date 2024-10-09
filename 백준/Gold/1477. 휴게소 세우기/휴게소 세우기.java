import java.util.*;

public class Main {
    static int n, m,l;
    static int []arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        arr = new int [n+2];
        arr[0]=0;
        arr[n+1] = l;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int start = 1;
        int end = l-1;
        while (start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            for(int i = 1; i <= n + 1; i++){
                sum += (arr[i] - arr[i-1] - 1) / mid;
            }
            if(sum > m) start = mid+1;
            else end = mid-1;
        }
        System.out.println(start);
    }
}
