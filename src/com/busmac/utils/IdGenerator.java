package com.busmac.utils;

public class IdGenerator {
    private static ThreadLocal<Integer> id = ThreadLocal.withInitial(() -> 0);

    public static int getNextId() {
        Integer integer = id.get();
        id.set(integer + 1);

        return integer;
    }
}
