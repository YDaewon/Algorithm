//과일의 종류는 총 9개
// 막대 양쪽 진입 가능(중간거 빼먹기 불가능)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_30004 {
    public static boolean check(int [] num){
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if(num[i] != 0) cnt++;
            if(cnt > 2) return true; // 종류가 2개 이상
        }
        return false; // 종류가 2개 이하
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[200000];
        //br.readline(): 한 라인을 String으로 받음
        StringTokenizer st = new StringTokenizer(br.readLine());
            //StringTokenizer: 받은 String을 " "단위로 구분해서 자름
        for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, ans = 0;
        int [] num = new int[10];
        while(s < n){
            while(e < n){
                num[arr[e]]++; // e번째 과일 있다고 체크
                e++; // 다음 과일로 포인터 이동
                if(check(num)){ // 만약 과일이 2개 이상이면
                    e--; //마지막으로 본 과일로 포인터 이동
                    num[arr[e]]--;
                    break;
                }
            }
            ans = Math.max(ans, e - s); // s ~ e까지의 길이: 2종류로 이루어진 과일 종류 길이
            num[arr[s]]--;
            s++; // 다음 과일부터 계산

            //System.out.println("s: " + s + ", e: " + e);
        }
        System.out.println(ans);
    }
}