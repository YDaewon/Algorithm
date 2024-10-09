import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int [] alphabet = new int [26];
        for (int i = 0; i < n; i++) {
            char[] str = sc.nextLine().toCharArray();
            int ten = str.length-1;
            for(char c : str) {
                alphabet[(c - 'A')] += (int)Math.pow(10, ten);
                ten--;
            }
        }
        Arrays.sort(alphabet);
        int num = 9;
        int sum = 0;
        for (int i = 25; i >= 0; i--) {
            if(alphabet[i] != 0 && num > 0){
                sum += alphabet[i] * num--;
            }
        }
        System.out.println(sum);
    }
}
