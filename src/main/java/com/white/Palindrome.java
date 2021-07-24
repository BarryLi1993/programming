package com.white;

public class Palindrome {
    public static void main(String[] args) {
        String str1="ceabbadcdeffedcty";
        String str2="tyabcbcoqkabba";

        System.out.println(maxPalindromeLen(str1));
        System.out.println(maxPalindromeLen(str2));
    }

    public static int maxPalindromeLen(String input) {
        if (input == null && input.length() <= 0) {
            return 0;
        }
        int maxLen = 1;
        for (int i = 1; i < input.length() - 1; i++) {
            int temp_max_Len = 1;
            if (input.charAt(i - 1) == input.charAt(i + 1)) {
                int left = i - 1;
                int right = i + 1;
                while (right < input.length() && left > 0 && input.charAt(left) == input.charAt(right)) {
                    temp_max_Len += 2;
                    left = left - 1;
                    right = right + 1;
                }
            } else if (input.charAt(i - 1) == input.charAt(i)) {
                int left = i - 1;
                int right = i;
                while (right < input.length() && left > 0 && input.charAt(left) == input.charAt(right)) {
                    temp_max_Len += 2;
                    left = left - 1;
                    right = right + 1;
                }
            }
            if (maxLen < temp_max_Len) {
                maxLen = temp_max_Len;
            }

        }
        return maxLen;
    }
}
