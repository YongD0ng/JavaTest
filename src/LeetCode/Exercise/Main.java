package LeetCode.Exercise;


import java.util.Arrays;

public class Main {
    private static final int ARRAY_MAX_LENGTH = 1;

    public static void main(String[] args) {
        int[] arr = {5, 1, 1, 2, 0, 0};
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= ARRAY_MAX_LENGTH) {
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

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= ARRAY_MAX_LENGTH) {
            return;
        }
        int minIndex = 0, temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= ARRAY_MAX_LENGTH) {
            return;
        }
        int insertIndex = 0, insertVal = 0;
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1;
            insertVal = arr[i];
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= ARRAY_MAX_LENGTH) {
            return;
        }
        int insertIndex = 0, insertVal = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                insertIndex = i - gap;
                insertVal = arr[i];
                while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                if (insertIndex + gap != i) {
                    arr[insertIndex + gap] = insertVal;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left, r = right, pivot = arr[(left + right) / 2], temp = 0;
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
            if (arr[l] <= arr[r]) {
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

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length <= ARRAY_MAX_LENGTH) {
            return;
        }

        for (int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}