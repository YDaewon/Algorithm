import java.util.Scanner;

public class Solutin_10819 {
    static int [] seq;
    static int n, ans;
    static int [] num;
    static boolean [] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        num = new int [n];
        seq = new int[n];
        visit=new boolean[n];
        for (int i = 0; i < n; i++) num[i] = sc.nextInt();
        sol(0);
        System.out.println(ans);
    }

    static void sol(int d){
        if(d == n){
            int cal = 0;
            for (int i = 1; i < n; i++) {
                cal += Math.abs(num[seq[i-1]] - num[seq[i]]);
            }
            ans = Math.max(ans, cal);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                visit[i] = true;
                seq[d] = i;
                sol(d+1);
                visit[i] = false;
            }
        }
    }
}
