import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] nums = new int [n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int [] arr = new int [n];
        int now = 0;
        arr[now] = nums[0];

        for (int i = 0; i < n; i++) {
            if(arr[now] < nums[i]){
                arr[++now] = nums[i];
                continue;
            }
            int left = 0;
            int right = now;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            arr[left] = nums[i];
        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
        System.out.println(n - (now+1));

    }
}


// 1 2 5 3 4 7 6
// 4 3 2 5 1