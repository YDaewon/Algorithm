import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        char [] str = t.toCharArray();
        int left = 0, right = 0;
        for (int i = 0; i < str.length; i++) {
            if((str[i] >= 'a' && str[i] <= 'g') || (str[i] >= 'q' && str[i] <= 'z' && str[i] != 'u')){
                left++;
            }
            else if((str[i] >= 'h' && str[i] <= 'p') || str[i] == 'u'){
                right++;
            }
            else{
                if((str[i] >= 'A' && str[i] <= 'G') || (str[i] >= 'Q' && str[i] <= 'Z' && str[i] != 'U')){
                    left++;
                }
                else if((str[i] >= 'H' && str[i] <= 'P') || str[i] == 'U'){
                    right++;
                }
                if(left > right) right++;
                else left++;
            }
        }
        System.out.println(left + " " + right);
    }
}
