import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test = 1; test <= T; test++) {
			int n = Integer.parseInt(sc.nextLine());
			Stack<Character> s= new Stack<>();
			char [] str = sc.nextLine().toCharArray();
			boolean ans = true;
			if(n %2 != 0) ans = false;
			else {
				for(char a : str) {
					 if(a == '(' || a == '[' || a == '{' || a == '<') {
						 s.push(a);
					 }
					 else{
						 if(!s.isEmpty()) {	 
							 char t = s.peek();
							 if(t == '(' && a == ')') s.pop();
							 else if(t == '[' && a == ']') s.pop();
							 else if(t == '{' && a == '}') s.pop();
							 else if(t == '<' && a == '>') s.pop();
							 else {
								 ans = false;
								 break;
							 }
						 }
					 }
				}
			}
            if(ans) System.out.println("#" + test + " 1");
            else System.out.println("#" + test + " 0");
		}
	}
}
