package com.example.demo.commom.mySort;

public class KuaiSuSort {

    public static void main(String[] args) {
        int[] arr = new int[]{50, 19, 28, 3, 45, 70, 21, 4, 1};
        //int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.err.println(arr[i]);
        }
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[left];
        int l = left;
        int r = right;
        int temp;
        while (l < r) {
            while (pivot <= arr[r]&&l < r) {
                r--;
            }
            while (pivot >= arr[l]&&l < r) {
                l++;
            }
            if (l < r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = pivot;

        sort(arr, left, r-1);
        sort(arr, r + 1, right);
    }


}
