package com.white;

public class FindNearNumber {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 9, 16, 17,20,21,30,42,67};
        int target = 5;
        find(array,target);
    }

    public static int find(int[] array, int target) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int index = -1;
        int leftIndex = 0, rightIndex = array.length - 1;
        int middle = (rightIndex - leftIndex) / 2;
        int lMiddle = middle - 1 >= 0 ? middle - 1 : middle;
        int rMiddle = middle + 1 <= array.length - 1 ? middle + 1 : middle;
        while (lMiddle < rMiddle) {
            int middle_value = Math.abs(array[middle] - target);
            int left_value = Math.abs(array[lMiddle] - target);
            int right_value = Math.abs(array[rMiddle] - target);
            if (middle_value <= left_value && middle_value <= right_value) {
                index = middle;
                break;
            }else if (left_value<=middle_value && left_value<=right_value){
                rightIndex=lMiddle;
                middle = (rightIndex - leftIndex) / 2;
                lMiddle = middle - 1 >= 0 ? middle - 1 : middle;
                rMiddle = middle + 1 <= array.length - 1 ? middle + 1 : middle;
            }else {
                leftIndex = rMiddle;
                middle = (rightIndex - leftIndex) / 2 + leftIndex;
                lMiddle = middle - 1 >= 0 ? middle - 1 : middle;
                rMiddle = middle + 1 <= array.length - 1 ? middle + 1 : middle;
            }
        }
        return index;
    }
}
