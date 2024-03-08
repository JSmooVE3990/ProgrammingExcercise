package com.example.programmingexercise.practicequestions;

public class FindMissingPositive {

    public static int findMissingPositive(int[] A) {
        int n = A.length;

        // Create an array of size n+1 to handle cases where the missing number could be n+1
        int[] presence = new int[n + 1];

        // Iterate over the input array and mark the presence of elements (within range 1 to n)
        for (int num : A) {
            if (num > 0 && num <= n) {
                presence[num - 1] = 1;
            }
        }

        // Iterate over the presence array to find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (presence[i] == 0) {
                return i + 1;
            }
        }

        // If no missing integer is found within the range 1 to n, return n+1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 6, 4, 1, 2};
        System.out.println("Smallest missing positive in {1, 3, 6, 4, 1, 2} is: " + findMissingPositive(arr1)); // Output: 5

        int[] arr2 = {1, 2, 3};
        System.out.println("Smallest missing positive in {1, 2, 3} is: " + findMissingPositive(arr2)); // Output: 4

        int[] arr3 = {-1, -3};
        System.out.println("Smallest missing positive in {-1, -3} is: " + findMissingPositive(arr3)); // Output: 1
    }
}
