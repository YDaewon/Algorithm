class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int idx = len - 1;
        digits[idx] += 1;
        while(digits[idx] == 10 && idx >= 0){
            digits[idx--] = 0;
            if(idx < 0){
                int [] temp = new int[len + 1];
                temp[0] = 1;
                for(int i = 0; i < len; i++){
                    temp[i+1] = digits[i];
                }
                return temp;
            }
            digits[idx] += 1;
        }
        return digits;
    }
}