import java.util.Scanner;

public class Solution_2023 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prime = {2,3,5,7};
        for(int a : prime) sol(a, n-1);
        System.out.println(sb);
    }

    static void sol(int cur, int n){
        if(n == 0 && check(cur)) sb.append(cur + "\n");
        for (int i = 1; i < 10; i++) {
            int t = cur * 10 + i;
            if(check(t)) sol(t, n-1);
        }
    }

    static boolean check(int num){
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}

