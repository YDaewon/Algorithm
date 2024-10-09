import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int n, k;
	static String [] str;
	static boolean [] visit;
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		k = Integer.parseInt(sc.nextLine());
		str = new String[n];
		visit = new boolean[n];
		for(int i = 0; i < n ; i++) {
			str[i] = sc.nextLine();
		}
		sol(0, "");
		System.out.println(set.size());
	}
	
	static void sol(int d, String t) {
		if(d == k) {
			set.add(t);
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				sol(d+1, t + str[i]);
				visit[i] = false;
			}
		}
	}
}
