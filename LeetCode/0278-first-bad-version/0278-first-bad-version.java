/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // if isBadVersion(mid) is bad, post value is bad (right)
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;

        int result = 0;
        while(left <= right){
            int mid = (int)((left + right) / 2);
            //System.out.println(left + ", " + right);
            if(!isBadVersion(mid)){ // mid is not bad
                left = mid + 1;
            }
            else { // mid is bad
                right = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}