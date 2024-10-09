/*
총나올 수 있는건 10자리
A > B
if(A가 6자리면? -> B는 4자리 가능)
if(A가 5자리면? -> B도 5자리 가능)


만약 5자리, 5자리라면?
A의 맨 앞은 9
=> B는 90000미만의 자연수임
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = true;
        for(int i = 1; i <= 13073; i++){
            boolean [] arr= new boolean[10];
            if(n-i > 0 && check(i, arr) && check(n-i, arr)){
                System.out.println(n- i + " + " + i);
                return;
            }
        }
        System.out.println(-1);
    }
    static boolean check(int x, boolean [] arr){
       while(x > 0){
           if(arr[x%10]){
               return false;
           }
           arr[x%10] = true;
           x /= 10;
       }
       return true;
    }
}
