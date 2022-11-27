package com.example.demo.commom.sorts;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class QuaiSuTopKSort {




  public static void topK(int[] arr,int left,int right,int k){
      int partition = partition(arr, left, right);
      if(partition==k){
          int[] copyArr = Arrays.copyOf(arr, partition + 1);
          System.out.println(JSON.toJSONString(copyArr));
          return;
      }
      if(partition>k){
          topK(arr,left,partition-1,k);
      }else{
          topK(arr,partition+1,right,k);
      }
  }



    private static int partition(int[] arr,int l,int r){
        int pivot=arr[l];
        int i=l,j=r;
        int temp;
        while (j>i){
           while (j>i&&arr[j]<=pivot){
               j--;
           }
           while (j>i&&arr[i]>=pivot){
               i++;
           }
           if(j>i){
               temp=arr[j];
               arr[j]=arr[i];
               arr[i]=temp;
           }
        }
        arr[l]=arr[i];
        arr[i]=pivot;
        return j;
    }

}
