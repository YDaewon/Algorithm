import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for(int i = 0; i <8; i++) if((n & (1<<i)) != 0) ans++;
		System.out.println(ans);
	}
}
