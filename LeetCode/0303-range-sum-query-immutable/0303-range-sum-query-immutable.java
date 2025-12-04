// class NumArray {
//     int [] arr;

//     public NumArray(int[] nums) {
//         arr = nums;
//     }
    
//     public int sumRange(int left, int right) {
//         int result = 0;
//         for(int i = left; i <= right; i++) result += arr[i];
//         return result;
//     }
// }

class NumArray {
    int [] arr;

    public NumArray(int[] nums) {
        arr = nums;
        for(int i = 1; i < nums.length; i++) arr[i] += arr[i-1];
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return arr[right];
        else return arr[right] - arr[left-1];
    }
}