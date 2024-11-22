class Solution {
    public int shipWithinDays(int[] arr, int m) {
        int low =  Integer.MIN_VALUE;
        int high = 0;
        for ( int i = 0; i < arr.length; i++){
            high += arr[i];
            low = Math.max(low,arr[i]);
        }
        while ( low <= high){
            int mid = (low + high) / 2;
            if(check(arr,mid,m)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }



    public boolean check(int[] arr,int mid,int m){
        int count = 0;
        int day = 1;
        int i = 0;
        while ( i < arr.length){
            if ( count + arr[i] <= mid){
                count += arr[i];
            }else{
                day++;
                count = arr[i];
            }
            i++;
        }
        if ( day <= m){
            return true;
        }
        return false;
    }
}
