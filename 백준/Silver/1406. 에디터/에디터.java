
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        while(n-- > 0){
            String t = br.readLine();
            char cmd = t.charAt(0);

            if(cmd == 'L' && !left.isEmpty()) {
                right.push(left.pop());
            }
            else if(cmd == 'D' && !right.isEmpty()) {
                left.push(right.pop());
            }
            else if(cmd == 'B' && !left.isEmpty()){
                left.pop();
            }
            else if(cmd == 'P'){
                char c = t.charAt(2);
                left.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!left.isEmpty()){
            sb.append(left.pop());
        }
        sb.reverse();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb.toString());

    }
}