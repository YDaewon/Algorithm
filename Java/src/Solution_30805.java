import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_30805 {
    static List<Integer> ans = new ArrayList<>();
    static List<Integer> arr1 = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            arr2.add(sc.nextInt());
        }
        /*
        int idx = 0;
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = idx; j < m; j++) {
                if (arr1[i] == arr2[j]) {
                    //System.out.print(arr1[i] + " ");
                    list[size++] = arr1[i];
                    idx = j+1;
                }
            }
        }
        if(size == 0) System.out.println(0);
        else{
            get_ans(list, size, 0);
            System.out.println(ans.size());
            for(int i : ans) System.out.print(i + " ");
        }*/
        sol();
        if(ans.size() == 0) System.out.println(0);
        else{
            System.out.println(ans.size());
            for(int i : ans) System.out.print(i + " ");
        }
    }

    static void sol(){
        boolean flag = false;
        int max1 = 0, max2 = 0, midx1 = 0, midx2 = 0;
        while(true){
            while(true) {
                if (arr1.size() == 0 || arr2.size() == 0) {
                    flag = true;
                    break;
                }
                //System.out.print(arr1.size() + " " + arr2.size() + " ");
                max1 = 0; max2 = 0;
                for (int i = 0; i < arr1.size(); i++) {
                    if (max1 < arr1.get(i)) {
                        max1 = arr1.get(i);
                        midx1 = i;
                    }
                }
                for (int i = 0; i < arr2.size(); i++) {
                    if (max2 < arr2.get(i)) {
                        max2 = arr2.get(i);
                        midx2 = i;
                    }
                }
                if (max1 == max2) break;
                else if(max1 > max2) arr1.remove(midx1);
                else arr2.remove(midx2);
            }
            if(flag) break;
            ans.add(max1);
            for (int i = 0; i <= midx1; i++) arr1.remove(0);
            for (int i = 0; i <= midx2; i++) arr2.remove(0);
            System.out.println("Add: " + max1);
        }

    }

    static void get_ans(int [] arr, int size, int idx){
        if(size <= idx){
            return;
        }
        int max = arr[idx], max_idx = idx;
        for (int i = idx; i < size; i++) {
            if(arr[i] > max){
                max = arr[i];
                max_idx = i;
            }
        }
        ans.add(max);
        get_ans(arr, size, max_idx+1);
    }
}
