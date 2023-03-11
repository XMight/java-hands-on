package com.abusmac.sorting;

import java.util.Arrays;

public class SortingExamples implements Runnable {
    @Override
    public void run() {
        Integer[] ints = new Integer[]{3, 4, 7, 1, 2, 10, 0};
        Arrays.sort(ints, (i1, i2) -> {
            if ((Integer) i1 < (Integer) i2) return -1;
            else if ((Integer) i1 > (Integer) i2) return 1;
            else return 0;
        });
    }
}
