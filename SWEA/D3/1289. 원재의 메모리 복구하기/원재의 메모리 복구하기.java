import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            String str;
            str = sc.next();
            boolean [] arr = new boolean[50];
            int i = 0;
            for(String s : str.split("")) {
                if(s.equals("1")) arr[i] = true;
                else arr[i] = false;
                i++;
            }
            int cnt = 0;
            for(int k = 0; k < i;k++) {
                if(arr[k] == false) continue; 
                for(int j =k;j<i;j++) {
                    arr[j] = !arr[j];
                }
                cnt++;
            }
            System.out.println("#"+test_case+" " + cnt);
        }
    }
}