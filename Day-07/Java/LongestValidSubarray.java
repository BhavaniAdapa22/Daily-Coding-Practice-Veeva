/*You are given an integer array arr of length N.

A valid subarray is a contiguous subarray in which the difference between the maximum and minimum element is at most K.

Find the length of the longest valid subarray.*/

import java.util.*;

public class LongestValidSubarray {
    public static void main(String[] args) {

        int[] arr = {1, 3, 6, 7, 4, 2, 5, 3};
        int K = 3;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int answer = 0;

        for (int right = 0; right < arr.length; right++) {

            // 1. Maintain MAX deque
            while (!maxDeque.isEmpty() &&
                   arr[maxDeque.peekLast()] <= arr[right]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(right);


            // 2. Maintain MIN deque
            while (!minDeque.isEmpty() &&
                   arr[minDeque.peekLast()] >= arr[right]) {
                minDeque.removeLast();
            }
            minDeque.addLast(right);


            // 3. Check whether window is invalid
            while (arr[maxDeque.peekFirst()] -
                   arr[minDeque.peekFirst()] > K) {

                // If left element is present in maxDeque, remove it
                if (maxDeque.peekFirst() == left) {
                    maxDeque.removeFirst();
                }

                // If left element is present in minDeque, remove it
                if (minDeque.peekFirst() == left) {
                    minDeque.removeFirst();
                }

                left++;
            }


            // 4. Current window length
            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }
}
