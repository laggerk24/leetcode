class Solution {
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        boolean[] prime = new boolean[1001];

        // Precompute prime numbers up to 1000
        for (int i = 2; i <= 1000; i++) {
            prime[i] = isPrime(i);
        }

        // Iterate through each element in the nums array
        for(int i=0;i<nums.length;i++){
            if(i==0 && nums[i] == 1) continue;
            if(nums[i] == 1) return false;
            for(int j=nums[i]-1;j>=2;j--){
                if(prime[j] == true){
                    if(i == 0){
                        nums[i] = nums[i]-j;
                        break; 
                    }
                    else if(nums[i]-j>nums[i-1]){
                        nums[i] = nums[i]-j;
                        break;
                    }
                }
            }
            if(i!= 0 && nums[i]<=nums[i-1]) return false;
        }

        return true;
    }

}