package com.spring.core;

import java.util.Stack;

public class FindShadowTrees {
    /**
     * Input-> [ 2, 3, 9, 4, 1 , 2, 5]
     * Output-> [3, 9, 0, 5, 2, 5, 0]
     * 
     * @param arr
     * @return
     */
    public static int[] findShadowTrees(int arr[]) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        result[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < arr[i])
                stack.pop();

            if (stack.isEmpty()) {
                result[i] = 0;
                stack.push(arr[i]);
            } else
                result[i] = stack.peek();

            if (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.push(arr[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = findShadowTrees(new int[] { 2, 3, 9, 4, 1, 2, 5 });
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
