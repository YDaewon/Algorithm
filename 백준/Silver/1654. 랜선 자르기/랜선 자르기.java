import java.util.Scanner;

public class Main {
    static int n, k;
    static int [] len;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        len = new int [n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            len[i] = sc.nextInt();
            max += len[i];
        }
        long start = 1;
        long end = max / k;
        while(start <= end){
            long mid = (start + end) / 2;
            if(cut(mid) >= k) {
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        System.out.println(end);
    }

    static long cut(long c){
        int sum = 0;
        for (int i = 0; i < n; i++) sum += len[i] / c;
        return sum;
    }
}
