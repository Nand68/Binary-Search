class Solution {
    public int minDays(int[] arr, int m, int k) {
        int n = arr.length;
        long val = (long) m * k;
        if ( val > n){
            return -1;
        }
        int low = Integer.MAX_VALUE;;
        int high = Integer.MIN_VALUE;
        for ( int i = 0; i < n; i++){
            if ( arr[i] > high){
                high = arr[i];
            }
            if ( arr[i] < low){
                low = arr[i];
            }
        }

        while ( low <= high){
            int mid = (low + high)/2;
            if (check(arr,mid,m,k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return low;

    }
    public boolean check(int[] arr, int mid, int m,int k){
        int count = 0;
        int b = 0;
        for ( int i = 0; i < arr.length; i++){
            if ( arr[i] <= mid){
                count++;
            }
            else{
                b += (count / k);
                count = 0;
            }
        }
        b += count / k;
        
        return b >= m;
    }
}
