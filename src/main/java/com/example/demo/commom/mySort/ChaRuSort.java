package com.example.demo.commom.mySort;

public class ChaRuSort {



    public static void main(String[] args) {
        int[] arr = new int[]{50, 19, 28, 3, 45, 70, 21, 4, 1};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.err.println(arr[i]);
        }
    }

    /**
     * 插入排序
     */
    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//要插入的值
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

}
