package com.example.programmingexercise.practicequestions;

import java.util.List;
import java.util.Arrays;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty.");
        }

        // Initialize variables to store the two largest elements
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        // Iterate through the list to find the two largest elements
        for (int num : list) {
            if (num > max1) {
                max2 = max1;  // Update the second largest element
                max1 = num;   // Update the largest element
            } else if (num > max2) {
                max2 = num;   // Update the second largest element
            }
        }

        // Return the sum of the two largest elements
        return max1 + max2;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        // Should return 20, since 9 and 11 are the largest elements
        // and their sum is 20
        System.out.println(findMaxSum(list));
    }
}