class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while ( i <= j){
            int mid = ( i + j)/2;

            if ( nums[mid] == target) return true;

            if ( nums[i] == nums[mid] && nums[mid] == nums[j]){
                j = j - 1;
                i = i + 1;
                continue;
            }

            if ( nums[mid] >= nums[i]){
                if ( nums[i] <= target && target <= nums[mid]){
                    j = mid - 1;
                }
                else{
                    i = mid + 1;
                }
            }
            else{
                if ( nums[mid] <= target && target <= nums[j]){
                    i = mid + 1;
                }
                else{
                    j = mid - 1;
                }

            }
        }
        return false;
    }
}
