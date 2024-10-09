import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		List<Character> ans = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c =='a' || c=='e'|| c=='i' || c=='o' || c=='u') {
				ans.add(c);
				i++;i++;
				continue;
			}
			ans.add(c);
		}
		for(char c : ans) System.out.print(c);
	}
}
