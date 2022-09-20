package Array;

import java.util.Random;

public class Array {

    Integer numindex;
    Integer[] arr;
    Integer[] arr2;

    public Array(Integer num) {
        numindex = num;
        arr = new Integer[numindex];
        arr2 = new Integer[numindex];

    }


    public Integer[] AddArray() {

        for (int i = 0; i < arr.length; i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(50) + 1;
        }
        return arr;
    }


    public Integer[] PereborIndexArray() {

        for (int i=0; i<arr2.length; i++)
        {
            if (i%2==0)
                arr2[i] = arr[i];
        }
        return  arr2;
    }
}
