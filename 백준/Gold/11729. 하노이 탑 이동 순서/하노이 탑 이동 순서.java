import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sb.append((int)(Math.pow(2, n) - 1) + "\n");
        hanoi(n, 1,2,3);
        System.out.print(sb.toString());
    }

    static void hanoi(int d, int one, int two, int three){
        if(d == 1){
            sb.append(one + " " + three + "\n");
            return;
        }

        hanoi(d-1, one, three, two);
        sb.append(one + " " + three + "\n");
        hanoi(d-1, two, one, three);
    }
}
