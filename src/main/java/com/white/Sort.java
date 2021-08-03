package com.white;

public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 2, 4, 8, 5, 3};

        fastSort(array, 0, array.length - 1);

        for (int value : array) {
            System.out.println(value);
        }

    }

    public static void fastSort(int[] array, int low, int high) {
        if (array != null && low >= 0 && high >= 0 && low < high) {
            int baseIndex = low;
            int i = low, j = high;
            int value = array[baseIndex];
            while (low < high) {
                while (array[high] >= value && high > low) {
                    high--;
                }
                while (array[low] <= value && low < high) {
                    low++;
                }
                if (low < high) {
                    int temp = array[high];
                    array[high] = array[low];
                    array[low] = temp;
                }
            }
            array[baseIndex] = array[low];
            array[low] = value;
            fastSort(array, i, low - 1);
            fastSort(array, low + 1, j);
        }
    }
}
