class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n > threshold) return -1;
        int low = 1;
        int high = nums[n - 1];
        while ( low <= high){
            int mid = ( low + high ) / 2;
            if(check(nums,mid,threshold)){
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }
        }
        return low;

    }
    public boolean check(int[] nums,int mid, int threshold){
        long sum = 0;
        for ( int i = 0; i < nums.length; i++){

            sum += Math.ceil( (double)nums[i] / (double) mid);
        }
        if ( sum > threshold){
            return false;
        }
        return true;
    }
}
