class Solution {
    public boolean isHappy(int n) {
        Set<Integer> num_set = new HashSet<>();
        while(!num_set.contains(n)){
            //System.out.println(n);
            num_set.add(n);
            int sum = 0;

            while(n > 0){
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }

            if(sum == 1) return true;
            n = sum;
        }
        return false;
    }
}