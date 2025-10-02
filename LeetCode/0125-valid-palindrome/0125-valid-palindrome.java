class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left <= right){
            char a = s.charAt(left);
            char b = s.charAt(right);
            if((a < 'A' || a > 'Z') && (a < 'a' || a > 'z') && (a < '0' || a > '9')){
                left++;
                continue;
            }
            if((b < 'A' || b > 'Z') && (b < 'a' || b > 'z') && (b < '0' || b > '9')){
                right--;
                continue;
            }

            if( a <= 'Z') a = Character.toLowerCase(a);
            if( b <= 'Z') b = Character.toLowerCase(b);
            //System.out.println("a = " + a + ", b = " + b);
            if(a == b){
                left++;
                right--;
            }
            else{
                return false;
            }

        }

        return true;
    }
}