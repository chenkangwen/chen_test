package com.example.demo.commom.mySort;

public class DuiSort {


    public static void main(String[] args) {
        int[] arr = new int[]{50,19,28,3,45,70,21,4,1};
        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.err.println(arr[i]);
        }
    }


    private static void sort(int[] arr){
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        for (int i=arr.length-1;i>0;i--){
            swip(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }



    private static void adjustHeap(int[] arr,int index,int length){
        int temp=arr[index];
        for (int k=2*index+1;k<length;k=2*k+1){
            if(k+1<length&&arr[k+1]>arr[k]){
                k=k+1;
            }
            if(arr[k]>arr[index]){
                arr[index]=arr[k];
                index=k;
            }else{
                break;
            }
        }
        arr[index]=temp;
    }

    private static void swip(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
