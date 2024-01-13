package com.abusmac.threading.executors;

import java.util.concurrent.Callable;

public class IntReturningCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 100;
    }
}
