import java.sql.Time;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author dy
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {6, 2, 1, 7, 5};
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        heapSort(arr);
//        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
//        quickSort(arr, 0, arr.length - 1);

 /*       int[] arr1 = {53,3,542,748,14,214};
        radixSort(arr1);
        System.out.println(Arrays.toString(arr1));*/

//        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
//        System.out.println(longestPalindrome("babad"));

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("time = " + Calendar.getInstance().toString());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        Thread.sleep(1000 * 1000);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int temp = 0;
        boolean bSwap = false;
        for (int i = 0; i < arr.length - 1; i++) {
            bSwap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    bSwap = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!bSwap) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * int[] arr = {6, 2, 1, 7, 5};
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int temp = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 插入排序
     * int[] arr = {6, 2, 1, 7, 5};
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    /**
     * 希尔排序
     * int[] arr = {6, 2, 1, 7, 5};
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - step >= 0 && arr[j - step] > temp) {
                    arr[j] = arr[j - step];
                    j -= step;
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * 堆排序
     * int[] arr = {6, 2, 1, 7, 5};
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left, r = mid + 1, t = 0;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[t++] = arr[l++];
        }
        while (r <= right) {
            temp[t++] = arr[r++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left, r = right, temp = 0;
        int pivot = arr[(l + r) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (l < right) {
            quickSort(arr, l, right);
        }
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        int maxLen = (maxVal + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElemCnt = new int[bucket.length];
        int temp = 0;
        for (int i = 0; i < maxLen; i++) { // 位数
            // 放入桶内
            for (int j = 0; j < arr.length; j++) {
                int digit = arr[j] / (int) Math.pow(10, i) % 10;
                bucket[digit][bucketElemCnt[digit]] = arr[j];
                bucketElemCnt[digit]++;
            }
            temp = 0;
            // 从桶中取出
            for (int j = 0; j < bucket.length; j++) {
                if (bucketElemCnt[j] != 0) {
                    for (int k = 0; k < bucketElemCnt[j]; k++) {
                        arr[temp++] = bucket[j][k];
                    }
                }
                bucketElemCnt[j] = 0;
            }
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int res = 1, slow = 0, fast = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (fast < s.length()) {
            char ch = s.charAt(fast);
            if (map.containsKey(ch)) {
                slow = Math.max(slow, map.get(ch) + 1);
            } else {
                res = Math.max(res, fast - slow + 1);
            }
            map.put(ch, fast);
            fast++;
        }
        return res;
    }

    /**
     * 最长回文子串
     * "babad"
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int maxLen = 0, len = 1, maxStartIndex = 0, l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            len = 1;
            l = i - 1;
            r = i + 1;
            while (l >= 0 && s.charAt(l) == s.charAt(i)) {
                len++;
                l--;
            }
            while (r < s.length() && s.charAt(r) == s.charAt(i)) {
                len++;
                r++;
            }
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                len += 2;
                l--;
                r++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStartIndex = l;
            }
        }
        return s.substring(maxStartIndex + 1, maxStartIndex + 1+ maxLen);
    }

}
