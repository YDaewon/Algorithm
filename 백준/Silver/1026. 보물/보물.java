import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr1 = new int[n];
        int [] arr2 = new int[n];
        for(int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        for(int i = 0; i < n; i++) arr2[i] = sc.nextInt();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr1[i] * arr2[n-1-i];
        }
        System.out.println(sum);
    }
}
