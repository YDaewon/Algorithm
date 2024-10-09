import java.util.Scanner;

public class Main {
    static boolean [] visit;
    static String str;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();
        visit = new boolean[str.length()];
        pnt(0, str.length()-1);
    }

    static void pnt(int l, int r){
        if(l > r) return;
        int idx = l;
        for (int i = l; i <=r ; i++) {
            if(str.charAt(i) < str.charAt(idx)){
                idx = i;
            }
        }
        visit[idx] = true;
        for (int i = 0; i < str.length() ; i++) {
            if(visit[i]) System.out.print(str.charAt(i));
        }
        System.out.println();

        pnt(idx+1, r);
        pnt(l, idx-1);
    }
}
