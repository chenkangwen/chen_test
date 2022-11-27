package com.example.demo.commom.mySort;

public class XiErSort {


    public static void main(String[] args) {
        int[] arr = new int[]{50,19,19,28,3,45,70,21,4,1};
        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.err.println(arr[i]);
        }
    }


    private static void sort(int[] arr){
        for (int gap=arr.length/2;gap>0;gap=gap/2){
             for (int i=gap;i<arr.length;i++){
                 int index=arr[i];
                 int j=i-gap;
                 while (j>=0&&arr[j]>index){
                     arr[j+gap]=arr[j];
                     j=j-gap;
                     //System.out.println(j);
                 }
                 arr[j+gap]=index;
             }
        }
    }
}
