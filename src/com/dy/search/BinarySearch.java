package com.dy.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};
//        System.out.println(binarySearch(arr, 0, arr.length - 1, 1000));

        System.out.println(Arrays.toString(binarySearch2(arr, 0, arr.length - 1, 1000).toArray()));
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int midIndex = (left + right) / 2;
        if (arr[midIndex] < findVal) {
            return binarySearch(arr, midIndex + 1, right, findVal);
        } else if (arr[midIndex] > findVal) {
            return binarySearch(arr, left, midIndex - 1, findVal);
        } else {
            return midIndex;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int midIndex = (left + right) / 2;
        if (arr[midIndex] < findVal) {
            return binarySearch2(arr, midIndex + 1, right, findVal);
        } else if (arr[midIndex] > findVal) {
            return binarySearch2(arr, left, midIndex - 1, findVal);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(midIndex);
            int l = midIndex -1, r = midIndex + 1;
            while (l >= 0 && arr[l] == findVal) {
                list.add(l--);
            }
            while (r <= arr.length - 1 && arr[r] == findVal) {
                list.add(r++);
            }
            return list;
        }
    }
}
