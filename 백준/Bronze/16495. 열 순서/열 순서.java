import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        String t = sc.nextLine();
        char [] str = t.toCharArray();
        for (int i = 0; i < str.length; i++) {
            long pow = (long)Math.pow(26, str.length-1-i);
            ans += (str[i] - 'A' + 1) * pow;
        }
        System.out.println(ans);
    }
}
