class Solution {
    public int mySqrt(int x) {
        //return (int)Math.floor(Math.sqrt(x));

        if (x < 2) return x;

        int left = 2;
        int right = x;
        while(left <= right){
            int mid = left + (right - left)/2;
            long temp = (long)mid * mid;
            if(temp < x) left = mid + 1;
            else if (temp > x) right = mid - 1;
            else return mid;
        }

        return right;
    }
}