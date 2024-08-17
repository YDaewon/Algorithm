import java.util.Scanner;

public class Solution_2961 {
    static boolean [] select;
    static cook [] c;
    static int n, ans=1000000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = new cook[n];
        select = new boolean[n];
        for (int i = 0; i < n; i++) {
            int sour = sc.nextInt();
            int sweet = sc.nextInt();
            c[i] = new cook(sour, sweet);
        }
        subset(0,1,0);
        System.out.println(ans);
    }

    static boolean check(int d){
        for (int i = 0; i < d; i++) {
            if(select[i]) return true;
        }
        return false;
    }

    static void subset(int d, int sour_all, int sweet_all){
        if(check(d)) {
            //System.out.println("d: " + d + ", sour_all: " + sour_all + ", sweet_all: " + sweet_all);
            ans = Math.min(ans, Math.abs(sour_all - sweet_all));
        }
        if(d >= n) return;
        select[d] = true;
        subset(d+1, sour_all * c[d].sour,sweet_all + c[d].sweet);
        select[d] = false;
        subset(d+1, sour_all, sweet_all);
    }

    static class cook{
        int sour;
        int sweet;
        cook(int sour, int sweet){
            this.sour = sour;
            this.sweet = sweet;
        }
    }
}
