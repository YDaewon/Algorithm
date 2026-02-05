import java.io.*;
import java.util.*;


public class Main {
    // 남자(1): 자기가 받은 숫자의 배수를 다 변경
    // 여자(2): 좌우 대칭으로 변경( 번호가 중심, 펠린드롬?)
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int p = Integer.parseInt(br.readLine());

        while(p-- > 0){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex == 1){
                for (int i = num; i <= n; i += num) {
                    arr[i] = (arr[i] == 1 ? 0 : 1);
                    // System.out.println("["+i+"] 번 변경");
                }
            }
            else{
                int [] range = findPalindrome(n, arr, num);
                for (int i = range[0]; i <= range[1] ; i++) {
                    arr[i] = (arr[i] == 1 ? 0 : 1);
                    // System.out.println("["+i+"] 번 변경");
                }
            }
        }

        for (int i = 1; i <= n; i += 20) {
            for (int j = i; j < i + 20 && j <= n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    static int [] findPalindrome(int n, int [] arr, int num){
        int [] range = new int [2];
        int start = num;
        int end = num;
        while(start > 1 && end < n){
            if(arr[start - 1] != arr[end + 1]) break;
            start--;
            end++;
        }
        range[0] = start;
        range[1] = end;

        return range;
    }
}
