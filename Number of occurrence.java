
class Solution {
    int countFreq(int[] arr, int target) {
    int first = findFirstOccurrence(arr, target);
    if (first == -1) return 0; // Target not found
    int last = findLastOccurrence(arr, target);
    return last - first + 1; // Total count of target
}

int findFirstOccurrence(int[] arr, int target) {
    int low = 0, high = arr.length - 1, result = -1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            result = mid;
            high = mid - 1; // Continue searching in the left half
        } else if (arr[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return result;
}

int findLastOccurrence(int[] arr, int target) {
    int low = 0, high = arr.length - 1, result = -1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            result = mid;
            low = mid + 1; // Continue searching in the right half
        } else if (arr[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return result;
}

}
