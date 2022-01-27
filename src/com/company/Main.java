package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        final int[][] query = new int[][]{{5, 3, 0}, {1, 2, 100}, {2, 5, 100}, {3, 4, 100}};

        //check if valid query
        for (int[] ints : query) {
            if (ints.length != 3) throw new Exception("All rows must be equal to 3");
        }

        final ArrayManipulation arrayManipulation = new ArrayManipulation(query);

        final int[] constructedArray = arrayManipulation.constructArrayWithGivenQuery();

        System.out.println(Arrays.stream(constructedArray).max().getAsInt()); //print maximum element of the array
    }
}
