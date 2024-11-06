import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	static int [] arr;
	static int n;
	static TreeSet<Integer> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int [n];
		set = new TreeSet<>();
		for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
		subset(0,0);
		
		int ans = 0;
		for(int i : set) {
			//System.out.println(i);
			if(i != ans) {
				System.out.println(ans);
				return;
			}
			ans++;
		}
		System.out.println(ans);
	}
	private static void subset(int d, int sum) {
		if(d == n) {
			set.add(sum);
			return;
		}
		subset(d+1, sum);
		subset(d+1, sum+arr[d]);
	}
}
