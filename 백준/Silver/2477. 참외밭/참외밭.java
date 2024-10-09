import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kcal = sc.nextInt();
        int [] arr = new int[6];
        int [] arr2 = new int[6];
        for(int i = 0; i < 6; i++) {
            int d = sc.nextInt();
            int length = sc.nextInt();
            arr[i] = d;
            arr2[i] = length;
        }
        int ans = 0;
        for(int i = 0; i < 6; i++){
            if(arr[i] == arr[(i+2)%6] && arr[(i+1)%6] == arr[(i+3)%6] ){
                ans = (arr2[(i+4)%6] * arr2[(i+5)%6]) - (arr2[(i+1)%6] * arr2[(i+2)%6]);
                break;
            }
        }
        System.out.println(ans * kcal);
    }
}