package com.abusmac.sorting;

import java.util.Arrays;

public class SortingExamples {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 4, 7, 1, 2, 10, 0};
        Integer[] refInts = new Integer[]{3, 4, 7, 1, 2, 10, 0};

        Arrays.sort(refInts, Integer::compareTo);

        sort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));

        System.out.println(Arrays.toString(refInts));
    }

    private static void sort(int[] ints, int l, int r) {
        if (l < r) {
            int m = (r - l) / 2 + l;
            sort(ints, l, m);
            sort(ints, m + 1, r);

            merge(ints, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
        int l1 = m - l + 1;
        int l2 = r - m;

        int[] arr1 = new int[l1];
        int[] arr2 = new int[l2];

        for (int i = 0; i < l1; i++) {
            arr1[i] = array[l + i];
        }

        for (int i = 0; i < l2; i++) {
            arr2[i] = array[i + m + 1];
        }

        int i = 0, j = 0, k = l;
        while (i < l1 && j < l2) {
            if (arr1[i] < arr2[j]) {
                array[k] = arr1[i];
                i++;
            } else {
                array[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            array[k] = arr1[i];
            i++;
            k++;
        }

        while (j < l2) {
            array[k] = arr2[j];
            j++;
            k++;
        }
    }
}
