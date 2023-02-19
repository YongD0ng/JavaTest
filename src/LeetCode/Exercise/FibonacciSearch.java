package LeetCode.Exercise;

import java.util.Arrays;

public class FibonacciSearch {
    private static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};
        System.out.println(fibonacciSearch(arr, 10));
    }

    /**
     * 斐波那契查找
     *
     * @param arr
     * @param findVal
     * @return
     */
    public static int fibonacciSearch(int[] arr, int findVal) {
        int low = 0, high = arr.length - 1, k = 0, mid = 0;
        int[] fib = fib();
        while (high > fib[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + fib[k-1] - 1;
            if (findVal < arr[mid]) {
                high = mid - 1;
                k--;
            } else if (findVal > arr[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }

    /**
     * 获取斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] fib = new int[MAX_SIZE];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
}
