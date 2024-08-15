import java.util.Scanner;

public class Solution_15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        combination(0, 1, n, m);
    }
    static int [] visit = new int[9];
    static void combination(int depth, int now, int n, int m){
        if(depth == m){
            for (int i = 1; i <= n; i++) {
                if(visit[i] == 1){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
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
