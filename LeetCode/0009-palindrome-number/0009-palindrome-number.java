class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        char [] num = String.valueOf(x).toCharArray();
        int len = num.length;
        int mid = len / 2;
        if(len % 2 == 0){
            for(int i = 0; i < mid; i++){
                if(num[mid + i] != num[mid -1 - i]) return false;
            }
        }
        else{
            for(int i = 0; i < mid+1; i++){
                System.out.println(num[mid+i] + " == " + num[mid-i]);
                if(num[mid + i] != num[mid - i]) return false;
            }
        }

        return true;
    }
}