package com.company;

public class ArrayManipulation {

    private final int[][] query;

    public ArrayManipulation(final int[][] query) {
        this.query = query;
    }

    public int[] constructArrayWithGivenQuery() throws Exception {

        //Console output is not performance efficient but used for simplicity. Java Logger is recommended instead.

        final int n = this.query[0][0]; //number of elements in returning array
        if(n < 3 || n > 10000000) throw new Exception("Array size must be between 3 and 10^7");

        final int m = this.query[0][1]; //number of operations
        if(m < 1 || m > 200000) throw new Exception("Number of operations must be between 1 and 2*10^5");

        int[] array = new int[n]; //init with zeros

        for (int i = 1; i <= m; i++) {
            try {
                int a = this.query[i][0]; //first index
                if(a < 1 ) throw new Exception("Indices cannot be lower than 1.");

                int b = this.query[i][1]; //second index
                if(b < a) throw new Exception("Second index cannot be lower than first index.");
                if(b > n) throw new Exception("Indices cannot be higher than array size.");

                int k = this.query[i][2]; //increment
                if(k < 0 || k > Math.pow(10,9)) throw new Exception("Increment value must be between 1 and 10^9.");


                for (int j = a-1; j <= b-1; j++) {
                    array[j] += k;
                }
            }catch (Exception e){
                System.out.println(e + " Skipping " + i +". operation");
            }
        }

        return array;
    }
}
