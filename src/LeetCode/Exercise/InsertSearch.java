package LeetCode.Exercise;

public class InsertSearch {
    public static void main(String[] args) {

    }

    /**
     * 差值查找
     *
     * @param arr
     * @param left
     * @param right
     * @param num
     * @return
     */
    public static int insertSearch(int[] arr, int left, int right, int num) {
        if (left > right || num < arr[0] || num > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (num - arr[left]) / (arr[right] - arr[left]) * (right - left);
        if (num < arr[mid]) {
            return insertSearch(arr, left, mid - 1, num);
        } else if (num > arr[mid]) {
            return insertSearch(arr, mid + 1, right, num);
        } else {
            return mid;
        }
    }
}
