import java.util.Scanner;

public class Main {
	static int [] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int m = 7;
        arr = new int[n+1];
        for(int i = 1; i <= 9; i++) {
        	arr[i] = sc.nextInt();
        }
        combination(0, 1, n, m);
    }
    static int [] visit = new int[10];
    static void combination(int depth, int now, int n, int m){
        if(depth == m){
        	int sum = 0;
            for (int i = 1; i <= n; i++) {
                if(visit[i] == 1){
                    sum += arr[i];
                }
            }
            if(sum == 100) {
                for (int i = 1; i <= n; i++) {
                    if(visit[i] == 1){
                        System.out.println(arr[i]);
                    }
                }
            }
            return;
        }
        for (int i = now; i <= n; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                combination(depth + 1, i, n, m);
                visit[i] = 0;
            }
        }
    }
}
