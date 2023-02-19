package LeetCode.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param left
     * @param right
     * @param num
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int num) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (num == arr[mid]) {
            return mid;
        } else if (num < arr[mid]) {
            return binarySearch(arr, left, mid - 1, num);
        } else {
            return binarySearch(arr, mid + 1, right, num);
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int num) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        if (num == arr[mid]) {
            List<Integer> list = new ArrayList<>();
            list.add(mid);
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == num) {
                list.add(temp);
                temp--;
            }
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == num) {
                list.add(temp);
                temp++;
            }
            return list;
        } else if (num < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, num);
        } else {
            return binarySearch2(arr, mid + 1, right, num);
        }
    }
}
