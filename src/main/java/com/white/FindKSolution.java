package com.white;

/*
   两个正序排序的数组，求合并后的第K个。(数组内元素没有重复数字; 数组没有0，找不到第 K 个数可以返回 0)

   示例 1：
   如果 K = 5
   >array1 = [1, 13, 16, 20]
   >array2 = [2, 8, 12, 27]
   >则第K个数是：13

   ====================================注意=========================================
   要求：不要申请额外的数组空间(List、Set、Map底层也是数组,不可使用)；
*/

public class FindKSolution {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 13, 16, 20};
        int[] array2 = new int[]{2, 8, 12, 27};
        int k = 5;
        System.out.println(find(array1, array2, k));
    }

    public static int find(int[] array1, int[] array2, int k) {
        int len_array1 = 0;
        int len_array2 = 0;
        if (array1 != null) {
            len_array1 = array1.length;
        }
        if (array2 != null) {
            len_array2 = array2.length;
        }
        int mergeIndex = 0;
        int i = 0, j = 0;
        while (i < len_array1 && j < len_array2) {
            if (array1[i] < array2[j]) {
                if (mergeIndex == k) {
                    return array1[i];
                }
                i++;
            } else {
                if (mergeIndex == k) {
                    return array2[j];
                }
                j++;
            }
            mergeIndex++;
        }
        if (i != len_array1) {
            while (i < len_array1) {
                if (mergeIndex == k) {
                    return array1[i];
                }
                i++;
                mergeIndex++;
            }
        } else {
            while (j < len_array2) {
                if (mergeIndex == k) {
                    return array2[j];
                }
                j++;
                mergeIndex++;
            }
        }
        return 0;
    }
}
