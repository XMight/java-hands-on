package com.abusmac.problems;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int[] arrayCopy = Arrays.copyOf(array, array.length);

        reverse(array);

        validateReversed(array, arrayCopy);

        array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        arrayCopy = Arrays.copyOf(array, array.length);

        reverse(array);

        validateReversed(array, arrayCopy);
    }

    private static void validateReversed(int[] array, int[] arrayCopy) {
        for(int i = 0; i < array.length; i++) {
            if(array[array.length - i - 1] != arrayCopy[i]) {
                throw new RuntimeException();
            }
        }
    }

    private static void reverse(int[] array) {
        int middle = array.length % 2 == 0 ? array.length / 2 - 1 : array.length / 2;
        for(int i = 0; i <= middle; i++) {
            int k = array.length - i - 1;
            int tmp = array[i];
            array[i] = array[k];
            array[k] = tmp;
        }
    }
}
