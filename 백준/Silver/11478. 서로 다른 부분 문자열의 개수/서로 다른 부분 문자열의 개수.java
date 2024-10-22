import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static char [] str;
	static HashSet<String> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine().toCharArray();
		set = new HashSet<>();
		for(int i = 0; i < str.length; i++) {
			String s = "";
			for(int j = i; j < str.length; j++) {
				s += str[j];
				set.add(s);
			}
		}
		System.out.println(set.size());
	}
}
