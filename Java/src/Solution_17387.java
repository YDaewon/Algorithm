import java.util.Scanner;

public class Solution_17387 {

    public static void main(String[] args) {
        Scanner nc = new Scanner(System.in);
        Pair a = new Pair(nc.nextLong(), nc.nextLong());
        Pair b = new Pair(nc.nextLong(), nc.nextLong());
        Pair c = new Pair(nc.nextLong(), nc.nextLong());
        Pair d = new Pair(nc.nextLong(), nc.nextLong());

        int ans = 0;
        boolean flag = false;
        if(CCW(a,b,c) * CCW(a,b,d) == 0 && CCW(c,d,a) * CCW(c,d,b) == 0){
            flag = true;
            if(compare(a,b,c,d)) {
                ans = 1;
            }
        }
        if(CCW(a,b,c) * CCW(a,b,d) <= 0 && CCW(c,d,a) * CCW(c,d,b) <= 0 && flag == false) ans = 1;
        System.out.println(ans);
    }

    public static int CCW(Pair a, Pair b, Pair c){
        long t = (b.x - a.x) * (c.y-a.y) - (c.x-a.x) * (b.y-a.y);
        if(t > 0) return 1;
        else if(t == 0) return 0;
        else return -1;
    }

    public static boolean compare(Pair a, Pair b, Pair c, Pair d){
        boolean c1 = Math.min(a.x, b.x) <= Math.max(c.x, d.x);
        boolean c2 = Math.max(a.x, b.x) >= Math.min(c.x, d.x);
        boolean c3 = Math.min(a.y, b.y) <= Math.max(c.y, d.y);
        boolean c4 = Math.max(a.y, b.y) >= Math.min(c.y, d.y);

        return c1 && c2 && c3 && c4;
    }

}

class Pair{
    long y, x;
    public Pair(long y, long x){
        this.y = y;
        this.x = x;
    }
}
