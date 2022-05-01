package com.spring.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We have a 2D grid with N rows and M columns. Each cell in the grid either has
 * a solid block or empty space. Some blocks may be floating above empty space.
 * Assume blocks are not sticky. In other words, a block in a column will move
 * independently of any blocks in neighboring columns. In the presence of
 * gravity, which blocks will move?
 * 
 * {{1, 0, 1, 0},
 * {0, 1, 1, 1}
 * {1, 1, 0, 1}}
 * 
 * [
 * [1, 1, 0],
 * [1, 0, 1]
 * [0, 0, 1]
 * ]
 * => [[0,0],[1,0],[0,1]]
 */
public class Test {

    public static List<List<Integer>> computeColumnMoves(int[][] arr) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int m = arr.length, n = arr[0].length;
        int i = m - 1, j = n - 1;
        while (i > 0) {
            if (arr[i][j] == 0) {
                if (arr[i - 1][j] == 1) {
                    resultList.add(Arrays.asList(i - 1, j));
                    int temp = arr[i][j];
                    arr[i][j] = arr[i-1][j];
                    arr[i-1][j] = temp;
                }
            }
            j--;
            if (j == -1) {
                j = n - 1;
                i--;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<List<Integer>> resultList = computeColumnMoves(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 1 } });
        System.out.println(resultList);
    }

}
