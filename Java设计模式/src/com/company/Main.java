package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr = new int[]{2, 1, 6, 4, 7, 10, 0};
        bubble_sort(arr);
        arr = new int[]{2, 1, 6, 4, 7, 10, 0};
        InsertionSortWithPiquet(arr);
    }

    /**
     * 冒泡排序
     * @param arr 需要排序的数组
     */
    public static void bubble_sort(int [] arr){
        System.out.println("=== bubble_sort ===");
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j< arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
            print_arr(arr);

        }
    }


    /**
     * 带哨兵的直接排序
     * @param arr 需要排序的数组
     */
    public static void InsertionSortWithPiquet(int [] arr){
        System.out.println("=== InsertionSortWithPiquet ===");
        print_arr(arr);
        for(int i = 2; i<arr.length; i++){
            arr[0] = arr[i];
            for (int j = i-1 ; arr[j] > arr[0]; j--){
                arr[j+1] = arr[j];
                arr[j] = arr[0];
                print_arr(arr);
            }
        }
    }

    public static void print_arr(int[] arr){
        for (int value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
