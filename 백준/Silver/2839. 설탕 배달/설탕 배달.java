import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int ans = 0;
		while(n> 0) {
			if(n %5 == 0) {
				ans += n/5;
				n=0;
				break;
			}
			else n-=3;
			ans++;
		}
		System.out.println(n == 0 ? ans : -1);
	}
}
