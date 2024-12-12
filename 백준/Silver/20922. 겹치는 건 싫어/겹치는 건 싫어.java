import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] arr = new int [N];
        int [] cnt = new int [100001];
        int start=0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        while(start <= end && end < N && start < N) {
            if(cnt[arr[end]] < K){
                cnt[arr[end]]++;
                end++;
            }
            else{
                cnt[arr[start]]--;
                start++;
            }
            max = Math.max(max, end - start);
        }
        System.out.println(max);


    }
}