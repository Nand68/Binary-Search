class Solution {
    public int findKthPositive(int[] vec, int k) {
        int low = 0;
        int n = vec.length;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = vec[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
    
}
