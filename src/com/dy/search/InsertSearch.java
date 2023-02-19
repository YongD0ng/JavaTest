package com.dy.search;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(insertSearch(arr, 0, arr.length - 1, 89));
    }

    public static int insertSearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int midIndex = left + ((findVal - arr[left]) / (arr[right] - arr[left])) * (right - left);
        if (arr[midIndex] > findVal) {
            return insertSearch(arr, left, midIndex - 1, findVal);
        } else if (arr[midIndex] < findVal) {
            return insertSearch(arr, midIndex + 1, right, findVal);
        } else {
            return midIndex;
        }
    }
}
