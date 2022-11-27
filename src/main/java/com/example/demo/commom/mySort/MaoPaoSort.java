package com.example.demo.commom.mySort;

public class MaoPaoSort {


    public static void main(String[] args) {
        int[] arr = new int[]{50,19,28,3,45,70,21,4,1};
        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.err.println(arr[i]);
        }
    }


    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    swip(arr, j, j + 1);
                }
            }
        }
    }

    public static void swip(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
